package po;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.Scenario;
import utils.ui.Interact;

public class SearchPgObjects extends Interact {
	
	Scenario scn;
	
	private By  product_list=By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
	
	public SearchPgObjects(WebDriver driver,Scenario s)
	{
		setDriver(driver);
		this.scn=s;
	}
	
	public void ValidateProList(String proName)
	{
		List<WebElement> list_of_pro=getListOfWebElements(product_list);
		for(int i=0;i<list_of_pro.size();i++)      //iterate list of webElements
		{			
			 if(list_of_pro.get(i).getText().toLowerCase().contains(proName.toLowerCase()))
		        {
		        	Assert.assertTrue(true);
		        }else
		        {
		        	Assert.fail("Product not correctly displayed in the search result.Product at index: "+(i+1));
		        }
		}	
	}
	
}
