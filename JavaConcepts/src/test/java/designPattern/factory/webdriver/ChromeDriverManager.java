package designPattern.factory.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import designPattern.factory.webdriver.WebDriverManager;

public class ChromeDriverManager extends WebDriverManager
{
	@Override
	public WebDriver initDriver() 
	{
		return new ChromeDriver();
	}

}
