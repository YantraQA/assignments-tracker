/*package stepdef;

import org.openqa.selenium.WebDriver;

import context.TestContextUI;
import cucumber.api.Scenario;
import cucumber.api.java.en.When;
import pagaobjectmodel.CommonPageObjects;
import pagaobjectmodel.SearchPageaObj;

public class SearchStepDef1
{
	TestContextUI testContextUI;
public SearchStepDef1(TestContextUI testContextUI)
{
this.testContextUI=testContextUI;
}
	
	
	@When("I search product as {string}")
	public void i_search_product_as(String product) {
		testContextUI.getCommonPageObjects().SetSearchTextBox(product);
		testContextUI.getCommonPageObjects().ClickOnSearchButton();
		scn.write("Search was sucessfull");
}
}*/