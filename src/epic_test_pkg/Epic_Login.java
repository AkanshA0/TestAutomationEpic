package epic_test_pkg;

import java.lang.reflect.Method;

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

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Epic_Login{
	
	String username="akansha2000@gmail.com",pass="Upes@123";
	WebDriver driver;
	WebDriverWait wait;
	static ExtentTest test;
	
	@BeforeTest
	public void launchBrowser(){
		driver=new ChromeDriver();
		wait = new WebDriverWait(driver, 20);
		driver.get(Init.baseUrl);
	}
	
	@BeforeMethod
	public static void startReport(Method result){
		test = Init.report.startTest("Login Report - "+result.getName());
	}
	
	@AfterMethod
	public void endReport(){
		Init.report.endTest(test);
		Init.report.flush();
	}
	
	@Test(priority=0)
	public void titleVerify(){
		  
		test.log(LogStatus.INFO, "start login");
		String expected="Epic Games Store | Download & Play PC Games, Mods, DLC & More ? Epic Games";
		String actual=driver.getTitle();
		test.log(LogStatus.INFO, "Title Verification");
		if(expected.equals(actual))
		{
			test.log(LogStatus.PASS, "Correct Title");
		}
		else
		{
			test.log(LogStatus.FAIL, "Incorrect Title");
		}
		
	}
	
	@Test(priority=1)
	public void clickSignin(){
		
		try 
		{	
			driver.findElement(By.id("user")).click();
			WebElement element= wait.until(ExpectedConditions.elementToBeClickable(By.id("login-with-epic")));
			test.log(LogStatus.PASS, "login with Epic option present");
			element.click();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "login with Epic option absent");
		}
		
	}
	
	@Test(priority=2)
	public void enterEmail(){
		
		try 
		{
			WebElement txtemail=wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
			txtemail.sendKeys(username);
			test.log(LogStatus.PASS, "email input box present");
			
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "email input box absent");
		}

		
	}

	@Test(priority=3)
	public void enterPassword(){
		try 
		{
			WebElement txtpwd=wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
			txtpwd.sendKeys(pass);
			test.log(LogStatus.PASS, "password input box present");
			
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "password input box absent");
		}
	
		
	}
	
	@Test(priority=4)
	public void signin(){
		try 
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in"))).click();
			test.log(LogStatus.PASS, "Sign-in button present and enabled");
			
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "sign-in button absent");
		}
		test.log(LogStatus.INFO, "Done with login test");
		
	}
	
	@AfterTest
	public void destroySession(){
		driver.close();
		driver.quit();
	}
}
