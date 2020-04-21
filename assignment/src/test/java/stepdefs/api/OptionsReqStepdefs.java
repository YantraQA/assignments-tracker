package stepdefs.api;

import context.TestBase;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.hamcrest.Matchers.equalTo;

public class OptionsReqStepdefs extends TestBase {

    TestContext testContext;
	
	public OptionsReqStepdefs(TestContext testContext)
	{
		this.testContext=testContext;
	}
	
	@When("I hit the api with options request")
	public void i_hit_the_api_with_options_request() {
		testContext.resp = testContext.req_spe.when().options("/public-api/users/6199"); //hard coded user used for now
		testContext.scn.write("Response recieved after options Request: " + testContext.resp.asString());
	}

	@Then("API should return the list of available methods")
	public void api_should_return_the_list_of_available_methods() {
		testContext.resp.then()
		.assertThat()
		.body("_meta.success", equalTo(true))
		.body("_meta.code", equalTo(200))
		.body("_meta.message",equalTo("OK. Everything worked as expected."))
		.body("_meta.allow", equalTo("GET, PUT, PATCH, DELETE, HEAD, OPTIONS"));
	}
	
}
