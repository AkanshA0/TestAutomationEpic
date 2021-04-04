package epic_test_pkg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;


public class Init {
	static String baseUrl="https://www.epicgames.com/";
	static String driverPath="D:\\A_semester_6\\TA\\chromedriver.exe";
//	static String driverPath="D:\\\\chromedriver_win32\\\\chromedriver.exe";
	static ExtentReports report;
	static FileInputStream fis;
	static XSSFWorkbook wb;
	
	@BeforeSuite(groups="search")
	public void set() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", driverPath);
		report = new ExtentReports("D:\\A_semester_6\\TA\\report_epic.html");
//		report = new ExtentReports("F:\\3rd Year\\6th Semester\\Test Automation\\Test Automation lab\\Report\\EpicGamesHomeReport.html");
		fis =new FileInputStream("D:\\A_semester_6\\TA\\cred_sheet.xlsx");
		wb =new XSSFWorkbook(fis);
		//System.out.println("set");
	}
	
}
