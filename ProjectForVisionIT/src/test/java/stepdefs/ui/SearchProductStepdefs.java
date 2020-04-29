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

import contexts.TestContextUI;
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
import utils.api.Testbase;

public class SearchProductStepdefs extends Testbase
{
	TestContextUI testContextUI;
	Scenario scn;
	
	
	public SearchProductStepdefs(TestContextUI testContextUI)
	{
		this.testContextUI=testContextUI;
	}
	
	@Given("I have browser open and url is navigated")
	public void i_have_browser_open_and_url_is_navigated() 
	{
	   /*Various way to invoking the web driver*/
		/*Method:-1*/
		
		DriverManager driverManager = DriverFactory.getDriverManager("chrome");
		WebDriver driver = driverManager.getDriver();
		driverManager.maximizeBrowser();
		driverManager.navigateToDriver(serverUI);
		
		/*Method:-2*/
	  /* WebDriver driver = new ChromeDriver();
	    *driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
	    *driver.manage().window().maximize();
	    *driver.get(serverUI);
	   */
	    
	    /*Method:-3*/
	    /*
		 WebDriver driver = WebDriverManagerSingleton.getInstanceOfWebDriverManager().getDriver();
		*/
	    
		/*Method :-4*/
	    /*
		WebDriver driver = WebDriverManagerSimple.getDriver("chrome");
		*/
		scn.write("Chrome driver invoked and URL is nvigated as:" + serverUI);
	    
	  //Assign driver and set page Objects to Test Context 
	  		testContextUI.setDriver(driver);
	  		testContextUI.initializePageObjectClasses(driver, scn);
	}

	@When("I search for product as {string}")
	public void i_search_for_product_as(String product) 
	{
		testContextUI.getCmnPageObjects().SetSearchTextBox(product);
		testContextUI.getCmnPageObjects().ClickOnSearchButton();
		scn.write("Search was successfully done");
	}

	@Then("Product list should appear pertaining to the product search as {string}")
	public void product_list_should_appear_pertaining_to_the_product_search_as(String productName)
	{
		testContextUI.getSearchPageObjects().validateProductList(productName);
		
	}
	
	@Before
	public void SetUp(Scenario s) {
		this.scn = s;
	}


	@After
	public void CleanUp(Scenario s) {

		if (s.isFailed()) {
			TakesScreenshot scrnShot = (TakesScreenshot)testContextUI.getDriver();
			byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
			scn.embed(data, "image/png");
		}

		testContextUI.getDriver().quit();
		scn.write("Browser is Closed");
	}

	
	
	
	   
	   
	   

}
