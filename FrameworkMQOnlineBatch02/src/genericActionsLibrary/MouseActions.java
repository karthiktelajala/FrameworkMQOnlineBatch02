package genericActionsLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseActions 
{
	public static void mouseHover(WebDriver driver, WebElement element)
	{
		Actions act =  new Actions(driver);
		act.moveToElement(element).build().perform();
	}
	
	public static void rightMouseClick(WebDriver driver, WebElement rmcElement)
	{
		Actions act =  new Actions(driver);	
//		act.moveToElement(rmcElement).contextClick().build().perform();
		//or
		act.contextClick(rmcElement).build().perform();
	}
	
	public static void dragAndDrop(WebDriver driver, WebElement dragElement, WebElement dropElement)
	{
		Actions act = new Actions(driver);
//		act.dragAndDrop(dragElement, dropElement).build().perform();
		//or
		act.clickAndHold(dragElement).moveToElement(dropElement).release().build().perform();
	}
		

}
