package epic_test_pkg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderClass {
	static FileInputStream fis;
	static XSSFWorkbook wb;
	static XSSFSheet detailSheet;
	
	public static void setv() throws IOException{
		fis =new FileInputStream("D:\\A_semester_6\\TA\\cred_sheet.xlsx");
		wb =new XSSFWorkbook(fis);		
	}
	
	@DataProvider(name="login-data-provider")
	public static Object[][] logindataProviderMethod() throws IOException
	{
		setv();
		detailSheet = wb.getSheet("Login");
		
		int rows=detailSheet.getLastRowNum();
		Object[][] o=new Object[rows][2]; 
		
		for(int i=1;i<=rows;i++)
		{
			XSSFRow row=detailSheet.getRow(i);
			
			if(row.getCell(0).getCellType()== Cell.CELL_TYPE_NUMERIC){
				o[i-1][0]=row.getCell(0).getRawValue();
			}
			else {
				o[i-1][0] = row.getCell(0).toString();
			}
			o[i-1][1] = row.getCell(1).toString();
		}	
		
		return o;
	}
	
	@DataProvider(name="register-data-provider")
	public static Object[][] registerDataProviderMethod() throws IOException
	{
		setv();
		detailSheet = wb.getSheet("Register");
		
		int rows=detailSheet.getLastRowNum();
		Object[][] o=new Object[rows][6]; 
		
		for(int i=1;i<=rows;i++)
		{
			XSSFRow row=detailSheet.getRow(i);
			
			o[i-1][0] = row.getCell(0).toString();//email
			o[i-1][1] = row.getCell(1).toString();//password
			o[i-1][2] = row.getCell(2).toString();//country
			o[i-1][3] = row.getCell(3).toString();//first name
			o[i-1][4] = row.getCell(4).toString();//last name
			o[i-1][5] = row.getCell(5).toString();//display name
		}	
		
		return o;
	}
}
