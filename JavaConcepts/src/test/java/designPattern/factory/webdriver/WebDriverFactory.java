package designPattern.factory.webdriver;

import org.openqa.selenium.remote.BrowserType;

import designPattern.factory.shape.Circle;
import designPattern.factory.shape.Rectangle;
import designPattern.factory.shape.Shape;
import designPattern.factory.shape.Triangle;
import designPattern.factory.webdriver.ChromeDriverManager;
import designPattern.factory.webdriver.FireFoxManager;
import designPattern.factory.webdriver.WebDriverManager;

public class WebDriverFactory 
{
	public static WebDriverManager getManager(String browserType) throws Exception {

	WebDriverManager webDriverManager;
	switch (browserType.toLowerCase()) {
	case "chrome":
		webDriverManager = new ChromeDriverManager();
		break;
	case "firefox":
		webDriverManager = new FireFoxManager();
		break;
	default:
		throw new Exception("no such browser is present to be initialize. Browser name: " + browserType);
	}
	
	return webDriverManager;
}
}
