package org.sid.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


import org.sid.entities.Operation;
import org.sid.entities.RPTX;


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
}