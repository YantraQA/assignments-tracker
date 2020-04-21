package stepdefs.ui;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import po.CmnPgObjects;
import po.SearchPgObjects;

public class SearchStepdefs extends TestBase {

	TestContextUI testContextUI;    //DI implementation
	
	public SearchStepdefs(TestContextUI testContextUI)
	{
		this.testContextUI=testContextUI;
	}
	
	//WebDriver driver=null;
	//CmnPgObjects cmnPgObjects=null;           //declaration only
	//SearchPgObjects srchPgObjects=null;
	//String url="https://www.amazon.in/";
	
	Scenario scn;
	
	@Before
	public void Setup(Scenario s)     //native dependency injection concept in cucumber
	{                                 //here cucumber is itself injecting object
		this.scn=s;
	}
	
	@Given("I have browser opened and url is navigated")
	public void i_have_browser_opened_and_url_is_navigated() {
	   
	    WebDriver driver=new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
	    driver.manage().window().maximize();
		driver.get(server_UI);
		scn.write("Chrome Driver invoked and URL navigated as: "+ server_UI);
		
		testContextUI.setDriver(driver);
		testContextUI.initializePageObject(driver, scn);  //Here all the PO classes will get initialized so need not to initialize them in other stepdef classes
		}

	@When("I search for product as {string}")
	public void i_search_for_product_as(String product) {

		testContextUI.getCmnPgObjects().SetSearchTxtBox(product);
		testContextUI.getCmnPgObjects().ClickSearchBtn();
		//cmnPgObjects=new CmnPgObjects(driver,scn);    //initialization  
		//cmnPgObjects.SetSearchTxtBox(product);
		//cmnPgObjects.ClickSearchBtn();
		scn.write("Search was Successful.");
	}

	@Then("product list should appear pertaining to the product search as {string}")
	public void product_list_should_appear_pertaining_to_the_product_search_as(String proName) {
		
		testContextUI.getSearchPgObjects().ValidateProList(proName);
		//srchPgObjects=new SearchPgObjects(driver,scn);
		//srchPgObjects.ValidateProList(proName);	
	}
	
	@AfterStep                           //to take scrnShot after each step
	public void SetUpAfterEachLine()
	{
		/*TakesScreenshot scrnShot=(TakesScreenshot)driver;
		byte[] data=scrnShot.getScreenshotAs(OutputType.BYTES);
		scn.embed(data, "image/png");*/
	}
	
	@After
	public void CleanUp(Scenario s)
	{
		/*TakesScreenshot scrnShot=(TakesScreenshot)driver;       //to execute after each scenario
		byte[] data=scrnShot.getScreenshotAs(OutputType.BYTES);
		scn.embed(data, "image/png");*/
		
		if(s.isFailed())
		{
			TakesScreenshot scrnShot=(TakesScreenshot)testContextUI.getDriver();
			byte[] data=scrnShot.getScreenshotAs(OutputType.BYTES);
			scn.embed(data, "image/png");
			//or s.embed(arg0, arg1);
		}
		
		testContextUI.getDriver().quit();
		scn.write("Browser is closed");
	}
	
}
