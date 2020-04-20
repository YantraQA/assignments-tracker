package ui;

import java.util.concurrent.TimeUnit;

//import org.junit.Assert;
//import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import context.TestBase;
import context.TestContextUI;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.CmnPageObjects;
import pageobjects.SearchPageObjects;

public class SearchStepDefs extends TestBase {
	
	TestContextUI testContextUI;
	
	public SearchStepDefs(TestContextUI testContextUI) {
		this.testContextUI = testContextUI;
	}

//	String url = "https://www.amazon.in/";
	//WebDriver driver = null;
	//CmnPageObjects cmnPageObjects = null;
	//SearchPageObjects searchPageObjects = null;
	
	Scenario scn;
	/*
		
		//taking Screenshot even if passed or failed.
		/* 
		TakesScreenshot scrnShot = (TakesScreenshot)driver;
		byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
		scn.embed(data, "image/png");
	
		driver.quit();
		scn.write("Browser is Closed");
	}
	*/
	
	@Given("I have browser opened and url is nevigated")
	public void i_have_browser_opened_and_url_is_nevigated() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.get(server_ui);		
		scn.write("Chrome Drier invoked and URL naigated as:" + server_ui);
		
		testContextUI.setDriver(driver);
		testContextUI.initializePageObject(driver, scn);
}
	
	@Then("product list should appear pertaining to the product search as {string}")
	public void product_list_should_appear_pertaining_to_the_product_search_as(String productName) {
		testContextUI.getSearchPageObjects().ValidateProductList(productName);
		
		//searchPageObjects = new SearchPageObjects(driver, scn);
		//searchPageObjects.ValidateProductList(productName);
}
	@Before
	public void SetUp(Scenario s) {
		this.scn = s;
	}
	@After
	public void CleanUp(Scenario s) {
		// takes Screenshot onlt when failed
		if(s.isFailed()) {
			TakesScreenshot scrnShot = (TakesScreenshot)testContextUI.getDriver();
			byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
			scn.embed(data, "image/png");
		}
		
		testContextUI.getDriver().quit();
		scn.write("Browser is Closed");
	}
}


