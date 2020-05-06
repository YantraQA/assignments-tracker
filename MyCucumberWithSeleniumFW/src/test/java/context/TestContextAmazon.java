package context;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import pageObjects.*;
import utils.manager.driver.singleton.WebDriverManagerSingleton;

public class TestContextAmazon 
{
 private WebDriver driver;
 private CommonPageObjects cmnPageObjects;
 private SearchPageObjects SearchPageObjects;

public WebDriver getDriver() {
	return driver;
}
public void setDriver(WebDriver driver) {
	this.driver = driver;
}
public CommonPageObjects getCmnPageObjects() {
	return cmnPageObjects;
}
public SearchPageObjects getSearchPageObjects() {
	return SearchPageObjects;
}

public void initializePageObject(WebDriver driver, Scenario s)
{
	cmnPageObjects= new CommonPageObjects (driver, s);
	SearchPageObjects=new SearchPageObjects (driver, s);

	
}




}