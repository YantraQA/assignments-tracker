package stepdef;
	import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;



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

import org.openqa.selenium.OutputType;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
	import cucumber.api.java.en.Then;
	import cucumber.api.java.en.When;
	import junit.framework.Assert;
import pagaobjectmodel.CommonPageObjects;
import pagaobjectmodel.SearchPageaObj;


	public class SearchStepDef extends TestBase
	
	{
		TestContextUI testContextUI;
		
		public SearchStepDef(TestContextUI   testContextUI) {                   //enject it foe use in class bcs directly cant use it
			this.testContextUI=testContextUI;                                      // passing referance to this for runtime use  DIinjection by picocontainer
			
			}
		
		Scenario scn; 
	                                                                                        /*	WebDriver driver=null;
		                                                                                   CommonPageObjects CommonPageObjects=null;
		                                                                                 SearchPageaObj SearchPageaObj=null;*/

		@Given("I have browser open and url is navigated")
		public void i_have_browser_open_and_url_is_navigated() 
		{
			
WebDriver driver=new ChromeDriver();	
 driver=new ChromeDriver();
 driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
driver.manage().window().maximize();
 driver.get(server_ui);
			                                                                        //we can attached our screenshot to the report by using this
		
	
		                                                                             
scn.write("Chrome Driver invoked and URL navigated as: " + server_ui);
                                                                                      //Outputs some text into the report.Parameters:text what to put in the report.
		    
testContextUI.setDriver(driver);
testContextUI.InitialiazePageObject(driver, scn);
		}
	
		@When("I search product as {string}")
		public void i_search_product_as(String product) {
			testContextUI.getCommonPageObjects().SetSearchTextBox(product);
			testContextUI.getCommonPageObjects().ClickOnSearchButton();
			scn.write("Search was sucessfull");
		}
		@Then("Product list should appear to the product seerch as {string}")
		public void product_list_should_appear_to_the_product_seerch_as(String productNmae) {
			testContextUI.getSearchPageaObj().ValidateProductList(productNmae);
			

		    }
	
		@Before
		public void SetUp(Scenario s) {
			this.scn = s; 
		}
		
		@AfterStep
		public void SetUpAfterEachLine() {
                                                                                 //TakesScreenshot scrnShot = (TakesScreenshot)driver;
                                                                                  //byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
                                                                                                   //scn.embed(data, "image/png");		
		}
		
		@After
		public void CleanUp(Scenario s) {
			
			if (s.isFailed()) {
				TakesScreenshot scrn = (TakesScreenshot)testContextUI.getDriver();
				byte[] data = scrn.getScreenshotAs(OutputType.BYTES);
				scn.embed(data, "image/png");	
			}
			
                                                             //			driver.close();	//closes only one tab out of several opened tabs
//			TakesScreenshot scrnShot = (TakesScreenshot)driver;
//			byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
			
			testContextUI.getDriver().quit();; //closes all tabs 
			scn.write("Browser is closed");
		}
	}



