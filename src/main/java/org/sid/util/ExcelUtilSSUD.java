package org.sid.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import java.util.List;




import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import org.sid.entities.ZepSUD;



public class ExcelUtilSSUD {
	@SuppressWarnings("deprecation")
	public static List<ZepSUD> parseExcelFile(InputStream is) {
		List<ZepSUD> Listzep = new ArrayList<ZepSUD>();
		XSSFWorkbook workbook = null ;
		try {
			workbook=new XSSFWorkbook(is);
			Sheet sheet=workbook.getSheetAt(0);
			for (Row row :sheet) {
    			if (row.getRowNum()==0) {
    			continue ;
    			}
		List<Cell> cells=new ArrayList<Cell>();
		int lastColumn=Math.max(row.getLastCellNum(),19);
		
		for (int cn=0;cn< lastColumn; cn++) {
			Cell c=row.getCell(cn,Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
			cells.add(c);
			
		}
		ZepSUD zepSud=extractInfoFromCell(cells);
		Listzep.add(zepSud);
		
			}
		} catch (IOException e) {
			throw new RuntimeException("FAIL! -> messageN = " + e.getMessage());
		}finally {
			if (workbook != null) {
				try {
						workbook.close();
				}catch (IOException e) {
						e.printStackTrace();
					}
				}		
	
			}
		return Listzep;
		}
	private static ZepSUD extractInfoFromCell(List<Cell> cells) {
		ZepSUD zepSud =new ZepSUD();
	
		Cell ZepCell= cells.get(0);
		if (ZepCell !=null) {
			ZepCell.setCellType(Cell.CELL_TYPE_STRING);
			zepSud.setZep(ZepCell.getStringCellValue());
		}
		Cell PkDebutCEll = cells.get(1);
		if (PkDebutCEll !=null) {
			PkDebutCEll.setCellType(Cell.CELL_TYPE_NUMERIC);
			zepSud.setPkdebut(PkDebutCEll.getNumericCellValue());
		}
		Cell PkFinCEll = cells.get(2);
		if (PkFinCEll  !=null) {
			PkFinCEll.setCellType(Cell.CELL_TYPE_NUMERIC);
			zepSud.setPkfin(PkFinCEll .getNumericCellValue());
		}
		
		Cell posteCell= cells.get(3);
		if (posteCell !=null) {
			posteCell.setCellType(Cell.CELL_TYPE_STRING);
			zepSud.setPoste(posteCell.getStringCellValue());
		}
		Cell numPosteCell= cells.get(4);
		if (numPosteCell !=null) {
			numPosteCell.setCellType(Cell.CELL_TYPE_STRING);
			zepSud.setNumPoste(numPosteCell.getStringCellValue());
		}
		Cell voieACell= cells.get(5);
		if (voieACell !=null) {
			voieACell.setCellType(Cell.CELL_TYPE_STRING);
			zepSud.setVoieA(voieACell.getStringCellValue());
			
		}
		Cell voieBCell= cells.get(6);
		if (voieBCell !=null) {
			voieBCell.setCellType(Cell.CELL_TYPE_STRING);
			zepSud.setVoieB(voieBCell.getStringCellValue());
		}	
			Cell voieCCell= cells.get(7);
		if (voieCCell !=null) {
			voieCCell.setCellType(Cell.CELL_TYPE_STRING);
			zepSud.setVoieC(voieCCell.getStringCellValue());
		}
		Cell voieDCell= cells.get(8);
		if (voieDCell !=null) {
			voieDCell.setCellType(Cell.CELL_TYPE_STRING);
			zepSud.setVoieD(voieDCell.getStringCellValue());
		}
		Cell voieECell= cells.get(9);
		if (voieECell !=null) {
			voieECell.setCellType(Cell.CELL_TYPE_STRING);
			zepSud.setVoieE(voieECell.getStringCellValue());
		}
		Cell voieFCell= cells.get(10);
		if (voieFCell !=null) {
			voieFCell.setCellType(Cell.CELL_TYPE_STRING);
			zepSud.setVoieF(voieFCell.getStringCellValue());
		}
		Cell voieGCell= cells.get(11);
		if (voieGCell !=null) {
			voieGCell.setCellType(Cell.CELL_TYPE_STRING);
			zepSud.setVoieG(voieGCell.getStringCellValue());
		}
		Cell ligneACell= cells.get(13);
		if (ligneACell  !=null) {
			ligneACell.setCellType(Cell.CELL_TYPE_NUMERIC);
			zepSud.setLigneA(ligneACell .getNumericCellValue());
		}
		Cell ligneBCell= cells.get(14);
		if (ligneBCell  !=null) {
			ligneBCell.setCellType(Cell.CELL_TYPE_NUMERIC);
			zepSud.setLigneB(ligneBCell .getNumericCellValue());
		}
		Cell ligneCCell= cells.get(15);
		if (ligneCCell  !=null) {
			ligneCCell.setCellType(Cell.CELL_TYPE_NUMERIC);
			zepSud.setLigneC(ligneCCell .getNumericCellValue());
		}
		Cell secteurCell= cells.get(16);
		if (secteurCell !=null) {
			secteurCell.setCellType(Cell.CELL_TYPE_STRING);
			zepSud.setSecteur(secteurCell.getStringCellValue());
		}
		Cell ttxAutCell= cells.get(17);
		if (ttxAutCell !=null) {
			ttxAutCell.setCellType(Cell.CELL_TYPE_STRING);
			zepSud.setTtxAut(ttxAutCell.getStringCellValue());
		}
		Cell groupCell= cells.get(18);
		if (groupCell !=null) {
			groupCell.setCellType(Cell.CELL_TYPE_STRING);
			zepSud.setGroupZep(groupCell.getStringCellValue());
			
		}
		
		return zepSud;
		





	}
}
