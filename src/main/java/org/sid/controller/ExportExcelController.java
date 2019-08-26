package org.sid.controller;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.sid.dao.InterfaceTableRepository;
import org.sid.entities.InterfaceTable;
import org.sid.util.ExportExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200")
@RestController 
public class ExportExcelController {
	@Autowired
	InterfaceTableRepository interfaceTableRepo;
	@GetMapping("/ExportExcel")
	 public ResponseEntity<InputStreamResource> excelExportReport() throws IOException {
		
	       List<InterfaceTable> interfaceTables=interfaceTableRepo.findAll();
	       ByteArrayInputStream in =ExportExcel.ahtToExcel(interfaceTables);
	       HttpHeaders headers = new HttpHeaders();
	       headers.add("Content-Disposition", "attachment; filename=AHT.xlsx");
   
    return ResponseEntity
                 .ok()
                 .headers(headers)
                 .body(new InputStreamResource(in));
   }
       
}

