package pageTestsLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import genericActionsLibrary.ExcelFile;
import genericActionsLibrary.Screenshot;
import pageActionsLibrary.LoginPageActions;
import testBasePackage.TestBase;

public class LoginPageTestSuite extends TestBase
{
	String filePath = "./testData/Credentials.xlsx";
	LoginPageActions loginPageActions;
	@Parameters(value="browser")
	@BeforeMethod
	public void initializeTest(String browser)
	{
		log.info("Test execution started");
		initialize(browser,"http://opensource.demo.orangehrmlive.com/");	
	}
	
	@Test(priority=1)
	public void loginWithValidCredentials()
	{
		loginPageActions = new LoginPageActions(driver);
		
		Screenshot.captureScreenshot(driver, "LoginPage");
		
		String username = ExcelFile.readExcel(filePath, 0, 1, 0);
		String password = ExcelFile.readExcel(filePath, 0, 1, 1);
		loginPageActions.enterUsername(username);
		log.info("Entered Useranme: "+username);
		loginPageActions.enterPassword(password);
		log.info("Entered Password: "+password);
		loginPageActions.clickLoginButton();	
		
		Screenshot.captureScreenshot(driver, "HomePage");
		
		String expTitle = "OrangeHRM";
		String actTitle = driver.getTitle();
		log.info("expTitle "+expTitle+" and actTitle: "+actTitle+ "are being compared");
		Assert.assertEquals(actTitle, expTitle);
	}
	
	@Test(priority=2)
	public void loginWithInvalidCredentials()
	{	
		loginPageActions = new LoginPageActions(driver);
		
		String username = ExcelFile.readExcel(filePath, 0, 2, 0);
		String password = ExcelFile.readExcel(filePath, 0, 2, 1);
		loginPageActions.enterUsername(username);
		log.info("Entered Useranme: "+username);
		loginPageActions.enterPassword(password);
		log.info("Entered Password: "+password);
		loginPageActions.clickLoginButton();
		
		Screenshot.captureScreenshot(driver, "ErrorLoginPage");
		
		String expError = "Invalid credentials";
		String actError = loginPageActions.getErrorLoignMessage();
		log.info("expError "+expError+" and actError: "+actError+ "are being compared");
		Assert.assertEquals(actError, expError);
	}
	
	@AfterMethod
	public void testClosure()
	{
		driver.close();
	}
}
