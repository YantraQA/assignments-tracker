package pageobjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.Scenario;
import utils.ui.Interact;

public class SearchPageObjects extends Interact{

	Scenario scn;
	
	//private By productDescp = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
	private By product_list = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
	
	public SearchPageObjects(WebDriver driver, Scenario s) {
		setDriver(driver);
		this.scn = s;
	}
	
	/*
	public String getProductText() {
		return driver.findElement(productDescp).getText();
	} */
	
	public void ValidateProudctList(String productName) {
		
		List<WebElement> list_products = getListOfWebElements(product_list);
		
		for(int i = 0; i < list_products.size(); i++) {
			
			//String elementText = list_products.get(i).getText();
			
			//if(elementText.contains(productName)) 
			if(list_products.get(i).getText().toLowerCase().contains(productName.toLowerCase()))	
			{
		    	Assert.assertTrue(true);
		    }
		    else {
		    	Assert.fail("Product not correctly displayed in the search result" + (i+1));
		    } 
		
		}
	}
}
