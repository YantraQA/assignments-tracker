package util;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import pageobject.SearchPO;
public class Di {
	
	WebDriver driver;
	SearchPO SearchPO;
	
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public SearchPO getSearchPO() {
		return SearchPO;
	}
	public void intializePageObject(WebDriver driver, Scenario S) {
		SearchPO= new  SearchPO(driver, S);
	}
}
