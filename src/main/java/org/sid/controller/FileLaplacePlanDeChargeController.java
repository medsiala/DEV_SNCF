package org.sid.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.mapping.Array;
import org.sid.entities.LaplacePlanDeCharge;
import org.sid.services.FileLaplacePlanDeChargeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController 
public class FileLaplacePlanDeChargeController {

	  
	@Autowired 
	FileLaplacePlanDeChargeServices fileLaplacePlanDeChargeServices ; 
	
	
	@GetMapping("/getAll")
	@ResponseBody
	public List<Object[]> selectact (@RequestParam Date dateNuit){
	    
		List<Object[]> laPlacePlanDeCharges ;
		laPlacePlanDeCharges = fileLaplacePlanDeChargeServices.selectact(dateNuit) ; 
		
		
		return laPlacePlanDeCharges ;
		
	}
	
}
