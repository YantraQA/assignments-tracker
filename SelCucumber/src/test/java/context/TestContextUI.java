package context;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import pagaobjectmodel.CommonPageObjects;
import pagaobjectmodel.SearchPageaObj;

public class TestContextUI {    //we put all variable which i want to use in various stepdef file

	WebDriver driver;
	CommonPageObjects CommonPageObjects;
	SearchPageaObj SearchPageaObj;
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public CommonPageObjects getCommonPageObjects() {
		return CommonPageObjects;
	}
	public SearchPageaObj getSearchPageaObj() {
		return SearchPageaObj;
	}
	

public void InitialiazePageObject(WebDriver driver,Scenario s) {
	CommonPageObjects =new CommonPageObjects(driver, s);
	SearchPageaObj =new SearchPageaObj(driver, s);
	
	
}}



