package utils.manager.driver.factory;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxManager  extends DriverManager 
{
	@Override
	public void initDriver()
	{
		driver = new FirefoxDriver();
		
	}
}
