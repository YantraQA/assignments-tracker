package stepdefs.ui;

import java.util.List;

import context.TestContextUI;
import cucumber.api.Scenario;
import cucumber.api.java.en.Then;
import utils.ui.Interact;

public class HomePageStepDefs {

	TestContextUI testContextUI;
	Scenario scn;
	
	public HomePageStepDefs(TestContextUI testContextUI) {
		this.testContextUI = testContextUI;
	}
	
	@Then("Below options are displayed")
	public void below_options_are_displayed(List<String> list) {
		
		for(int i = 0; i < list.size(); i++) {
			try {
				testContextUI.getCmnPageObjects().ValidateElementsDisplayedOnHeaderLink(list.get(i));
			}catch(Exception e) {
		    	scn.write("Exception thrown: " + e.getMessage());
		    }
		}
	    
	    	
	    
	}
	
}
