package org.sid.services;


import java.io.IOException;
import java.util.List;

import org.sid.dao.ZepRepository;
import org.sid.entities.Zep;
import org.sid.entities.ZepNORD;
import org.sid.util.ExcelUtilsSNORD;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FileSNORDServices{
	
	@Autowired
	ZepRepository zepRepository ; 
	
	// Store File Data to Database
	public void store(MultipartFile file){
		
		try {
			List<ZepNORD> listZeps = ExcelUtilsSNORD.parseExcelFile(file.getInputStream());
    		// Save Customers to DataBase
			System.out.println("Save Customers to DataBase");
			System.out.println(listZeps);
    		zepRepository.saveAll(listZeps);
        } catch (IOException e  ) {
        	throw new RuntimeException("FAIL! -> message = " + e.getMessage());
       
        }
	
	}
	public void deletImportNord() {
		 zepRepository.deleteImport("SNOR");
	}
}