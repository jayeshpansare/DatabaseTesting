package databaseTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldata {
	XSSFWorkbook wb;
	XSSFSheet sheet_veri;
	
	/**
	 * Set a excel sheet.
	 **/
	public Exceldata(String excelpath){
		// TODO Auto-generated constructor stub
		try{
			File src = new File(excelpath);
			FileInputStream fis=new FileInputStream(src);
			wb = new XSSFWorkbook(fis);		
		}catch(Exception e){
			System.out.println("Error is:"+e);
		}
	}

	/**
	 *  Get number of rows
	 **/
	public int getTotalRow(int sheetNo){
		sheet_veri = wb.getSheetAt(sheetNo);
		int data = sheet_veri.getLastRowNum();
		return data;		
	}
	
	/**
	 * Get data from sheet 
	 * 
	 **/
	public String getData(int sheetNo, int noOfRow, int cellNo){
		
		sheet_veri= wb.getSheetAt(sheetNo);
		Row row = sheet_veri.getRow(noOfRow);
		String data= null;
		if (row == null) {
	         // There is no data in this row, handle as needed
	      } else {
	    	  Cell cell = row.getCell(cellNo);	    	  
	    	  	if (cell == null) {
		    		  data="";
		            } else {
		            	cell.setCellType(Cell.CELL_TYPE_STRING);
		               data = sheet_veri.getRow(noOfRow).getCell(cellNo).getStringCellValue();
		            }  
	      }
		return data;
		
	}
}
