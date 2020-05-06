package pagaobjectmodel;

import java.util.concurrent.TimeUnit;



import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import junit.framework.Assert;
import utils.Interact;

public class CommonPageObjects extends Interact {
	
	private static final Logger logger = LogManager.getLogger(CommonPageObjects.class);
WebDriver driver;
Scenario scn;    //give u mechanism for embed screenshot also check status of scenari pass failed
	private By search_Text_Box=By.id("twotabsearchtextbox");
	private By search_Button=By.xpath("//input[@class='nav-input']");
	private By hamberger_menu_link=By.id("nav-hamburger-menu"); //this need correcspomding ,method
	private By 	nav_link_logo =By.xpath("//a[@class=nav-logo-link']");
	private By 	nav_link_cart =By.id("nav-cart");
	private By 	nav_link_prime =By.id("nav-link-prime");
	private By 	nav_link_orders =By.id("nav-order");
	private By 	nav_link_acount =By.id("nav-link-accountList");
	
public CommonPageObjects(WebDriver driver,Scenario s)    //webdriver on top put var webelement
	// create constuctor then methods for perform operation
	{
		
		this.driver=driver;
		this.scn=s;
	}
	
	

	public void SetSearchTextBox(String Text)
	{
		setElement(search_Text_Box, Text);
		logger.info("Value enetered in search box: " + Text);
		takeScreenShotAndAttachInReport(scn);}
		//WebDriverWait wait=new WebDriverWait(driver, 60);   
	//WebElement element=	wait.until(ExpectedConditions.elementToBeClickable(search_Text_Box));  //we put By bsc our format in by locator
	
//	element.sendKeys("text");
	/*TakesScreenshot scrn=(TakesScreenshot)element;  
	  byte[] data=scrn.getScreenshotAs(OutputType.BYTES);
	   scn.embed(data,"image/png");
	//driver.findElement(search_Text_Box)*/
	
	
	public void ClickOnSearchButton() {
		
	//	WebDriverWait wait=new WebDriverWait(driver,60);
		//WebElement element=	wait.until(ExpectedConditions.elementToBeClickable(search_Button));
	
		
		//driver.findElement(search_Button).click();
		try {
			clickElement(search_Button);	
			logger.info("Clicked on Search Button");
		}catch(Exception e) {
			logger.error("Exception occured while tring to click on search button. Exception: " + e.getMessage());
	}
	
	}
	public void validateHambergerMenuIsDisplay()
	{
	 boolean b=validateElementIsDisplayed(hamberger_menu_link);
		
		Assert.assertEquals(true, b);
	}
	
	public void validateamazonLogo()
	
	{
boolean b=validateElementIsDisplayed(nav_link_logo);
		
		Assert.assertEquals(true, b);
		}
		public void validateElementsPresentInHeader(String text) throws Exception {  //this methods use for validate no of elements at tiome for reduce method
boolean b=false;
		
	switch(text.toLowerCase().trim())
		{
		case"hamberger menu":
			b=validateElementIsDisplayed(hamberger_menu_link);
			break;
		case"amazon prime logo":
			b=validateElementIsDisplayed(nav_link_logo);
			break;
		
		case"accounts and list link":
			b=validateElementIsDisplayed(nav_link_cart);
			break;
		case"return and orders":
			b=validateElementIsDisplayed(nav_link_prime);
			break;
			
		case"your prime link":
			b=validateElementIsDisplayed(nav_link_orders);
			break;

		case"cart link":
			b=validateElementIsDisplayed(nav_link_acount);
			break;
		case"Search Test Box":
			b=validateElementIsDisplayed(search_Text_Box);
           default:
        	 logger.fatal("Header Link Description is not present in the case. Please add link description first.");
        	 scn.write("Header Link Description is not present in the case. Please add link description first.");
        	 throw new Exception("Header Link Description is not present in the case. Please add link description first.");
		}
	if(b)
	{
		scn.write("Header Link is displayed: " + text);
		Assert.assertEquals(true, b);
	}else {
		scn.write("Header Link is not displayed: " + text);
		Assert.fail("Header Link is not displayed: " + text);
		
		
	}
	
}}

