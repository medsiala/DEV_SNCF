package org.sid.controller;

import org.sid.dao.RPTXRepository;
import org.sid.dao.ZepRepository;
import org.sid.entities.RPTX;
import org.sid.entities.Zep;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StaticDataController {
    private RPTXRepository rptxRepository;
    
    public StaticDataController(RPTXRepository rptxRepository) {
		super();
		this.rptxRepository = rptxRepository;
	}
	
    @GetMapping("/rptxs")
    public Iterable<RPTX> getRPTXS() {
        return rptxRepository.findAll();
    }
   
    
}