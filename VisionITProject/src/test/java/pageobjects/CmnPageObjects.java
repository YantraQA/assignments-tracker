package pageobjects;

import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import ui.Interact;

public class CmnPageObjects extends Interact {
	
	
	Scenario scn;
	private By search_text_box = By.id("twotabsearchtextbox");
	private By search_button = By.xpath("//input[@value='Go']");
	
	public CmnPageObjects(WebDriver driver, Scenario s) {
		setDriver(driver);
		this.scn = s;
	}
	public void SetSearchTextBox(String text) {
		
		setElement(search_text_box, text);
		
		/* WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(search_text_box));
		element.sendKeys(text);/* 
		
		//Takes ScreenShot of Element box only
		/*
		TakesScreenshot scrn = (TakesScreenshot)element;
		byte[] data = scrn.getScreenshotAs(OutputType.BYTES);
		scn.embed(data, "image/png");
		*/
	}
	
	public void ClickOnSearchButton() {
		
		clickElement(search_button);
		
		//driver.findElement(search_button).click();
		
		
	}
	
}
