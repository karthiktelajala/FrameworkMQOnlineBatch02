package pageObjectsLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects 
{
	@FindBy(id="txtUsername")
	public WebElement txtUserName;
	
	@FindBy(name="txtPassword")
	public WebElement txtPassword;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement btnLogin;
	
	@FindBy(id="spanMessage")
	public WebElement msgErrorLogin;
	
	public LoginPageObjects(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
