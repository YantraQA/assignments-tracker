package ui;

import java.util.concurrent.TimeUnit;

//import org.junit.Assert;
//import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.CmnPageObjects;
import pageobjects.SearchPageObjects;

public class SearchStepDefs {

	String url = "https://www.amazon.in/";
	WebDriver driver = null;
	CmnPageObjects cmnPageObjects = null;
	SearchPageObjects searchPageObjects = null;
	
	Scenario scn;
	
	@Before
	public void SetUp(Scenario s) {
		this.scn = s;
	}
	
	@AfterStep
	public void SetUpAfterEachLine() {
		//TakeScreenshot for each line
		/*
		TakesScreenshot scrnShot = (TakesScreenshot)driver;
		byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
		scn.embed(data, "image/png");
		*/
	}
	
	@After
	public void CleanUp(Scenario s) {
		// takes Screenshot onlt when failed
		if(s.isFailed()) {
			TakesScreenshot scrnShot = (TakesScreenshot)driver;
			byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
			scn.embed(data, "image/png");
		}
		
		//taking Screenshot even if passed or failed.
		/* 
		TakesScreenshot scrnShot = (TakesScreenshot)driver;
		byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
		scn.embed(data, "image/png");
		*/
		driver.quit();
		scn.write("Browser is Closed");
	}
	
	@Given("I have browser opened and url is nevigated")
	public void i_have_browser_opened_and_url_is_nevigated() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.get(url);		
		scn.write("Chrome Drier invoked and URL naigated as:" + url);
   
}
	@When("I Search for product as {string}")
	public void i_Search_for_product_as(String product) {
		cmnPageObjects = new CmnPageObjects(driver,scn);
		cmnPageObjects.SetSearchTextBox(product);
		cmnPageObjects.ClickOnSearchButton();
		scn.write("Search was Successful");
}
	@Then("product list should appear pertaining to the product search as {string}")
	public void product_list_should_appear_pertaining_to_the_product_search_as(String productName) {
    
		searchPageObjects = new SearchPageObjects(driver, scn);
		searchPageObjects.ValidateProductList(productName);
}
	
}


