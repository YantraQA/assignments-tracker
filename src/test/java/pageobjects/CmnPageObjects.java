package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import cucumber.api.Scenario;
import junit.framework.Assert;
import utils.ui.Interact;

public class CmnPageObjects extends Interact{

	Scenario scn;
	
	private By search_textbox = By.xpath("//input[@id='twotabsearchtextbox']");
	private By searchbutton = By.xpath("//input[@class='nav-input']");
	private By hamburger_menu_link = By.xpath("//a[@id='nav-hamburger-menu']");
	private By nav_logo_link = By.xpath("//a[@class='nav-logo-link']");
	private By accounts_and_lists = By.xpath("//a[@id='nav-link-accountList']");
	private By nav_returns_and_orders_link = By.xpath("//a[@id='nav-orders']");
	private By nav_cart_link = By.xpath("//a[@id='nav-cart']");
	private By nav_your_prime_link = By.xpath("//a[@id='nav-link-prime']");
	 
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
	
	
	public void ValidateElementsDisplayedOnHeaderLink(String text) throws Exception {
		boolean b = false;
		switch (text) {
			case "Hamburger menu" :
				b =  ValidateElementIsDisplyed(hamburger_menu_link);
				break;
			case "Amazon Prime logo" :
				b =  ValidateElementIsDisplyed(nav_logo_link);
				break;
			case "Accounts and list" :
				b = ValidateElementIsDisplyed(accounts_and_lists);
				break;
			case "Returns and Orders" :
				b = ValidateElementIsDisplyed(nav_returns_and_orders_link);
				break;
			case "Search Text Box" :
				b = ValidateElementIsDisplyed(search_textbox);
				break;
			case "Cart Link" :
				b = ValidateElementIsDisplyed(nav_cart_link);
				break;
			case "Your Prime Link" :	
				b = ValidateElementIsDisplyed(nav_your_prime_link);
				break;
			default:
//				logger.fatal("Header Link Description is not present in the case. Please add link description first.");
				scn.write("Header Link Description is not present in the case. Please addd link description first.");
				throw new Exception("Headder Link Description is not present in the case. Please add link description first.");
		}	
		if(b) {
			scn.write("header Link is displayed: " + text);
			Assert.assertEquals(true, b);
		}else {
			scn.write("Header link is not displayed: " + text);
			Assert.fail("Header Link is not dispplayed: " + text);
		}
				
	}
		
		
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


