package org.sid.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.sid.entities.Catenaire;

public class ExcelUtilsCat {
	
	public static List<Catenaire> parseExcelFile(InputStream is) {
		List<Catenaire> catenaire = new ArrayList<Catenaire>();
		XSSFWorkbook workbook = null ;
		try {
    	     workbook = new XSSFWorkbook(is);
    	     Sheet sheet = workbook.getSheetAt(0);
    		for (Row row :sheet) {
    			if (row.getRowNum()<= 4) {
    			continue ;
    			}
    			List<Cell> cells=new ArrayList<Cell>();
    			int lastColumn=Math.max(row.getLastCellNum(),61);
    			
    			for (int cn=0;cn< lastColumn; cn++) {
    				Cell c=row.getCell(cn,Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
    				cells.add(c);
    			}
    			Catenaire cat=extractInfoFromCell(cells);
    			catenaire.add(cat);
    		}
		} catch (IOException e) {
        	throw new RuntimeException("FAIL! -> message = " + e.getMessage());
		}finally {
			if (workbook != null) {
				try {
					workbook.close();
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		return catenaire;
	}
	private static Catenaire extractInfoFromCell(List<Cell> cells) {
		Catenaire cat =new Catenaire() ;
		
		Cell SecteurCell=cells.get(0);
		if (SecteurCell != null) {
			SecteurCell.setCellType(Cell.CELL_TYPE_STRING);
			cat.setCSecteurs(SecteurCell.getStringCellValue());
		}
		
		Cell pkDebutCell= cells.get(1);
		if (pkDebutCell != null) {
			pkDebutCell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cat.setCPkDebut(pkDebutCell.getNumericCellValue());
		}
		
		Cell pkFinCell= cells.get(2);
			if (pkDebutCell != null) {
				pkFinCell.setCellType(Cell.CELL_TYPE_NUMERIC);
				cat.setCPkFin(pkFinCell.getNumericCellValue());
		}
			Cell voie= cells.get(4);
			if (voie != null) {
				voie.setCellType(Cell.CELL_TYPE_STRING);
				cat.setCVoie(voie.getStringCellValue());
		}
			return cat ;
}
}
