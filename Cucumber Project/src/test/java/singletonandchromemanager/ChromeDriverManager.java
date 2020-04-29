package singletonandchromemanager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager {
	
		public static WebDriver getDriver(String browser) {
			WebDriver driver=null;
			if (browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
				return driver;
			}else if (browser.equalsIgnoreCase("firefox")) {
				//yet to be written

			}
			return driver;
		}
}
