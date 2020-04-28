package designPattern.factory.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxManager extends WebDriverManager
{
	@Override
	public WebDriver initDriver() 
	{
		return new FirefoxDriver();
	}
}
