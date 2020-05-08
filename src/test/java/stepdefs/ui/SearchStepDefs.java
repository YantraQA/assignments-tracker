package stepdefs.ui;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import context.TestBase;
import context.*;
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
import utils.ui.Interact;

public class SearchStepDefs extends TestBase {

	TestContextUI testContextUI;
	Scenario scn;
	
	public SearchStepDefs(TestContextUI testContextUI) {
		this.testContextUI = testContextUI;
	}
	
	@Given("I have browser opened and url is navigated")
	public void i_have_browser_opened_and_url_is_navigated() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		driver.get(serverUI);
		scn.write("Chrome Driver invoked and URL is navigated as: " + serverUI);
	
		testContextUI.setDriver(driver);
		testContextUI.initilaizePageObjectClasses(driver, scn);
	}

	@When("I searched for products as {string}")
	public void i_searched_for_products_as(String product) {
		testContextUI.getCmnPageObjects().SetSearchTextBox(product);
		testContextUI.getCmnPageObjects().ClickOnSearchButton();
		scn.write("Search was successfull");
		
	}

	@Then("Product list should appear pertaining to the product searched as {string}")
	public void product_list_should_appear_pertaining_to_the_product_searched_as(String productName) {
			
		testContextUI.getSearchPageObjects().ValidateProudctList(productName);
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
		
		testContextUI.getDriver().quit(); //closes all tabs 
		scn.write("Browser is closed");
	} 
	
}
	

