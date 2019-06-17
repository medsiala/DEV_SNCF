package org.sid.services;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.sid.dao.CatenaireRepository;
import org.sid.entities.Catenaire;
import org.sid.util.ExcelUtilsCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileCatServices {
	@Autowired
	CatenaireRepository catenaireRepository ;
	public void storeCat(MultipartFile file) {
	try {
		List<Catenaire> listCats = ExcelUtilsCat.parseExcelFile(file.getInputStream());
		// Save Customers to DataBase
		catenaireRepository.saveAll(listCats);
    } catch (IOException e) {
    	throw new RuntimeException("FAIL! -> messageC = " + e.getMessage());
    	}
	}
public void deletLaplace() {
	 catenaireRepository.deleteAll();
}

}
