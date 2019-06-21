package org.sid.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.sid.entities.LaplacePlanDeCharge;


public class ExcelUtilsLaplacePlanDeCharge {
	
	public static List<LaplacePlanDeCharge> parseExcelFile(InputStream is) {
		List<LaplacePlanDeCharge> listLaplacePlanDeCharges = new ArrayList<LaplacePlanDeCharge>();
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
    			LaplacePlanDeCharge laplace=extractInfoFromCell(cells);
    			listLaplacePlanDeCharges.add(laplace);
    		}
		} catch (IOException e) {
        	throw new RuntimeException("FAIL! -> message3 = " + e.getMessage());
		}finally {
			if (workbook != null) {
				try {
					workbook.close();
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
			
	
		return listLaplacePlanDeCharges;
	}
	
	private static LaplacePlanDeCharge extractInfoFromCell(List<Cell> cells) {
		LaplacePlanDeCharge lap =new LaplacePlanDeCharge();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		Cell idActiviteCell= cells.get(0);
		if (idActiviteCell != null) {
			idActiviteCell.setCellType(Cell.CELL_TYPE_NUMERIC);
			lap.setIdActivites(idActiviteCell.getNumericCellValue());
		}
		
		Cell strucRespCell=cells.get(1);
		if (strucRespCell != null) {
			strucRespCell.setCellType(Cell.CELL_TYPE_STRING);
			lap.setStrucResp(strucRespCell.getStringCellValue());
		}
		
		Cell libactCell=cells.get(2);
		if (libactCell != null) {
			libactCell.setCellType(Cell.CELL_TYPE_STRING);
			lap.setLibAct(libactCell.getStringCellValue());
		}
		
		Cell jourNuitCell=cells.get(3);
		if (jourNuitCell != null) {
			jourNuitCell.setCellType(Cell.CELL_TYPE_STRING);
			lap.setJourOuNuit(jourNuitCell.getStringCellValue());
		}
		
		Cell capCell=cells.get(6);
		if (capCell != null) {
			capCell.setCellType(Cell.CELL_TYPE_STRING);
			lap.setCapacite(capCell.getStringCellValue());
		}
		
		Cell ligneCell= cells.get(7);
		if (ligneCell != null) {
			ligneCell.setCellType(Cell.CELL_TYPE_NUMERIC);
			lap.setLibLigne(ligneCell.getNumericCellValue());
		}
		
		Cell voieCell=cells.get(9);
		if (voieCell != null) {
			voieCell.setCellType(Cell.CELL_TYPE_STRING);
			lap.setLibelleVoie(voieCell.getStringCellValue());
		}
		
		Cell pkDebutCell= cells.get(10);
		if (pkDebutCell != null) {
			pkDebutCell.setCellType(Cell.CELL_TYPE_NUMERIC);
			lap.setPkDebut(arrondiNDecimales(pkDebutCell.getNumericCellValue(),3));
		}
		
		Cell pkFinCell= cells.get(11);
		if (pkFinCell != null) {
			pkFinCell.setCellType(Cell.CELL_TYPE_NUMERIC);
			lap.setPkFin(arrondiNDecimales(pkFinCell.getNumericCellValue(),3));
		}
		
		Cell dateDebutCell= cells.get(13);
		if (dateDebutCell != null) {
			dateDebutCell.setCellType(Cell. CELL_TYPE_STRING);
			String dateDebut= dateDebutCell.getStringCellValue();
			try {
			 Date date = formatter.parse(dateDebut);
			 lap.setDateDebut(date);
			 } catch (ParseException e) {
		            e.printStackTrace();
		        }
			}
			
		
		
		Cell dateFinCell= cells.get(14);
		if (dateFinCell != null) {
			dateFinCell.setCellType(Cell. CELL_TYPE_STRING);
			String dateFin= dateFinCell.getStringCellValue();
			try {
			 Date date = formatter.parse(dateFin);
			 lap.setDateFin(date);
			 } catch (ParseException e) {
		            e.printStackTrace();
		        }
		}
		
		Cell resourceCell=cells.get(16);
		if (resourceCell != null) {
			resourceCell.setCellType(Cell.CELL_TYPE_STRING);
			lap.setTypeResou(resourceCell.getStringCellValue());
		}
		
		Cell habilitationCell=cells.get(21);
		if (habilitationCell != null) {
			habilitationCell.setCellType(Cell.CELL_TYPE_STRING);
			lap.setHabilitation(habilitationCell.getStringCellValue());
		}
		
		Cell resoucell=cells.get(22);
		if ( resoucell != null) {
			 resoucell.setCellType(Cell.CELL_TYPE_STRING);
			lap.setResouAffecte( resoucell.getStringCellValue());
		}
		
		
		return lap ;
		
	}

	private static double arrondiNDecimales(double x, int n) { double pow = Math.pow(10, n); return (Math.floor(x * pow)) / pow; }

	}
	
	
    		

