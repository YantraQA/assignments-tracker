package po;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import utils.ui.Interact;

public class CmnPgObjects extends Interact {

	Scenario scn;
	
	private By search_text_box=By.id("twotabsearchtextbox");
	private By search_button=By.xpath("//input[@value='Go']");
	
	public CmnPgObjects(WebDriver driver, Scenario s)    //also pass Scenario object/instance to embed scrnShot
	{
		setDriver(driver);
		this.scn=s;
	}
	
	public void SetSearchTxtBox(String text)
	{
		setElement(search_text_box, text);
		/*WebDriverWait wait =new WebDriverWait(driver, 60);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(search_text_box));
	
		element.sendKeys(text);  //here expected condition is also performing findElement operation so need not to write .findElement method
		
		//to take scrnShot of a specific element only (instead of driver cast it with tat element)
		TakesScreenshot scrn=(TakesScreenshot)element;
		byte[] data=scrn.getScreenshotAs(OutputType.BYTES);
		scn.embed(data, "image/png");*/
	}
	
	public void ClickSearchBtn()
	{
		clickElement(search_button);
	}
	
	
	
}
