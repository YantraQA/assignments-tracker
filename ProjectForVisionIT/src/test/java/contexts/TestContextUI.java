package contexts;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import pageObjects.CommonPageObject;
import pageObjects.SearchPageObject;



public class TestContextUI 
{
	private WebDriver driver;
	private CommonPageObject cmnPageObjects;
	private SearchPageObject searchPageObjects;
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public CommonPageObject getCmnPageObjects() {
		return cmnPageObjects;
	}

	public SearchPageObject getSearchPageObjects() {
		return searchPageObjects;
	}

	public void initializePageObjectClasses(WebDriver driver,Scenario scn) {
		cmnPageObjects = new CommonPageObject(driver,scn);
		searchPageObjects = new SearchPageObject(driver,scn);
	}
}
