package org.sid.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.sid.dao.OperationRepository;
import org.sid.entities.Operation;
import org.sid.services.FileLaplacePlanDeChargeServices;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	OperationRepository operationReposotory ;
	
	
	public TableauProgController(OperationRepository operationReposotory) {
		super();
		this.operationReposotory = operationReposotory;
	}


	@GetMapping("/getAll")
	@ResponseBody
	public List<Object[]> selectact (@RequestParam Date dateNuit){
	    
		List<Object[]> laPlacePlanDeCharges ;
		laPlacePlanDeCharges = fileLaplacePlanDeChargeServices.selectact(dateNuit) ; 
		
		
		return laPlacePlanDeCharges ;
		
	}
	
	
	@GetMapping("/getAllOps")
	public Iterable<Operation> getOpe(){
		return operationReposotory.findAllByOrderByLigneAsc();
	}
	
	@PostMapping("/ops")
	public Operation saveOp(@RequestBody Operation operation) {
		return operationReposotory.save(operation);
	}
	
	@GetMapping("/saveOp")
	public Optional<Operation> getOp(@RequestParam(value = "id") Long id) {
		return operationReposotory.findById(id);
	}
	
	@DeleteMapping("/deleteOp/{id}")
	public boolean deleteOp(@PathVariable("id") Long id) {
		operationReposotory.deleteById(id);
		return true;
	}
	
	
	}
