package pageObjects;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.Scenario;

public class SearchPageObjects extends Interact
{	
	//Design of PageObjectModels- see in comments
	//Declaring Driver
	Scenario scn;

	//Locators
	private By ProductList= By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");

	//constructor
	public SearchPageObjects(WebDriver driver, Scenario s)
	{	
		setDriver(driver);
		this.scn=s;
	}

	//methods1- performing operation on your elements
	//getting all the elements 1/16
	public void VAlidateProductList(String productName)
	{
		//collection part
		List<WebElement> list_products=getListOfWebElements(ProductList);
		for(int i=0;i<list_products.size(); i++)
		{
			if(  list_products.get(i).getText().toLowerCase().contains(productName.toLowerCase()))
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.fail("Product not correctly displayed in the search result.Product at index:+(i+1)");
			}
		}
	}
}
