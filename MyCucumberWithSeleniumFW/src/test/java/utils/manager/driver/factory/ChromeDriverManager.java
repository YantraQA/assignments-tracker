package utils.manager.driver.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends WebDriverManager
{
	@Override
	protected void initDriver() 
	{
		driver=new ChromeDriver();
	}

}
