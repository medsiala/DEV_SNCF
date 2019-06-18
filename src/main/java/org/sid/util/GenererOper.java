package org.sid.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.sid.entities.CREQ;
import org.sid.entities.Operation;
import org.sid.entities.OperationZep;
import org.sid.entities.RPTX;
import org.sid.entities.TrainsTravaux;


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
			    opZep1.setIdActivites(op.getIdActivites());
			    listZepsOp.add(opZep1);
			    i++;
			    
			
			}
		return listZepsOp;
		}
		
		
		}
