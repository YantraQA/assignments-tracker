package singletonandchromemanager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {

	//Instance of Singleton Class
		private static WebDriverSingleton instanceOfSingletonClass=null;
		private static WebDriver driver;

		//Private Constructor
		private WebDriverSingleton() {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}

		//To create instance of Class
		public static WebDriverSingleton getInstanceOfWebDriverManager() {
			if(instanceOfSingletonClass==null) {
				instanceOfSingletonClass = new WebDriverSingleton();
			}
			return instanceOfSingletonClass;
		}

		//to get Driver
		public  WebDriver getDriver() {
			if (driver==null) {
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			}
			return driver;
		}


		public void CloseDriver() {
			if (!(driver==null)) {
				driver.quit();
				driver = null;

			}
		}
}
