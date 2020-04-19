package pageobjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.Scenario;
import ui.Interact;

public class SearchPageObjects extends Interact {
	
	//WebDriver driver;
	
	Scenario scn;
	private By product_list = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
	
	//public SearchPageObjects(WebDriver driver) {
		//this.driver = driver;
	
	public SearchPageObjects(WebDriver driver, Scenario s) {
		setDriver(driver);
		this.scn = s;
		
	}
public void ValidateProductList(String productName) {
	
	//List<WebElement> list_product = driver.findElements(product_list);
	List<WebElement> list_product = getListOfWebElements(product_list);
	for(int i=0; i<list_product.size();i++) {
	if (list_product.get(i).getText().toLowerCase().contains(productName.toLowerCase())) {
	    Assert.assertTrue(true);
	    } else {
	    	Assert.fail("product no correctly displayed in the search result, product at index:" + (i+1));
	    }
	}
}
}
