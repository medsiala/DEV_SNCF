package org.sid.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.sid.entities.InterfaceTable;

public class ExportExcel {

	public static ByteArrayInputStream ahtToExcel(List<InterfaceTable> interfaceTables) throws IOException{
		try(
				InputStream is = new FileInputStream("src/a.xlsx");
		        Workbook workbook = new XSSFWorkbook(is);
		        ByteArrayOutputStream out = new ByteArrayOutputStream();
				 
			  
		    ){
		     
		      Sheet sheet = workbook.getSheetAt(0);
		int rowIdx=5;
		for (InterfaceTable interfaceTable:interfaceTables) {
			
		Row row =sheet.createRow(rowIdx++);
		
		Long nop=interfaceTable.getNop();
		if(nop!=null) {
		row.createCell(0).setCellValue(nop);
		}
		
		String zep =interfaceTable.getZep();
		if(zep!=null) {
			row.createCell(1).setCellValue(zep);
		}
		
		String voie=interfaceTable.getVoie();
		if(voie!=null) {
			row.createCell(2).setCellValue(voie);
		}
		
		String ted=interfaceTable.getTrainEncDebut();
		if (ted==null) {
			ted="";
		}
		String hed=interfaceTable.gethDebut();
		if (hed==null) {
			hed="";
		}
		String tef=interfaceTable.getTrainEncFin();
		if (tef==null) {
			tef="";
		}
		String hef=interfaceTable.gethFin();
		if (hef==null) {
			hef="";
		}
		String th=ted+" "+hed+" "+tef+" "+hef ;
		if (th!=null) {
			row.createCell(3).setCellValue(th);
		}
		
		String rptx=interfaceTable.getRptx();
		if(rptx!=null) {
			row.createCell(4).setCellValue(rptx);
		}
		
		String natureTravaux=interfaceTable.getNatureTravaux();
		if(natureTravaux!=null) {
			row.createCell(5).setCellValue(natureTravaux);
		}
		
		String cch=interfaceTable.getCch();
		if(cch!=null) {
			row.createCell(6).setCellValue(cch);
		}
		
		double pkdz=interfaceTable.getPkDebutZch();
		if(pkdz!=0) {
			row.createCell(7).setCellValue(pkdz);
		}
		
		double pkfz=interfaceTable.getPkFinZch();
		if(pkfz!=0) {
			row.createCell(8).setCellValue(pkfz);
		}
		
		 String bouc=interfaceTable.getBouclage();
		 if(bouc!=null) {
				row.createCell(9).setCellValue(bouc);
			}
		
		 String natutreAct=interfaceTable.getNatureTravauxAa();
		 if(natutreAct!=null) {
				row.createCell(9).setCellValue(natutreAct);
			}
		 String aa=interfaceTable.getAa();
		 if(aa!=null) {
				row.createCell(10).setCellValue(aa);
			}
		 
		 double pkda=interfaceTable.getPkDebutAa();
		 if(pkda!=0) {
				row.createCell(11).setCellValue(pkda);
			}
		 
		double pkfa=interfaceTable.getPkFinAa();
		 if(pkfa!=0) {
				row.createCell(12).setCellValue(pkfa);
			}
		
		 String nopCat=interfaceTable.getNopCat();
		 
			
				
				
				
				
				
	     
		
		
		
		
		
		
		
		
		
	}
		workbook.write(out);
		 return new ByteArrayInputStream(out.toByteArray());
	}
	
}
}
