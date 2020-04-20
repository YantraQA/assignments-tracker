package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.Scenario;
import junit.framework.Assert;
import utils.ui.Interact;

public class SearchPageObject extends Interact
{
	Scenario scn;
	private By Product_List = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
	
	public SearchPageObject(WebDriver driver, Scenario s)
	{
		setDriver (driver);
		this.scn=s;
	}
	
	public void validateProductList(String productName)
	{
		List<WebElement> list_product =getListOfWebElement(Product_List);	
		
		for(int i=0;i<list_product.size();i++)
		{
			if(list_product.get(i).getText().toLowerCase().contains(productName.toLowerCase()))
			   {
				   Assert.assertTrue(true);
			   }
			   else
			   {
				   Assert.fail("Product is not correctly display is search result. Product at index:"+(i+1));
				   
			   }
		}

		
	}
}
