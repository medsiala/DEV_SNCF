package org.sid.controller;

import java.util.List;

import org.sid.entities.LaplacePlanDeCharge;
import org.sid.services.FileCatServices;
import org.sid.services.FileLaplacePlanDeChargeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@Controller
public class UploadFileControllerLaplace {
	@Autowired
	FileLaplacePlanDeChargeServices fileLaplacePlanDeChargeServices ;
	@Autowired
	FileCatServices catServices;
    @PostMapping("uploadLaplace")
    public String uploadLaplace(@RequestParam("uploadLaplace") MultipartFile file, Model model) {
    	
		try {
			fileLaplacePlanDeChargeServices.storeLaplace(file);
			 
			model.addAttribute("message", "Importation réussie");
			catServices.selectSecCat();
		} catch (Exception e) {
			model.addAttribute("message", "Importation Échouée ! -> Nom du fichier: " + file.getOriginalFilename());
		}
        return "upload.html";
    }
    
     
    
    
    
}
