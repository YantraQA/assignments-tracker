package webdriverfactory;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeManager extends DriverManager {
	@Override
	protected void initDriver() {
		driver = new ChromeDriver();

}
}
