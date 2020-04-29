package pageobject;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import cucumber.api.Scenario;
import util.Interact;

public class SearchPO extends Interact {
	
	Scenario scn;

	private By enter_key=By.xpath("//input[@id='twotabsearchtextbox']");
	private By click_search=By.xpath("//input[@type='submit']");
	private By validate_pro = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");

public SearchPO(WebDriver driver, Scenario s)
{
	setDriver(driver);
	this.scn=s;	
}
public void SendkeysBox(String keys)
{
	setElement(enter_key,keys);
	/*TakesScreenshot scrnshot=(TakesScreenshot)element;
	byte[] data1=scrnshot.getScreenshotAs(OutputType.BYTES);
	scn.embed(data1, "image/png");*/
	//WebElement element=driver.findElement(enter_key);
	//element.sendKeys(keys);
}
public void iconclick()
{
	clickElement(click_search);
	//driver.findElement(click_search).click();
}
//public void ValidatePro(String keys2) {
	//getAttribute(validate_pro,keys2);
	//clickElement(validate_pro);
//}
public void ValidateProductList(String productName) {
	List<WebElement> list_products=getListOfWebElements(validate_pro);
	for (int i=0;i<list_products.size();i++) {
		if (list_products.get(i).getText().toLowerCase().contains(productName.toLowerCase())) {
			Assert.assertTrue(true);
		}else {
			Assert.fail("Product not correctly displayed in the search result. Product at index: " + (i+1));
		}
	}
	
}

}
