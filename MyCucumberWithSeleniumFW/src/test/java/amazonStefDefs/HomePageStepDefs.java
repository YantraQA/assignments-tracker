package amazonStefDefs;

import java.util.List;

import context.TestContextAmazon;
import cucumber.api.Scenario;
import cucumber.api.java.en.Then;

public class HomePageStepDefs {

	TestContextAmazon testContextAmazon;
	Scenario scn;

	public HomePageStepDefs(TestContextAmazon testContextAmazon) {
		this.testContextAmazon = testContextAmazon;
	}

	@Then("Below header Links are displayed")
	public void below_header_Links_are_displayed(List<String> list) throws Exception {

		for (int i=0;i<list.size();i++) {
			testContextAmazon.getCmnPageObjects().validateElementPresentInHeaderSection(list.get(i));	
		}

	}
}
