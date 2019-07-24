package org.sid.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.sid.entities.CREQ;
import org.sid.entities.InterfaceTable;
import org.sid.entities.Operation;
import org.sid.entities.OperationCat;
import org.sid.entities.OperationZep;
import org.sid.entities.RPTX;
import org.sid.entities.TrainsTravaux;
import org.sid.entities.Zep;


public class GenererOper {

		public static List<Operation> SaveOper(List<Object[]> ops){
			
			List<Operation> operations =new ArrayList<Operation>();
		int i=0;
		while(i<ops.size()) {
			
			Operation operation =new Operation();
			Object[] op=ops.get(i);
			double id=((double) op[0]);
			operation.setIdActivites(id);
			
			String strucResp=((String) op[1]);
			operation.setStrucResp(strucResp);
			
			String libAct=((String) op[2]);
			operation.setLibAct(libAct);
			
			String capcite=((String) op[3]);
			operation.setCapacite(capcite);
			
			double pkDebut=((double) op[4]);
			operation.setPkDebut(pkDebut);
			
			double pkFin=((double) op[5]);
			operation.setPkFin(pkFin);
			
			Date dateDebut=((Date) op[6]);
			operation.setDateDebut(dateDebut);
			
			Date dateFin=((Date) op[7]);
			operation.setDateFin(dateFin);
			
			double ligne=((double) op[8]);
			operation.setLigne(ligne);
			
			String com=((String) op[9]);
			operation.setCom(com);
			
			String libelleVoie=((String)op[10]);
			operation.setLibelleVoie(libelleVoie);
			
			
			operations.add(operation);
			i++;
		}
		
		return operations ;
		

		}
		public static List<RPTX> FindRptx(List<Object[]> rptxs){
			List<RPTX> listRptx =new ArrayList<RPTX>();
			int i=0;
			
			while(i<rptxs.size()) {
				
				RPTX rptx =new RPTX();
				Object[] rp=rptxs.get(i);
				String nomRptx=((String) rp[1]);
				rptx.setRptx(nomRptx);
				
				double id=((double) rp[0]);
				rptx.setIdActivites(id);
				
				listRptx.add(rptx);
				i++;
		}
			
		   return listRptx;
		}
		
		public static List<TrainsTravaux> findTTX(List<Object[]> ttx){
			List<TrainsTravaux> listTtxs =new ArrayList<TrainsTravaux>();
			int i=0;
			while (i<ttx.size()) {
				TrainsTravaux ttx1=new TrainsTravaux();
				Object[] ttxOb=ttx.get(i);
				
				String refTtx=((String) ttxOb[1]);
				ttx1.setTtx(refTtx);
				System.out.print(ttx1);
				double id=((double) ttxOb[0]);
				ttx1.setIdActivites(id);
				
				
				listTtxs.add(ttx1);
				i++;
			}
			return listTtxs;
		}
		public static List<CREQ> findCreq(List<Object[]> creq){
			List<CREQ> listCREQ =new ArrayList<CREQ>();
			int i=0;
			while (i<creq.size()) {
				CREQ creq1=new CREQ();
				Object[] ttxOb=creq.get(i);
				String conducteur=((String) ttxOb[1]);
				creq1.setConducteur(conducteur);
			
				
				double id=((double) ttxOb[0]);
				creq1.setIdActivites(id);
				
				listCREQ.add(creq1);
				i++;
			}
			return listCREQ;
		}
		public static List<OperationZep> findZep(List<Object[]> zepOb,Operation op){
		List<OperationZep> listZepsOp =new ArrayList<OperationZep>();
		int i=0 ;
		
			
			while(i<zepOb.size()) {
				OperationZep opZep1=new OperationZep();
				Object[] zepOb1=zepOb.get(i);
				String zepOp=((String) zepOb1[0]);
				opZep1.setZep(zepOp);
				double pkdebut=((double) zepOb1[1]);
				opZep1.setPkdebut(pkdebut);
				double pkfin=((double) zepOb1[2]);
				opZep1.setPkfin(pkfin);
				opZep1.setMinPk(pkfin-pkdebut);
			    opZep1.setIdActivites(op.getIdActivites());
			    
			    listZepsOp.add(opZep1);
			    i++;
			    
			
			}
		return listZepsOp;
		}
		public static List<OperationCat> findCat(List<Object[]> catOb,Operation op){
			List<OperationCat> listCatOp=new ArrayList<OperationCat>();
			int i=0;
			while (i<catOb.size()) {
				
				OperationCat opCat1=new OperationCat();
				Object[] catOb1=catOb.get(i);
				String catOp=((String) catOb1[0]);
				opCat1.setSectCat(catOp);
				opCat1.setIdActivites(op.getIdActivites());
				listCatOp.add(opCat1);
				
				
				i++;
			}
			return listCatOp;
		}
		public static List<InterfaceTable> AffTable(List<Object[]> tabs){
			List<InterfaceTable> interfaceTables =new ArrayList<InterfaceTable>();
			int i=0;
			while(i<tabs.size()) {
				
				InterfaceTable interfaceTable =new InterfaceTable();
				Object[] tab=tabs.get(i);
				
				
				
				String libAct=((String) tab[0]);
				interfaceTable.setNatureTravaux(libAct);
				
				String strucResp=((String) tab[1]);
				interfaceTable.setStrucResp(strucResp);
				
				String rptx=((String) tab[2]);
				interfaceTable.setRptx(rptx);
				
				double pkDebutZch=((double) tab[3]);
				interfaceTable.setPkDebutZch(pkDebutZch);
				
				double pkFinZch=((double) tab[4]);
				interfaceTable.setPkFinZch(pkFinZch);
				
				String ttx=((String) tab[5]);
				interfaceTable.setTtx(ttx);
				
				String creq=((String) tab[6]);
				interfaceTable.setCreq(creq);		
				
				String zepProp=((String) tab[7]);
				interfaceTable.setZepProp(zepProp);
				
				String com=((String)tab[8]);
				interfaceTable.setCom(com);
				
				Date dateDebut=((Date)tab[9]);
				interfaceTable.setDateDebut(dateDebut);
				
				Date dateFin=((Date)tab[10]);
				interfaceTable.setDatFin(dateFin);
				
				String voie=((String)tab[11]);
				interfaceTable.setVoie(voie);
				
				interfaceTables.add(interfaceTable);
				i++;
			}
			
			return interfaceTables;
			

			}
		
		public static List<InterfaceTable> ControleZep(List<InterfaceTable> intTables,List<Zep> zeps) {
			int i=0;
			while(i<intTables.size()) {
		    InterfaceTable intTable=intTables.get(i);
		    	intTable.setControlZep(0);
		    	for (Zep zep:zeps) {
		    		
		    		if(zep.getZep().equals(intTable.getZep())&&(zep.getPkdebut()==intTable.getPkDebutZch())&&(zep.getPkfin()==intTable.getPkFinZch())){
		    			System.out.println(intTable.getZep());
		    			intTable.setControlZep(1);
		    			System.out.println(intTable.getControlZep());
		    			
		    			}
		    	}
		    	
		    	i++;
			}
		    return intTables;
		}
	}
	
		
		
		
