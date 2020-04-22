package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import utils.Interact;

public class CommonPOM extends Interact
{
	//WebDriver driver;
	Scenario scn;
	private By search_TextBox=By.id("twotabsearchtextbox");
	private By search_Button=By.xpath("//input[@value='Go']");
		
	public CommonPOM(WebDriver driver,Scenario s)	
	{
	setDriver(driver);;
	this.scn=s;
	}
	
	public void SetSearchTextBox(String text)
	{
		//now will do 
		
		setElement(search_TextBox,text);
		
		/* 2) second we do below steps 1st is in stepdef
		  WebDriverWait wait=new WebDriverWait(driver,60);
		 
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(search_TextBox));
		element.sendKeys(text);*/
		
		/*
		 * TakesScreenshot scrn=(TakesScreenshot)element;
		byte[] data=scrn.getScreenshotAs(OutputType.BYTES);            //want to take screen shot of particular element
		scn.embed(data, "image/png");
		*/
		
	}
	
	public void ClickButton()
	{
		clickElement(search_Button);
		
		//driver.findElement(search_Button).click();
	}
		
		
		/*
		 * WebElement searchbox=driver.findElement(By.id("twotabsearchtextbox"));
		searchbox.sendKeys(product);
		WebElement searchbutton=   driver.findElement(By.xpath("//input[@value='Go']"));
		searchbutton.click();
		 */
	

}

