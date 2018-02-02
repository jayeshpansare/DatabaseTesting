package databaseTesting;

import org.testng.annotations.Test;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.ResultSet;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class databaseTesting {
	
	@Test(dataProvider="exceldata")
	public void dataTest(String rowNo, String function, String sql_query, String key, String value) throws SQLException{		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sql_query);
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wordpress","root","");
		
		
		if(rowNo!=null){
			switch(function){
				case "select":
					Statement smt = con.createStatement();
					java.sql.ResultSet rs= smt.executeQuery(sql_query);	
					while(rs.next()){
						String get_content = rs.getString(key);
							
						if(get_content.contains(value)){
							System.out.println("Equal :"+get_content);
							System.out.println("=========================================");
						}
					}
				break;
				
				default:
					break;
				
			}			
			
			
			
			
		}
		
	}
	
	@DataProvider(name="exceldata")
	public Object[][] passdata(){
		int sheet_no = 1; // declare a sheet number
		
		Exceldata getExcelFile = new Exceldata("C:\\Users\\jayesh\\databaseTesting\\databaseTesting\\IP_excelfile\\database_excel.xlsx");
		int lastRowCount = getExcelFile.getTotalRow(sheet_no);
		Object[][] data = new Object[lastRowCount][5];
		for(int i=1; i<lastRowCount;i++){
			data[i][0] = getExcelFile.getData(sheet_no, i, 0);
			data[i][1] = getExcelFile.getData(sheet_no, i, 2);
			data[i][2] = getExcelFile.getData(sheet_no, i, 3);
			data[i][3] = getExcelFile.getData(sheet_no, i, 4);
			data[i][4] = getExcelFile.getData(sheet_no, i, 5);
		}
	
		return data;

	}
	
}
