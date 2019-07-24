package org.sid.services;

import java.util.Date;
import java.util.List;

import org.sid.dao.InterfaceTableRepository;
import org.sid.dao.ZepRepository;
import org.sid.entities.InterfaceTable;
import org.sid.entities.Zep;
import org.sid.util.GenererOper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ControleService {
@Autowired
InterfaceTableRepository interfaceTableRepository;
@Autowired
ZepRepository zepRepository;
public List<InterfaceTable> ZepControl(Date dateNuit){
	List<InterfaceTable> interfaceTables;
	List<InterfaceTable> interfaceTablest;
	interfaceTables=interfaceTableRepository.afficheAHT(dateNuit);
	List<Zep> zeps=zepRepository.findAll();
	interfaceTablest=GenererOper.ControleZep(interfaceTables,zeps);
	interfaceTableRepository.saveAll(interfaceTablest);
		return interfaceTablest;
	}
}
