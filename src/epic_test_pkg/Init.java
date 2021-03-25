package epic_test_pkg;


import org.testng.annotations.BeforeSuite;
import com.relevantcodes.extentreports.ExtentReports;


public class Init {
	static String baseUrl="https://www.epicgames.com/";
	static String driverPath="D:\\A_semester_6\\TA\\chromedriver.exe";	
	static ExtentReports report;
	
	@BeforeSuite(groups="search")
	public void set() {
		
		System.setProperty("webdriver.chrome.driver", driverPath);
		report = new ExtentReports("D:\\A_semester_6\\TA\\report_epic.html");
		System.out.println("set");
	}
	
}
