package utils.manager.driver.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxManager extends WebDriverManager
{
	@Override
	protected void initDriver() 
	{
		driver=new FirefoxDriver();
	}

}
