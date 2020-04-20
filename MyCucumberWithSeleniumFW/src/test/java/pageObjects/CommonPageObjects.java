package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import cucumber.api.Scenario;


public class CommonPageObjects extends Interact {
	//Design of PageObjectModels- see in comments
	
	Scenario scn;

	//Locators
	private By search_textbox= By.id("twotabsearchtextbox");
	private By search_button= By.xpath("//input[@value='Go']");
	
	//constructor
	public CommonPageObjects(WebDriver driver, Scenario s)
	{
		setDriver(driver);
		this.scn=s;
	}
	//methods1- performing operation on your elements
	public void SetSearchTextBox(String text)
	{
		setElement(search_textbox,text);
	}
	public void ClickOnSearchButton()
	{
		clickElement(search_button);
	}
		
}
