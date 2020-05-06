package utils.manager.driver.singleton;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class WebDriverManagerSingleton
{

	// this is a Instance of a singleton class
	private static WebDriverManagerSingleton instanceOfSingletonClass=null;
	private static WebDriver driver;
	
	// Constructor should be private
	private WebDriverManagerSingleton()
	{
		//No need for below statement if chrome driver is in class path
		//otherwise u need to use/set system.setproperty
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	//now to create a instanace ofA Class- creating method
	
	public static WebDriverManagerSingleton getInstanceOfWebDriverManager()
	{
	if(instanceOfSingletonClass==null)
	{
		instanceOfSingletonClass=new WebDriverManagerSingleton();
	}
	return instanceOfSingletonClass; 
	}
	
	//to get the Driver
	public WebDriver getDriver()
	{
		if(driver==null)
		{
			//No need for below statement if chrome driver is in class path
			//otherwise u need to use/set system.setproperty
			driver= new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		return null;
	}
	
	public void CloseDriver()
	{
		if(!(driver==null))
		{
			driver.quit();
			driver=null;
		}
	}
	

}
