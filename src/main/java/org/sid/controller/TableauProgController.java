package org.sid.controller;

import java.util.Date;
import java.util.List;

import org.sid.dao.InterfaceTableRepository;
import org.sid.dao.OperaZepRepository;
import org.sid.dao.OperationRepository;
import org.sid.dao.ZepRepository;
import org.sid.entities.InterfaceTable;
import org.sid.entities.OperationZep;
import org.sid.entities.Zep;
import org.sid.services.ControleService;
import org.sid.services.FileLaplacePlanDeChargeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200")
@RestController 
public class TableauProgController {
	
	
	@Autowired 
	FileLaplacePlanDeChargeServices fileLaplacePlanDeChargeServices ; 
	@Autowired 
	OperationRepository operationReposotory ;
	@Autowired 
	InterfaceTableRepository interfaceTableRepository;
	@Autowired 
	ZepRepository zepRepository;
	@Autowired 
	OperaZepRepository operaZepRepository;
	@Autowired
	ControleService controleService;
	
	public TableauProgController(OperationRepository operationReposotory) {
		super();
		this.operationReposotory = operationReposotory;
	}
	
	
	@GetMapping("/getAll")
	@ResponseBody
	public void selectact (){
	
		fileLaplacePlanDeChargeServices.selectact() ; 
		
	}
	
	
	
	@GetMapping("/getAllOps{date}")
	public Iterable<InterfaceTable> afficheAht(@RequestParam Date date){
		List<InterfaceTable> interfaceTables;
		interfaceTables=interfaceTableRepository.afficheAHT(date);
		return interfaceTables;
	}
	
	@PostMapping("/ops")
	public InterfaceTable saveOp(@RequestBody InterfaceTable interfaceTable) {
		return interfaceTableRepository.save(interfaceTable);
	}
	

	
	@DeleteMapping("/deleteOp/{id}")
	public  void deleteOp(@PathVariable("id") Long id) {
		interfaceTableRepository.deleteById(id);
		
	}
	@GetMapping("/getAllZEpSud")
	public Iterable<Zep> getZepSud(){
		return zepRepository.findAll();
	}
	@GetMapping("/getopZEp")
	public Iterable<OperationZep> getOpZep(){
		return operaZepRepository.findAll();
	}
	@GetMapping("/ZepControl{dateNuit}")
	public Iterable<InterfaceTable> InterfaceTable(@RequestParam Date dateNuit) {
		List<InterfaceTable> interfaceTables;
		interfaceTables=controleService.ZepControl(dateNuit);
		return interfaceTables;
	}
	}
	
	
