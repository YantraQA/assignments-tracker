package stepdefs.ui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sun.tools.xjc.Driver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageObjects.CommonPageObject;
import pageObjects.SearchPageObject;

public class SearchProductStepdefs 
{
	String Url ="http://www.amazon.in/";
	WebDriver driver = null;
	CommonPageObject cmnpaageobject = null;
	SearchPageObject searchpageobject= null;
	
	Scenario scn;
	@Before
	public void Setup(Scenario s)
	{
		this.scn=s;
	}
	@AfterStep
	public void SetupAfterLine()
	{
		/*TakesScreenshot scrnshot =(TakesScreenshot)driver;
		byte[] data=scrnshot.getScreenshotAs(OutputType.BYTES);
		scn.embed(data, "image/png");*/
	}
	@After
	public void CleanUp(Scenario s)
	{
		if(s.isFailed())
		{
			TakesScreenshot scrnshot =(TakesScreenshot)driver;
			byte[] data=scrnshot.getScreenshotAs(OutputType.BYTES);
			scn.embed(data, "image/png");
		}
		driver.quit();
		scn.write("Browser is closed");
	}
	   
	
	@Given("I have browser open and url is navigated")
	public void i_have_browser_open_and_url_is_navigated() 
	{
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.get(Url);
	    scn.write("Chrome driver invoked and URL is nvigated as:" + Url);
	}

	@When("I search for product as {string}")
	public void i_search_for_product_as(String product) 
	{
		cmnpaageobject =new CommonPageObject(driver, scn);
		cmnpaageobject.SetSearchTextBox(product);
		cmnpaageobject.ClickOnSearchButton(); 
		scn.write("Search was successfully done");
	}

	@Then("Product list should appear pertaining to the product search as {string}")
	public void product_list_should_appear_pertaining_to_the_product_search_as(String productName)
	{
		searchpageobject = new SearchPageObject(driver,scn);
		searchpageobject.validateProductList(productName);
		
		
	}
	
	
	
	   
	   
	   

}
