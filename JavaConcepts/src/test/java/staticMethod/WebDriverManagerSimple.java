package staticMethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManagerSimple 
{
	public static WebDriver getDriver(String browser)
	{
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
			return driver;
		}
		else if (browser.equalsIgnoreCase("firefox"))
		{

		}
		return driver;
	}

}
