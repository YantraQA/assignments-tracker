package amazonStefDefs;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

import context.TestBase;
import context.TestContextAmazon;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.CommonPageObjects;
import pageObjects.SearchPageObjects;
import staticmethod.WebDriverManagerSimple;
import utils.manager.driver.factory.WebDriverFactory;
import utils.manager.driver.factory.WebDriverManager;
import utils.manager.driver.singleton.WebDriverManagerSingleton;

public class SearchStefDefs extends TestBase
{
	TestContextAmazon testContextAmazon;
	//u cant direclty call this TestContextAmazon class u need to right as above and this. part
	Scenario scn; //object
	public SearchStefDefs(TestContextAmazon testContextAmazon) // constructor
	{
		this.testContextAmazon=testContextAmazon; // now its injected
	}

	//String url="https://www.amazon.in/";
	//WebDriver driver=null; //declaration of driver
	//CommonPageObjects cmnPageObjects=null;
	//SearchPageObjects SearchPageObjects=null;
	
	@Given("^I have browser opened and url is navigated$")
	public void i_have_browser_opened_and_url_is_navigated() throws Exception 
	{	/*Various ways of invoking Web Driver
		method 1*/
		WebDriverManager drivermanager= WebDriverFactory.getDriverManager("Chrome");
		WebDriver driver=drivermanager.getDriver();//commented bcz using singlton
		drivermanager.maximizeBrowser();
		drivermanager.navigateToDriver(server_amazon);
		
		scn.write("Chrome Driver invokedand URL navigated as:" +server_amazon);
		
		/*OR method-2
		 initialisation of driver
		this is loose code so for that i have created one class called 
		WebDriverManagerSimple which is abstract and encapsulated*/
		
		/*WebDriver driver= new ChromeDriver(); 
		//implicitwait
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.get(server_amazon);*/
		
			
		/*OR method-3*/
		/*
		  WebDriver driver=WebDriverManagerSingleton.getInstanceOfWebDriverManager().getDriver();
        */ 
		 
		/*OR Method 4
		WebDriver driver= WebDriverManagerSimple.getDriver("Chrome");*/
		
		 //assign driver and set page objects to TestsContext
		testContextAmazon.setDriver(driver);
		testContextAmazon.initializePageObject(driver, scn);
		
	}

	@When("I search for product as {string}")
	public void i_search_for_product_as(String product) 
	{
		testContextAmazon.getCmnPageObjects().SetSearchTextBox(product);
		testContextAmazon.getCmnPageObjects().ClickOnSearchButton();
		scn.write("search was successfull");
	}
		//using PageObjectmodel
		/*cmnPageObjects=new CommonPageObjects(driver,scn);
		cmnPageObjects.SetSearchTextBox(product);
		cmnPageObjects.ClickOnSearchButton();
		scn.write("search was successfull");

		WebElement searchbox =driver.findElement(By.id("twotabsearchtextbox"));
	   	searchbox.sendKeys(product);
	  	WebElement searchbutton =driver.findElement(By.xpath("//input[@value='Go']"));
	   	searchbutton.click();
	}
*/
	
	@Then("product list should appear pertaining to product search as {string}")
	public void product_list_should_appear_pertaining_to_product_search_as(String productName)
	{
		testContextAmazon.getSearchPageObjects().VAlidateProductList(productName);
	}
	@When("I click on hamburger menu")
	public void i_click_on_hamburger_menu() {
		testContextAmazon.getCmnPageObjects().ClickOnHamburgerMenuButton();
	}

	@When("I click on hamburger menu with category as {string}")
	public void i_click_on_hamburger_menu_with_category_as(String category) {
		testContextAmazon.getCmnPageObjects().ClickOnHamburgerMenuProductCategoryLink(category);
	}

	@When("I click on hamburger menu with sub category as {string}")
	public void i_click_on_hamburger_menu_with_sub_category_as(String subCategory) {
		testContextAmazon.getCmnPageObjects().ClickOnHamburgerMenuProductSubCategoryLink(subCategory);
	}

	@Then("Search results are displayed for products related to {string}")
	public void search_results_are_displayed_for_products_related_to(String expectedTitle) throws Exception {
		testContextAmazon.getCmnPageObjects().validatePageTitleMatch(expectedTitle);
	}
	@Before
	public void Setup(Scenario s) //interface also anative dependancy injection 
	{
		this.scn=s;// writting this to capture it in Scenario scn; object
	}
	
	/*//taking the screenshot after each step
	@AfterStep
	public void SetupAfterEachStep()
	{
		//2 WAY -take screenshot after each step-
		TakesScreenshot scrnShot=(TakesScreenshot)driver;
		byte[] data =scrnShot.getScreenshotAs(OutputType.BYTES);
		scn.embed(data,"image/png");
	}*/
	
	@After //KEEP ANY ONE WHILE RUNNING THE CODE
	public void CleanUp(Scenario s)//injecting here scenaro s.later u can remove this.
	{	
		//1 WAY- full page screenshot
		TakesScreenshot scrnShot=(TakesScreenshot)testContextAmazon.getDriver();
		byte[] data =scrnShot.getScreenshotAs(OutputType.BYTES);
		scn.embed(data,"image/png");
		 
		// 3 WAY- take screenshot only when something get failed 
		/*if(s.isFailed())
		{
			TakesScreenshot scrnShot=(TakesScreenshot)testContextAmazon.getDriver();
			byte[] data =scrnShot.getScreenshotAs(OutputType.BYTES);
			scn.embed(data,"image/png");
		}*/
		testContextAmazon.getDriver().quit(); 		
		//driver.close();  
		scn.write("Browser is closed");
	}
	
}















