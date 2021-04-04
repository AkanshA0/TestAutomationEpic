package epic_test_pkg;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MultipleRegister {
	WebDriver driver;
	WebDriverWait wait;
	static ExtentTest test;
	
	@BeforeTest
	public void browserLaunch(){
		driver=new ChromeDriver();
		wait = new WebDriverWait(driver, 20);
	}

	@BeforeMethod
	public static void startReport(Method result){
		test = Init.report.startTest("Extent Report - "+result.getName());
	}
	
	@AfterMethod
	public void endReport(){
		Init.report.endTest(test);
		Init.report.flush();
	}
	
	
	@Test(dataProvider="register-data-provider",dataProviderClass=DataProviderClass.class)
	public void registerAmazon(String username, String pwd,String country,String fname,String lname,String dname){
	
		try{
		driver.get(Init.baseUrl);
		//driver.manage().window().maximize();
		driver.findElement(By.id("user")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("to-register"))).click();
		Thread.sleep(4*1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("login-with-epic"))).click();
		WebElement txtemail=wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
		txtemail.sendKeys(username);
		WebElement txtpwd=wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
		txtpwd.sendKeys(pwd);
		WebElement txtc=wait.until(ExpectedConditions.elementToBeClickable(By.id("country")));
		txtc.sendKeys(country);
		WebElement txtfn=wait.until(ExpectedConditions.elementToBeClickable(By.id("name")));
		txtfn.sendKeys(fname);
		WebElement txtln=wait.until(ExpectedConditions.elementToBeClickable(By.id("lastName")));
		txtln.sendKeys(lname);
		WebElement txtdn=wait.until(ExpectedConditions.elementToBeClickable(By.id("displayName")));
		txtdn.sendKeys(dname);
		driver.findElement(By.id("termsOfService")).click();
		
		test.log(LogStatus.PASS, "Signup successfull");
		}
		catch(Exception e){
			test.log(LogStatus.FAIL, "Signup Failed");
		}
		
	//	System.out.println(username+" "+pwd);
	}
	
	@AfterSuite
	public void destroySession(){
		driver.close();
		driver.quit();
	}
}
