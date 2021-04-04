package epic_test_pkg;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePageTesting{
	String baseUrl="https://www.epicgames.com/store/en-US/";
	//String driverPath="D:\\\\chromedriver_win32\\\\chromedriver.exe";
	WebDriver driver;		//these variables should be declared outside any test function to be accessible everywhere in class
	//static ExtentReports report = new ExtentReports("F:\\3rd Year\\6th Semester\\Test Automation\\Test Automation lab\\Report\\EpicGamesHomeReport.html");
	static ExtentTest test;
	//BeforeTest is executed before test cases
	@BeforeTest
	public void browserLaunch(){
		System.setProperty("webdriver.chrome.driver",Init.driverPath);
		driver=new ChromeDriver(); 
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public static void startReport1(Method result)
	{
		test = Init.report.startTest("EpicGamesReport - " + result.getName());
	}
	
	@Test(priority=1)
	public void SearchEpicLogo(){
		  WebElement epiclogo =  driver.findElement(By.id("egLogo"));
		  
		  test.log(LogStatus.INFO,"Checking Epic Games logo");
			if(epiclogo != null && epiclogo.isEnabled()) {
				test.log(LogStatus.PASS,"Search successful!");
			}
			else {
				test.log(LogStatus.FAIL,"Searching failed!");
			}
	}
	
	@Test(priority=2)
	public void Checkstore(){
		  WebElement checkStore =  driver.findElement(By.id("sitenav-link-0"));
		  
		  test.log(LogStatus.INFO,"Checking Epic Games logo");
			if(checkStore != null && checkStore.isEnabled()) {
				test.log(LogStatus.PASS,"Search successful!");
			}
			else {
				test.log(LogStatus.FAIL,"Searching failed!");
			}
	}

	@Test(priority=3)
	public void CheckNews(){
		  WebElement checkNEWS =  driver.findElement(By.id("sitenav-link-2"));
		  
		  test.log(LogStatus.INFO,"Checking News");
			if(checkNEWS != null && checkNEWS.isEnabled()) {
				test.log(LogStatus.PASS,"Check successful!");
			}
			else {
				test.log(LogStatus.FAIL,"Check failed!");
			}
	}
	
	@Test(priority=4)
	public void CheckFAQ(){
		  WebElement checkFAQ =  driver.findElement(By.id("sitenav-link-2"));
		  
		  test.log(LogStatus.INFO,"Checking News");
			if(checkFAQ != null && checkFAQ.isEnabled()) {
				test.log(LogStatus.PASS,"Check successful!");
			}
			else {
				test.log(LogStatus.FAIL,"Check failed!");
			}
	}

	@Test(priority=5)
	public void CheckHelp(){
		  WebElement checkHelp =  driver.findElement(By.id("sitenav-link-3"));
		  
		  test.log(LogStatus.INFO,"Checking Help");
			if(checkHelp != null && checkHelp.isEnabled()) {
				test.log(LogStatus.PASS,"Check successful!");
			}
			else {
				test.log(LogStatus.FAIL,"Check failed!");
			}
	}
	
	@Test(priority=6)
	public void CheckUnrealEngine(){
		  WebElement checkUnrealEngine =  driver.findElement(By.id("sitenav-link-4"));
		  
		  test.log(LogStatus.INFO,"Checking Unreal Engine");
			if(checkUnrealEngine != null && checkUnrealEngine.isEnabled()) {
				test.log(LogStatus.PASS,"Check successful!");
			}
			else {
				test.log(LogStatus.FAIL,"Check failed!");
			}
	}

	@AfterMethod
	public void endReport1() {
		Init.report.endTest(test);
		Init.report.flush();
	}
	
	@AfterTest
	public void destroySession(){
		driver.close();
		driver.quit();
	}
}
