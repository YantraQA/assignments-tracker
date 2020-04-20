package amazonStefDefs;

import context.TestBase;
import context.TestContextAmazon;
import cucumber.api.java.en.When;
import pageObjects.CommonPageObjects;
import pageObjects.SearchPageObjects;

public class SearchStefDefs1 extends TestBase 
{
	TestContextAmazon testContextAmazon;
	
	public SearchStefDefs1(TestContextAmazon testContextAmazon) // constructor
	{
		this.testContextAmazon=testContextAmazon; // now its injected
	}
	@When("I search for product as {string}")
	public void i_search_for_product_as(String product) 
	{
		//using PageObjectmodel
		//cmnPageObjects=new CommonPageObjects(driver,scn);

		testContextAmazon.getCmnPageObjects().SetSearchTextBox(product);
		testContextAmazon.getCmnPageObjects().ClickOnSearchButton();
		
	
	}
}
