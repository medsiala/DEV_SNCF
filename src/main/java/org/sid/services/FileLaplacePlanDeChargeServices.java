package org.sid.services;

import java.io.IOException;
 
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.sid.dao.LaplacePlanDeChargeRepository;
import org.sid.dao.OperationRepository;
import org.sid.dao.RPTXRepository;
import org.sid.entities.LaplacePlanDeCharge;
import org.sid.entities.Operation;
import org.sid.entities.RPTX;
import org.sid.util.ExcelUtilsLaplacePlanDeCharge;
import org.sid.util.GenererOper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

import ch.qos.logback.core.read.ListAppender;
@Service
public class FileLaplacePlanDeChargeServices {
	@Autowired
	LaplacePlanDeChargeRepository laplacePlanDeChargeRepository ;
	@Autowired
	OperationRepository operationRepository;
	@Autowired
	RPTXRepository rptxRepository ;
	// Store File Data to Database
	public void storeLaplace(MultipartFile file){
		
		try {
			List<LaplacePlanDeCharge> listLaplacePlanDeCharges = ExcelUtilsLaplacePlanDeCharge.parseExcelFile(file.getInputStream());
    		// Save Customers to DataBase
			System.out.println("Save Customers to DataBase");
    		laplacePlanDeChargeRepository.saveAll(listLaplacePlanDeCharges);
    		
  
        } catch (IOException e) {
        	throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
	}
	public void deletLaplace() {
		 laplacePlanDeChargeRepository.deleteAll();
	}
	public List<Object[]> selectact( Date dateNuit){ 
		
//		DateFormat df = new SimpleDateFormat("dd-MM-yyyy"); 
//		Date date=null;
//		try
//		{
//		  date= df.parse("23-04-2019");
		 List<Object[]> lap =laplacePlanDeChargeRepository.findLAplaceChargesByidActivites(dateNuit);
		List<Operation> ops= GenererOper.SaveOper(lap);
		operationRepository.saveAll(ops);
		List<Object[]> rptxs=laplacePlanDeChargeRepository.findLAplaceChargesByRPTX(dateNuit);
		for(Operation op:ops) {
		List<RPTX> rptx=GenererOper.FindRptx(rptxs);
		rptxRepository.saveAll(rptx);
		
		System.out.println();
		}
		 return lap ;
		 
		/*List<LaplacePlanDeCharge> lapDist = lap.stream()
				 							.filter(distinctByKey(LaplacePlanDeCharge::getIdActivites))
				 							.collect(Collectors.toList());*/
				 	 
		 
		//} catch (ParseException e){
		//  e.printStackTrace();
		//} 
		 
		
		
		
		
		
	}
	
	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
	    Set<Object> seen = ConcurrentHashMap.newKeySet();
	    return t -> seen.add(keyExtractor.apply(t));
	}
	
	public List<LaplacePlanDeCharge> getAll (){
		return laplacePlanDeChargeRepository.findAll() ; 
	}
	
}
