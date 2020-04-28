package designPattern.factory.webdriver;

import org.openqa.selenium.WebDriver;

public abstract class WebDriverManager 
{
	protected abstract WebDriver initDriver();
	// we not used void here bcz we are returning the object.
	public WebDriver getDriver() 
	{
		return initDriver();
	}
}
