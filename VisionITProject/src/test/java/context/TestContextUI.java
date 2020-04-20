package context;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import pageobjects.*;

public class TestContextUI {

	WebDriver driver;
	CmnPageObjects cmnPageObjects;
	SearchPageObjects searchPageObjects;
	
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public CmnPageObjects getCmnPageObjects() {
		return cmnPageObjects;
	}
	public SearchPageObjects getSearchPageObjects() {
		return searchPageObjects;
	}
	
	public void initializePageObject(WebDriver driver, Scenario s) {
		
		cmnPageObjects = new CmnPageObjects(driver,s);
		searchPageObjects = new SearchPageObjects(driver,s);
		
	}
}
