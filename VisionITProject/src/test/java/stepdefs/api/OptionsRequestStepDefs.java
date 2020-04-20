package stepdefs.api;
import static org.hamcrest.Matchers.equalTo;

import context.TestBase;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OptionsRequestStepdefs extends TestBase {
	
	TestContext testContext;
	public OptionsRequestStepdefs(TestContext testContext) {
		this.testContext = testContext;
		
	}
	
	@When("I hit the API with option request")
	public void i_hit_the_API_with_option_request() {
	   testContext.resp = testContext.req_spec.when().options("/public-api/users/6199"); //used hard coded user here for now
	   testContext.scn.write("Response put Request:" + testContext.resp.asString());
	}

	@Then("API should return the list of available methods")
	public void api_should_return_the_list_of_available_methods() {
	 testContext.resp.then().assertThat().body("_meta.allow", equalTo("GET, PUT, PATCH, DELETE, HEAD, OPTIONS"));
	}

}
