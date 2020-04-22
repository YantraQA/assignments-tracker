package stepdefs;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.CommonPOM;
import pageobjects.SearchPOM;



public class SearchStepdef // missing step def method signature after running program
{

	String url="http://www.amazon.in";
	WebDriver driver= null;
	CommonPOM cm=null;
	SearchPOM sp=null;

	Scenario scn;
	@Before
	public void SetUp(Scenario s)
	{
		this.scn=s;

	}
	@AfterStep
	public void EachStepSceernShot()
	{
		TakesScreenshot scrshot=(TakesScreenshot)driver;
		byte[] data=scrshot.getScreenshotAs(OutputType.BYTES);
		scn.embed(data, "image/png");

	}

	@After	
	public void Cleanup(Scenario s) 
	{
		/*if(s.isFailed())
			{
			TakesScreenshot scrshot=(TakesScreenshot)driver;                
			byte[] data=scrshot.getScreenshotAs(OutputType.BYTES);
			scn.embed(data, "image/png");
			}*/

		/*TakesScreenshot scrshot=(TakesScreenshot)driver;                //want to takesreenshot aftercomplete procces before quit
		byte[] data=scrshot.getScreenshotAs(OutputType.BYTES);
		scn.embed(data, "image/png");*/

		driver.quit();
		scn.write("Browser is close");
	}


	@Given("I have browser opened and url is navigated")
	public void i_have_browser_opened_and_url_is_navigated() {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//cucumber matches @given and its text and then run it
		driver.manage().window().maximize();
		driver.get(url);
		scn.write("chrome driver is invoked and url is navigated as:"+ url);

	}

	@When("I search for product {string}")
	public void i_search_for_product(String product)   {   //string have value dell

		cm=new CommonPOM(driver,scn);
		cm.SetSearchTextBox(product);
		cm.ClickButton();
		scn.write("Search was succesful");
		/*	
	WebElement searchbox=driver.findElement(By.id("twotabsearchtextbox"));
	searchbox.sendKeys(product);                                                                                                                                                                             
	WebElement searchbutton=   driver.findElement(By.xpath("//input[@value='Go']"));
	searchbutton.click();
		 */
	}

	@Then("product list should appear pertaining to the product search as {string}")
	public void product_list_should_appear_pertaining_to_the_product_search_as(String productName){

		sp=new SearchPOM(driver);
		sp.ValidateProductList(productName);	




		/*WebElement productdescp=   driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));

		String name=productdescp.getText();

		if(productDescription.contains(productName))
				{
			Assert.assertTrue(true);
				}
		else {

			Assert.assertFalse("product not correctly displyed in search result",true);*/
	}


}


