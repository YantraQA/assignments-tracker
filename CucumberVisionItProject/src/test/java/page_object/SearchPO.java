package page_object;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.Scenario;

public class SearchPO {
	WebDriver driver;
	Scenario scn;
	private By EnterKeys=By.id("twotabsearchtextbox");
	private By click=By.xpath("//input[@type='submit']");
	private By product_list=By.xpath("//div[@class='a-section a-spacing-medium']");
	
	
	public SearchPO(WebDriver driver,Scenario s) {
		this.driver=driver;
		this.scn=s;
	}
	
	public void SendkeysBox(String ProductName)
	{
		WebElement element=driver.findElement(EnterKeys);
		element.sendKeys(ProductName);
		TakesScreenshot scnshot=(TakesScreenshot)element;
		byte[] data=scnshot.getScreenshotAs(OutputType.BYTES);
		scn.embed(data,"image/png");
	}
	
	public void iconclick()
	{
		driver.findElement(click).click();
	}
	public void Check_ProductList(String Product_Name)
	{
		List<WebElement> ListOf_Pro=driver.findElements(product_list);
		for(int i=2; i<ListOf_Pro.size(); i++)
		{	
		String temp=ListOf_Pro.get(i).getText();
		if(temp.contains(Product_Name)) {
			driver.findElement(product_list).click();
			//driver.findElement(ListOf_Pro.get(i)).click();
			System.out.println("pass");
			Assert.assertTrue(true);
		    break;	}
		
		else {
			Assert.fail("product fail" + (i+1));}
		}
	}
}
