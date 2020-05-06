package utils.manager.driver.factory;

import java.util.concurrent.TimeUnit;

import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;

public abstract class WebDriverManager 
{ 
	protected WebDriver driver;
	protected abstract void initDriver();
	// we not used void here bcz we are returning the object.
	public WebDriver getDriver()
	{
		initDriver();
		return driver;
	}
	public void quiteDriver()
	{
		driver.quit();
	}
	public void closeDriver()
	{
		driver.close();
	}
	public void navigateToDriver(String url_ui)
	{
		driver.get(url_ui);
	}
	public void maximizeBrowser()
	{
		driver.manage().window().maximize();
	}
	
	public void SetImplicitWaitTimeOut(int timeInMiliSeconds)
	{
		driver.manage().timeouts().implicitlyWait(timeInMiliSeconds,TimeUnit.MILLISECONDS);
	}
}
