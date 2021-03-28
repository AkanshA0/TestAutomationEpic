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

public class Epic_Signup {
	String username="akansha2000@gmail.com",pass="Upes@123";
	WebDriver driver1;
	WebDriverWait wait;
	static ExtentTest test1;
	
	@BeforeTest(groups="search")
	public void launchBrowser(){
		driver1=new ChromeDriver();
		wait = new WebDriverWait(driver1, 20);
		driver1.get(Init.baseUrl);
	}
	
	@BeforeMethod
	public static void startReport(Method result){
		test1 = Init.report.startTest("Extent Report - "+result.getName());
	}
	
	@AfterMethod
	public void endReport(){
		Init.report.endTest(test1);
		Init.report.flush();
	}

	@Test(priority=5)
	public void clickSignup(){
		
		try 
		{	
			driver1.findElement(By.id("user")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("to-register"))).click();
			Thread.sleep(4*1000);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("login-with-epic"))).click();
			test1.log(LogStatus.PASS, "Signup with email option present");
			
		} catch (Exception e) {
			test1.log(LogStatus.FAIL, "Signup with email absent");
		}
	}
	
	@Test(priority=6)
	public void enterEmail(){
		
		try 
		{
			WebElement txtemail=wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
			txtemail.sendKeys(username);
			test1.log(LogStatus.PASS, "email input box present");
			
		} catch (Exception e) {
			test1.log(LogStatus.FAIL, "email input box absent");
		}
		
	}

	@Test(priority=7)
	public void enterPassword(){
		try 
		{
			WebElement txtpwd=wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
			txtpwd.sendKeys(pass);
			test1.log(LogStatus.PASS, "password input box present");
			
		} catch (Exception e) {
			test1.log(LogStatus.FAIL, "password input box absent");
		}
		
	}
	
	@Test(priority=7)
	public void enterCountry(){
		try 
		{
			//driver1.findElement(By.id("country")).sendKeys("India");
			WebElement txtpwd=wait.until(ExpectedConditions.elementToBeClickable(By.id("country")));
			txtpwd.sendKeys("India");
			test1.log(LogStatus.PASS, "Country input present and enabled");
			
		} catch (Exception e) {
			test1.log(LogStatus.FAIL, "Country input absent");
		}
		
	}
	
	@Test(priority=7)
	public void enterName(){
		try 
		{
			//driver1.findElement(By.id("name")).sendKeys("Akansha");
			WebElement txtpwd=wait.until(ExpectedConditions.elementToBeClickable(By.id("name")));
			txtpwd.sendKeys("Akansha");
			test1.log(LogStatus.PASS, "First-name input box present and enabled");
			
		} catch (Exception e) {
			test1.log(LogStatus.FAIL, "First-name input box absent");
		}
		
	}
	
	@Test(priority=7)
	public void enterLastName(){
		try 
		{
			//driver1.findElement(By.id("lastName")).sendKeys("Abcd");
			WebElement txtpwd=wait.until(ExpectedConditions.elementToBeClickable(By.id("lastName")));
			txtpwd.sendKeys("Abcd");
			test1.log(LogStatus.PASS, "Last-name input box present and enabled");
			
		} catch (Exception e) {
			test1.log(LogStatus.FAIL, "Last-name input box absent");
		}
		
	}
	
	@Test(priority=7)
	public void enterDisplayName(){
		try 
		{
			//driver1.findElement(By.id("displayName")).sendKeys("Akansha123");
			WebElement txtpwd=wait.until(ExpectedConditions.elementToBeClickable(By.id("displayName")));
			txtpwd.sendKeys("Akansha123");
			test1.log(LogStatus.PASS, "password input box present");
			
		} catch (Exception e) {
			test1.log(LogStatus.FAIL, "password input box absent");
		}
		
	}
	
	@Test(priority=8)
	public void checkTermsofService(){
		try 
		{
			driver1.findElement(By.id("termsOfService")).click();
			//wait.until(ExpectedConditions.elementToBeClickable(By.id("termsOfService"))).click();
			test1.log(LogStatus.PASS, "terms of service checkbox present");
			
		} catch (Exception e) {
			test1.log(LogStatus.FAIL, "terms of service checkbox absent");
		}
		
	}
	
	@Test(priority=9)
	public void signup(){
		
		try 
		{		
			wait.until(ExpectedConditions.elementToBeClickable(By.id("btn-submit"))).click();
			test1.log(LogStatus.PASS, "Submit button present and enabled");
			
		} catch (Exception e) {
			test1.log(LogStatus.FAIL, "Submit button absent");
		}
		test1.log(LogStatus.INFO, "Done with Signup test");
	}
	
	@AfterTest
	public void destroySession(){
		driver1.close();
		driver1.quit();
	}
}
