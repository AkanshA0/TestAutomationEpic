package epic_test_pkg;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EpicGamesFortnite{
	WebDriverWait wait;
	//String baseUrl="https://www.epicgames.com/store/en-US/";
	//String driverPath="D:\\\\chromedriver_win32\\\\chromedriver.exe";
	WebDriver driver;		//these variables should be declared outside any test function to be accessible everywhere in class
	//static ExtentReports report = new ExtentReports("F:\\3rd Year\\6th Semester\\Test Automation\\Test Automation lab\\Report\\EpicGamesreport.html");
	static ExtentTest test;
	
	@BeforeTest
	public void browserLaunch(){
		System.setProperty("webdriver.chrome.driver",Init.driverPath);
		driver=new ChromeDriver(); 
		wait = new WebDriverWait(driver, 20);
		driver.get(Init.baseUrl);
		//driver.manage().window().maximize();
	}
	@BeforeMethod
	public static void startReport1(Method result)
	{
		test = Init.report.startTest("EpicGamesReport - " + result.getName());
	}
	
	@Test(priority=1)
	public void Searchinput(){
		  
		  test.log(LogStatus.INFO,"Sending data to be searched");
			if(driver.findElement(By.id("searchInput")) != null) {
				driver.findElement(By.id("searchInput")).sendKeys("Fortnite");
				test.log(LogStatus.PASS,"Search successful!");
			}
			else {
				test.log(LogStatus.FAIL,"Searching failed!");
			}
	}
	
	@Test(priority=2)
	public void search(){

		test.log(LogStatus.INFO,"Clicking on Search");
		if(driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/main/div/div[1]/div/nav/div/div[2]/div/div/div/div/div/form/button")) != null) {
			driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/main/div/div[1]/div/nav/div/div[2]/div/div/div/div/div/form/button")).click();
			
			test.log(LogStatus.PASS,"Search is available");
		}
		else {
			test.log(LogStatus.FAIL,"Search is not available");
		}
	}
	
	@Test(priority=3)
	public void fortniteclick() throws InterruptedException{
		Thread.sleep(5000);	
		try{
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Fortnite")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#dieselReactWrapper > div > div.css-igz6h5-AppPage_bodyContainer > main > div > div > div.css-5wa3ri-Pagecontent-PagecontentAfterTopNav > div > div > section > div > div > div > section > div > section > section > ul > li > div > a > div > div > div.css-1euducm-DiscoverCardLayout_bodyAndBanner > div"))).click();
		test.log(LogStatus.INFO,"Clicking on fortnite");
			test.log(LogStatus.PASS,"Fortnite is clickable");
		}
			catch(Exception e){
			test.log(LogStatus.FAIL,"Fortnite is not found");
		}
	}
	
	@Test(priority=4)
	public void CPUrequirements() {
		WebElement w=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[4]/main/div/div[3]/div[2]/div/div[3]/div[7]/div[2]/div[2]/div[1]/div[2]/table/tbody/tr[3]/td[2]")));
		System.out.println(w);
		test.log(LogStatus.INFO,"Checking CPU Requirements");
		if(w != null) {
			test.log(LogStatus.PASS,"CPU requirements are available");
		}
		else {
			test.log(LogStatus.FAIL,"CPU requirements are not available");
		}
	}
	
	@Test(priority=5)
	public void MEMrequirements(){
		boolean isMEMdisplayed = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/main/div/div[3]/div[2]/div/div[3]/div[7]/div[2]/div[2]/div[1]/div[2]/table/tbody/tr[4]/td[2]")).isDisplayed();
		System.out.println(isMEMdisplayed);
		test.log(LogStatus.INFO,"Checking Memory Requirements");
		if(driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/main/div/div[3]/div[2]/div/div[3]/div[7]/div[2]/div[2]/div[1]/div[2]/table/tbody/tr[4]/td[2]")) != null) {
			test.log(LogStatus.PASS,"Memory requirements are available");
		}
		else {
			test.log(LogStatus.FAIL,"Memory requirements are not available");
		}
	}
	@Test(priority=6)
	public void GPUrequirements(){
		boolean isGPUdisplayed = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/main/div/div[3]/div[2]/div/div[3]/div[7]/div[2]/div[2]/div[1]/div[2]/table/tbody/tr[5]/td[2]")).isDisplayed();
		System.out.println(isGPUdisplayed);
		test.log(LogStatus.INFO,"Checking Memory Requirements");
		if(driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/main/div/div[3]/div[2]/div/div[3]/div[7]/div[2]/div[2]/div[1]/div[2]/table/tbody/tr[5]/td[2]")) != null) {
			test.log(LogStatus.PASS,"GPU requirements are available");
		}
		else {
			test.log(LogStatus.FAIL,"GPU requirements are not available");
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
