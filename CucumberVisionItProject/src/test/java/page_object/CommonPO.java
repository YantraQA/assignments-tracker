package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.Scenario;

public class CommonPO {
	WebDriver driver;
	Scenario scn;
	private By enter_key=By.xpath("//input[@id='twotabsearchtextbox']");
	private By click_search=By.xpath("//input[@type='submit']");

public CommonPO(WebDriver driver, Scenario s)
{
	this.scn=s;
	this.driver=driver;
}
public void SendkeysBox(String keys)
{
	WebElement element=driver.findElement(enter_key);
	element.sendKeys(keys);
	
	TakesScreenshot scrnshot=(TakesScreenshot)element;
	byte[] data=scrnshot.getScreenshotAs(OutputType.BYTES);
	scn.embed(data, "image/png");
}
public void iconclick()
{
	driver.findElement(click_search).click();
}
}