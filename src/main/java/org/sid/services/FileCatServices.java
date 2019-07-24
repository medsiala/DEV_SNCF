package org.sid.services;

import java.io.IOException;
import java.util.List;

import org.sid.dao.CatenaireRepository;
import org.sid.dao.OperaCatRepository;
import org.sid.dao.OperationRepository;
import org.sid.entities.Catenaire;
import org.sid.entities.Operation;
import org.sid.entities.OperationCat;
import org.sid.util.ExcelUtilsCat;
import org.sid.util.GenererOper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileCatServices {
	@Autowired
	CatenaireRepository catenaireRepository ;
	@Autowired
	OperaCatRepository operaCatRepository ;
	@Autowired
	OperationRepository operationRepository;
	public void storeCat(MultipartFile file) {
	try {
		List<Catenaire> listCats = ExcelUtilsCat.parseExcelFile(file.getInputStream());
		catenaireRepository.saveAll(listCats);
    } catch (IOException e) {
    	throw new RuntimeException("FAIL! -> messageC = " + e.getMessage());
    	}
	}
	
public void selectSecCat() {
	
	List<Operation> opsCat= operationRepository.findOperaCat();
	for(Operation op:opsCat) { 
	    List<Object[]> catOb=catenaireRepository.findCat(op.getPkDebut() ,op.getPkFin());
	    List<OperationCat> catOp=GenererOper.findCat(catOb, op);
	    operaCatRepository.saveAll(catOp);
		}
	
}
	public void deletLaplace() {
		catenaireRepository.deleteAll();
}

}