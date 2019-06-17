package org.sid.controller;


import org.sid.services.FileSNORDServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadFileControllerSNord {
	@Autowired
	FileSNORDServices fileSNORDServices ;
	
    
    @PostMapping("uploadfileSNORD")
    public String uploadSNORD(@RequestParam("uploadfileSNORD") MultipartFile file, Model model) {
    	//fileSNORDServices.deletImportNord();
		try {
			fileSNORDServices.store(file);
			model.addAttribute("messageN", "fichier correctement chargé!");
		} catch (Exception e) {
			model.addAttribute("messageN", "Échouer! -> Nom du fichier: " + file.getOriginalFilename());
		}
        return "upload.html";
    }
}
