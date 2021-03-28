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
	static XSSFSheet loginDetailSheet;
	
	public static void setv() throws IOException{
		fis =new FileInputStream("D:\\A_semester_6\\TA\\cred_sheet.xlsx");
		wb =new XSSFWorkbook(fis);
		loginDetailSheet = wb.getSheet("Login");
	}
	
	@DataProvider(name="login-data-provider")
	public static Object[][] logindataProviderMethod() throws IOException
	{
		setv();
		int rows=loginDetailSheet.getLastRowNum();
		Object[][] o=new Object[rows][2]; 
		
		for(int i=1;i<=rows;i++)
		{
			XSSFRow row=loginDetailSheet.getRow(i);
			
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
		int rows=loginDetailSheet.getLastRowNum();
		Object[][] o=new Object[rows][2]; 
		
		for(int i=1;i<=rows;i++)
		{
			XSSFRow row=loginDetailSheet.getRow(i);
			
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
}
