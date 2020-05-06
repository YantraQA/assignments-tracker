
package utils.manager.driver.factory;
import org.openqa.selenium.WebDriver;

public class Runner
{
	public static void main(String[]args) throws Exception
	{
		{
			WebDriverManager webDriverManager = WebDriverFactory.getDriverManager("chrome");
			WebDriver driver = webDriverManager.getDriver();
		}
	}
}
