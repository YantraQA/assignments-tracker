package designPattern.factory.webdriver;

import org.openqa.selenium.WebDriver;

import designPattern.factory.webdriver.WebDriverFactory;
import designPattern.factory.webdriver.WebDriverManager;

public class Runner 
{
	public static void main(String[] args) throws Exception
	{
		WebDriverManager webDriverManager = WebDriverFactory.getManager("chrome");
		WebDriver driver = webDriverManager.getDriver();
	}

}
