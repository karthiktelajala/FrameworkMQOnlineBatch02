package pageActionsLibrary;

import org.openqa.selenium.WebDriver;

import pageObjectsLibrary.LoginPageObjects;

public class LoginPageActions extends LoginPageObjects
{

	public LoginPageActions(WebDriver driver) 
	{
		super(driver);
	}
	
	public void enterUsername(String username)
	{
		txtUserName.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void clickLoginButton()
	{
		btnLogin.click();
	}
	
	public String getErrorLoignMessage()
	{
		return msgErrorLogin.getText();
	}

}
