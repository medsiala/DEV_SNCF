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

import org.sid.dao.CREQRepository;
import org.sid.dao.CatenaireRepository;
import org.sid.dao.LaplacePlanDeChargeRepository;
import org.sid.dao.OperaCatRepository;
import org.sid.dao.OperaZepRepository;
import org.sid.dao.OperationRepository;
import org.sid.dao.RPTXRepository;
import org.sid.dao.TrainTravauxRepository;
import org.sid.dao.ZepRepository;
import org.sid.entities.CREQ;
import org.sid.entities.LaplacePlanDeCharge;
import org.sid.entities.Operation;
import org.sid.entities.OperationCat;
import org.sid.entities.OperationZep;
import org.sid.entities.RPTX;
import org.sid.entities.TrainsTravaux;
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
	@Autowired
	TrainTravauxRepository trainTravauxRepository;
	@Autowired
	CREQRepository creqRepository;
	@Autowired
	ZepRepository zepRepository;
	@Autowired
	OperaZepRepository operaZepRepository;
	@Autowired
	OperaCatRepository operaCatRepository;
	@Autowired
	CatenaireRepository catenaireRepository;
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
	public void deletOperation() {
		 operaCatRepository.deleteAll();
		 operationRepository.deleteAll();
		 operaZepRepository.deleteAll();
		 creqRepository.deleteAll();
		 rptxRepository.deleteAll();
		
	}
	public List<Object[]> selectact( Date dateNuit){ 
		deletOperation();
		 List<Object[]> lap =laplacePlanDeChargeRepository.findLAplaceChargesByidActivites(dateNuit);
		List<Operation> ops= GenererOper.SaveOper(lap);
		operationRepository.saveAll(ops);
		List<Object[]> rptxs=laplacePlanDeChargeRepository.findLAplaceChargesByRPTX(dateNuit);
		
		List<RPTX> rptx=GenererOper.FindRptx(rptxs);
		rptxRepository.saveAll(rptx);
		List<Object[]> ttxob=laplacePlanDeChargeRepository.findLAplaceChargesByTTX(dateNuit);
		List<Object[]> creqob=laplacePlanDeChargeRepository.findLAplaceChargesByCREQ(dateNuit);
		
		
		List<TrainsTravaux> ttx =GenererOper.findTTX(ttxob);
		List<CREQ> creq =GenererOper.findCreq(creqob);
		trainTravauxRepository.saveAll(ttx);
		creqRepository.saveAll(creq);
		for(Operation op:ops) { 
		List<Object[]> zepob =zepRepository.findZEp(op.getPkDebut(), op.getPkFin(),op.getLigne());
	    List<OperationZep> zepOp=GenererOper.findZep(zepob, op);
	    operaZepRepository.saveAll(zepOp);
	    
		}
		List<Operation> opsCat= operationRepository.findOperaCat();
		for(Operation op:opsCat) { 
		    List<Object[]> catOb=catenaireRepository.findCat(op.getPkDebut() ,op.getPkFin());
		    List<OperationCat> catOp=GenererOper.findCat(catOb, op);
		    operaCatRepository.saveAll(catOp);
			}
		List<Object[]> aht =operationRepository.AHT();
			
		 return aht ;
		
		
	}
	
	

	
	public List<LaplacePlanDeCharge> getAll (){
		return laplacePlanDeChargeRepository.findAll() ; 
	}
	
}
