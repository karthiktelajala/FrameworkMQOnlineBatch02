package testBasePackage;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBase 
{
	public static final org.apache.log4j.Logger log = LogManager.getLogger(TestBase.class.getName());
	public WebDriver driver;
	
	public void initialize(String browser,String url)
	{
		String log4jPath = "log4jProperties";
		PropertyConfigurator.configure(log4jPath);
		launchBrowser(browser);
		log.info(browser+"Browser is Lauched");
		getURL(url);
		log.info("Navigated to the url: "+url);
	}
	public void launchBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\VD57\\Downloads\\SeleniumDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\VD57\\Downloads\\SeleniumDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	
	public void getURL(String url)
	{
		driver.get(url);
	}
	
	public void closeBrowser()
	{
		driver.close();
		log.info("Browser is closed");
	}
	
	public void quitBrowser()
	{
		driver.quit();
	}
	
	

}
