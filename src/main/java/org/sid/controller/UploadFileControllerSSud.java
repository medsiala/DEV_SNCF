package org.sid.controller;


import org.sid.services.FileSNORDServices;
import org.sid.services.FileSSUDServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadFileControllerSSud {
	@Autowired
	FileSSUDServices fileSSUDServices ;
	FileSNORDServices fileSNORDServices ;
	
    @GetMapping("/upload")
    public String index() {
        return "upload.html";
    }
    
    
    @PostMapping("uploadfileSSUD")
    public String uploadSSUD(@RequestParam("uploadfileSSUD") MultipartFile file, Model model) {
    	fileSSUDServices.deletImportSud();
		try {
			fileSSUDServices.store(file);
			model.addAttribute("messageS", "fichier correctement chargé!");
		} catch (Exception e) {
			model.addAttribute("messageS", "Échouer! -> Nom du fichier: " + file.getOriginalFilename());
		}
        return "upload.html";
    }
   
    }

