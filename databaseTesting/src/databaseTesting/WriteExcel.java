package databaseTesting;
/**
 * This is used for write excel data 
 **/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class WriteExcel {
	
	XSSFWorkbook wb;
	XSSFSheet sheet_veri;
	
	public void writeFunction(String RowNo, String ColNo, String ExeMessage) {
		
		File src = new File("C:\\Users\\jayesh\\workspace4\\project_filament\\IP_excelfile\\joomla_excel.xlsx");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		XSSFSheet sh1 = wb.getSheetAt(3);
		int RowNoInt = Integer.parseInt(RowNo);
		int ColNoInt = Integer.parseInt(ColNo);
		sh1.getRow(RowNoInt).createCell(ColNoInt).setCellValue(ExeMessage);
		
		FileOutputStream set_excel = null;
		try {
			set_excel = new FileOutputStream(src);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		try {
			wb.write(set_excel);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
