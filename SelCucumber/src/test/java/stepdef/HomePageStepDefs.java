package stepdef;

import java.util.List;

import context.TestContextUI;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HomePageStepDefs
{
TestContextUI testContextUI;
Scenario scn;
	
public HomePageStepDefs(TestContextUI   testContextUI) {   //enject it foe use in class bcs directly cant use it
this.testContextUI=testContextUI;                          // passing referance to this for runtime use  DIinjection by picocontainer
		}

@Then("Below header Links are displayed")                   //now write logic in list for that menu which is in feature
public void below_header_Links_are_displayed(List<String>List) throws Exception{
	
for (int i=0;i<List.size();i++) {
try {
testContextUI.getCommonPageObjects().validateElementsPresentInHeader(List.get(i));	
}catch(Exception e) {
scn.write("Exceptoion throws"  +e.getMessage());

}}

}}
	
                                                                 /*if(List.contains("hamburger menu")) //	// validate hambergen menu
	                                                                   	{
	                                                              testContextUI.getCommonPageObjects().validateHambergerMenuIsDisplay();  
		                                                            	}
	                                                             	if(List.contains("amazon logo menu"))
	                                                                 	{
	                                                            testContextUI.getCommonPageObjects().validateamazonLogo();
	                                                                	}
		                                                              }}*/
