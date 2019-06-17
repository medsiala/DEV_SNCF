package org.sid.controller;

import org.sid.services.FileCatServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadFileControllerCat {
	@Autowired
	FileCatServices catServices;
	
	@PostMapping("uploadCatenaire")
	public String uploadCat(@RequestParam("uploadCatenaire") MultipartFile file, Model model ) {
		catServices.deletLaplace();
		try {
			catServices.storeCat(file);
			model.addAttribute("messageC", "Importation réussie");
		} catch (Exception e) {
			model.addAttribute("messageC", "Importation Échouée ! -> Nom du fichier: " + file.getOriginalFilename());
		}
        return "upload.html";
    }	
}
	


