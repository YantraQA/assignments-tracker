package context;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import po.*;

public class TestContextUI
{
	WebDriver driver;
    CmnPgObjects cmnPgObjects;
    SearchPgObjects searchPgObjects;
	
    public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public CmnPgObjects getCmnPgObjects() {
		return cmnPgObjects;
	}
	public SearchPgObjects getSearchPgObjects() {
		return searchPgObjects;
	}
	
	public void initializePageObject(WebDriver driver,Scenario s)  //all the PO classes will get initialize here.
	{
		cmnPgObjects=new CmnPgObjects(driver, s);
		searchPgObjects=new SearchPgObjects(driver, s);
	}
	
}
