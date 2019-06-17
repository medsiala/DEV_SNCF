package org.sid.services;
import java.io.IOException;
import java.util.List;
import org.sid.dao.ZepRepository;
import org.sid.entities.Zep;
import org.sid.entities.ZepSUD;
import org.sid.util.ExcelUtilSSUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FileSSUDServices{
	
	@Autowired
	ZepRepository zepRepository ; 
	
	// Store File Data to Database
	public void store(MultipartFile file){
		
	
		try {
			List<ZepSUD> listZeps = ExcelUtilSSUD.parseExcelFile(file.getInputStream());
    		// Save Customers to DataBase
			
    		zepRepository.saveAll(listZeps);
        } catch (IOException e) {
        	throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
	}
	public void deletImportSud() {
		 zepRepository.deleteImport("SSUD");
	}
}