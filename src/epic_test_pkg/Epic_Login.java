package epic_test_pkg;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Epic_Login{
	
	String username="akansha2000@gmail.com",pass="Upes@123";
	
	@BeforeTest(groups="search")
	public void launchBrowser(){
		Init.driver.get(Init.baseUrl);
	}
	
	@BeforeMethod
	public static void startReport(Method result){
		Init.test = Init.report.startTest("Extent Report - "+result.getName());
	}
	
	@AfterMethod
	public void endReport(){
		Init.report.endTest(Init.test);
		Init.report.flush();
	}
	
	@Test(priority=0,groups="search")
	public void titleVerify(){
		/* SEARCH	
		 WebElement txtemail=Init.wait.until(ExpectedConditions.elementToBeClickable(By.id("searchInput")));
		txtemail.sendKeys("fortnite");
		Init.driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/main/div/div[1]/div/nav/div/div[2]/div/div/div/div/div/form/button")).click();;
		
		  */
		Init.test.log(LogStatus.INFO, "start login");
		String expected="Epic Games Store | Download & Play PC Games, Mods, DLC & More – Epic Games";
		String actual=Init.driver.getTitle();
		Init.test.log(LogStatus.INFO, "Title Verification");
		if(expected.equals(actual))
		{
			Init.test.log(LogStatus.PASS, "Correct Title");
		}
		else
		{
			Init.test.log(LogStatus.FAIL, "Incorrect Title");
		}
		Init.test.log(LogStatus.WARNING, "Moving to next step");
		
	}
	
	@Test(priority=1)
	public void clickSignin(){
		
		try 
		{	
			Init.driver.findElement(By.id("user")).click();
			WebElement element= Init.wait.until(ExpectedConditions.elementToBeClickable(By.id("login-with-epic")));
			Init.test.log(LogStatus.PASS, "login with Epic option present");
			element.click();
		} catch (Exception e) {
			Init.test.log(LogStatus.FAIL, "login with Epic option absent");
		}
		Init.test.log(LogStatus.WARNING, "Moving to next step");
	}
	
	@Test(priority=2)
	public void enterEmail(){
		
		try 
		{
			WebElement txtemail=Init.wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
			txtemail.sendKeys(username);
			Init.test.log(LogStatus.PASS, "email input box present");
			
		} catch (Exception e) {
			Init.test.log(LogStatus.FAIL, "email input box absent");
		}
		Init.test.log(LogStatus.WARNING, "Moving to next step");
		
	}

	@Test(priority=3)
	public void enterPassword(){
		try 
		{
			WebElement txtpwd=Init.wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
			txtpwd.sendKeys(pass);
			Init.test.log(LogStatus.PASS, "password input box present");
			
		} catch (Exception e) {
			Init.test.log(LogStatus.FAIL, "password input box absent");
		}
		Init.test.log(LogStatus.WARNING, "Moving to next step");
		
	}
	
	@Test(priority=4)
	public void signin(){
		try 
		{
			Init.wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in"))).click();
			Init.test.log(LogStatus.PASS, "Sign-in button present and enabled");
			
		} catch (Exception e) {
			Init.test.log(LogStatus.FAIL, "sign-in button absent");
		}
		Init.test.log(LogStatus.WARNING, "Done with login test");
		
	}
	
	@AfterTest
	public void destroySession(){
		Init.driver.close();
	}
}
