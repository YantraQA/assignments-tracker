package pageobjects;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Interact;

public class SearchPOM extends Interact
{
//WebDriver driver;

	private By Product_list=By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
	//private By ProductDell=By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
	
		
    public SearchPOM(WebDriver driver)	
	{
	setDriver(driver);
	}
	
	public void ValidateProductList(String ProductName)
	{
		List<WebElement> list_product= getListOfWebElements(Product_list);
		
		for(int i=0;i<list_product.size();i++)
		{
			if(list_product.get(i).getText().toLowerCase().contains(ProductName.toLowerCase()))
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.fail("product not correctly displyed in search result.Product at index "+(i+1));
			}
		}
	}
	
	
		
	
	

}
