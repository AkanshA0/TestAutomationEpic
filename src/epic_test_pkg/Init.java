package epic_test_pkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Init {
	static String baseUrl="https://www.epicgames.com/";
	static String driverPath="D:\\A_semester_6\\TA\\chromedriver.exe";	
	static WebDriver driver;
	static WebDriverWait wait;
	static ExtentReports report;
	static ExtentTest test;
	
	@BeforeSuite(groups="search")
	public void set() {
		
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver=new ChromeDriver();
		wait = new WebDriverWait(Init.driver, 10);
		report = new ExtentReports("D:\\A_semester_6\\TA\\report_epic.html");
		System.out.println("set");
	}
	
	@AfterSuite()
	public void destroy() {
		driver.quit();
	}
	
}
