package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import utils.ui.Interact;

public class CmnPageObjects extends Interact{

	Scenario scn;
	
	private By search_textbox = By.xpath("//input[@id='twotabsearchtextbox']");
	private By searchbutton = By.xpath("//input[@class='nav-input']");
	
	 
	public CmnPageObjects(WebDriver driver, Scenario s) {
		//this.driver = driver;
		setDriver(driver);
		this.scn = s;
	}
	
	public void SetSearchTextBox(String text) {
		
		setElement(search_textbox, text);
		
//		WebDriverWait wait = new WebDriverWait(driver, 60);
//		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(search_textbox));
//		
//		element.sendKeys(text);
		
//		TakesScreenshot scrn = (TakesScreenshot) element;
//		byte[] data = scrn.getScreenshotAs(OutputType.BYTES);
//		scn.embed(data, "image/png");
		
		//driver.findElement(search_textbox).sendKeys(text);
	}
	
	public void ClickOnSearchButton() {
		clickElement(searchbutton);
	}
		
//	public void clickElement() {
//		
//		clickElement(searchbutton);
//		
//		WebDriverWait wait = new WebDriverWait(driver, 60);
//		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
//		driver.findElement(by).click();
//	}
	
//	String id_searchTextBox = "//input[@id='twotabsearchtextbox']";
	
	/*
	 * 	   WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	   searchBox.sendKeys(product);
	   
	   WebElement searchButton = driver.findElement(By.xpath("//input[@class='nav-input']"));
	   searchButton.click();
	 * 
	 */
	
}
