package epic_test_pkg;

import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFSheet;
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


public class MultipleLogin {
	
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
	
	
	@Test(dataProvider="login-data-provider",dataProviderClass=DataProviderClass.class)
	public void loginAmazon(String username, String pwd){
	
		try{
		driver.get(Init.baseUrl);
		//driver.manage().window().maximize();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("user"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("login-with-epic"))).click();
		WebElement txtemail=wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
		txtemail.sendKeys(username);
		WebElement txtpwd=wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
		txtpwd.sendKeys(pwd);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in"))).click();
		test.log(LogStatus.PASS, "Signin successfull");
		}
		catch(Exception e){
			test.log(LogStatus.FAIL, "Signin Failed");
		}
		
	//	System.out.println(username+" "+pwd);
	}
	
	@AfterSuite
	public void destroySession(){
		driver.close();
		driver.quit();
	}
}
