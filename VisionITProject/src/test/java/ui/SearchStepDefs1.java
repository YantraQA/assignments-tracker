package ui;

import context.TestContextUI;
import cucumber.api.java.en.When;

public class SearchStepDefs1 {
	
	TestContextUI testContextUI;
	
	public SearchStepDefs1(TestContextUI testContextUI) {
		this.testContextUI = testContextUI;
	}
	//CmnPageObjects cmnPageObjects = null;
	//SearchPageObjects searchPageObjects = null;
	@When("I Search for product as {string}")
	public void i_Search_for_product_as(String product) {
		
		testContextUI.getCmnPageObjects().SetSearchTextBox(product);
		testContextUI.getCmnPageObjects().ClickOnSearchButton();
		
}

}
