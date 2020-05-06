package pagaobjectmodel;


import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.Scenario;
import junit.framework.Assert;
import utils.Interact;



public class SearchPageaObj extends Interact{
WebDriver driver;
String productNmae;
	
	private By product_list=By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
	public SearchPageaObj(WebDriver driver, Scenario scn)
	{
	this.driver=driver;

		

	}
	public void ValidateProductList(String product)
	{
		
	List<WebElement> list_products=	driver.findElements(product_list);  // list
	
	for(int i=0;i<list_products.size();i++)
	{
	
	if(list_products.get(i).getText().toLowerCase().contains(productNmae.toLowerCase()))
	
	

	{
		Assert.assertTrue(true);
	}
	else
	{
		Assert.fail("prosuct is not correctcly dispaly on serach result.product at index" + (i+1));
		
		

	}
}}}