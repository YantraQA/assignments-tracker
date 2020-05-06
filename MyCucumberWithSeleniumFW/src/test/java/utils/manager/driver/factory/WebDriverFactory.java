package utils.manager.driver.factory;

public class WebDriverFactory 
{
	public static WebDriverManager getDriverManager(String browserType) throws Exception {

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
