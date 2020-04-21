package stepdefs.api;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    TestContext testContext;
	
	public Hooks(TestContext testContext)
	{
		this.testContext=testContext;
	}
	
	@Before
	public void setup(Scenario s)
	{
		this.testContext.scn=s;
	}
	
	@After
	public void CleanUp()
	{
		testContext.req_spe=null;
		testContext.resp=null;
	}
}
