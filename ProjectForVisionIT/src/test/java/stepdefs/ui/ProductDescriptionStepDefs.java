package stepdefs.ui;

import context.TestBase;
import context.TestContextUI;
import cucumber.api.Scenario;

public class ProductDescriptionStepDefs extends TestBase 
{
	TestContextUI testContextUI;
	Scenario scn;
	
	public ProductDescriptionStepDefs(TestContextUI testContextUI)
	{
		this.testContextUI=testContextUI;
	}
	
}
