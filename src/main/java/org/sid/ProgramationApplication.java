package org.sid;





import org.sid.dao.OperationRepository;
import org.sid.dao.RPTXRepository;
import org.sid.dao.RoleRepository;
import org.sid.dao.TrainTravauxRepository;
import org.sid.dao.UsersRepository;
import org.sid.dao.ZepRepository;
import org.sid.entities.LaplacePlanDeCharge;
import org.sid.entities.Operation;
import org.sid.entities.RPTX;
import org.sid.entities.Role;
import org.sid.entities.TrainsTravaux;
import org.sid.entities.Users;
import org.sid.entities.ZepNORD;
import org.sid.entities.ZepSUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ProgramationApplication implements CommandLineRunner {
@Autowired
private OperationRepository operationRepository ;
@Autowired
private TrainTravauxRepository trainTravauxRepository ;
@Autowired
private RPTXRepository rptxRepository ;
@Autowired
private ZepRepository zepRepository ;
@Autowired
private UsersRepository usersRepository;
@Autowired
private RoleRepository roleRepository;
	public static void main(String[] args) {
		SpringApplication.run(ProgramationApplication.class, args);
		
	}
	@Override
	public void run (String...arg0)throws Exception {
		/*Operation o1 = operationRepository.save(new Operation(122, "lyon","", "voie", 555,578, new java.util.Date(), new java.util.Date())) ;
		 trainTravauxRepository.save(new TrainsTravaux("emv","siala",o1));
		 rptxRepository.save(new RPTX("med",o1));
//		 zepRepository.save(new ZepSUD(122,"501", 300.300, 300.300, "poste", "numPoste", "voieA", "voieB", "voieC", "voieD", "voieE", "voieF", "voieG", 75222, 7520, 8520, "secteur", "ttxAut", "groupZep"));
		 Users ad=new Users("Admin", "admin", true);
		 usersRepository.save(ad);
	 		Role rad=new Role("ADMIN");
	 		Collection<Role> rads = null ;
	 	
	 		
	 		roleRepository.save(rad);
	 		
	 		usersRepository.save(ad);*/
	 	
	 		 
	}	
	

}
