package org.sid.controller;

import java.util.Date;
import java.util.List;

import org.sid.entities.InterfaceTable;
import org.sid.services.FileLaplacePlanDeChargeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreationAHTController {
	@Autowired 
	FileLaplacePlanDeChargeServices fileLaplacePlanDeChargeServices ; 
	@GetMapping("/AHT")
    public String index() {
        return "AHT.html";
}
	@GetMapping("genererAht{date}")
	public String getOpe(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,Model model){
		try {
		String msg=fileLaplacePlanDeChargeServices.creerAht(date);
		model.addAttribute("msg", ""+msg);
		
	} catch (Exception e) {
		model.addAttribute("message", " Date invalide!!!");
	}
		
		return "AHT.html";
		
	}
	@GetMapping("ListAht")
	public String ListAht(Model model) {
		List<Date> pageAht=fileLaplacePlanDeChargeServices.ListAht();
		model.addAttribute("page",pageAht);
		return "AHT.html";
	}
}