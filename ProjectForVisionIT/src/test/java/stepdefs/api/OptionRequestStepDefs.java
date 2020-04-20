package stepdefs.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import java.util.HashMap;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import utils.api.Testbase;


public class OptionRequestStepDefs extends Testbase 
{
	TestContext testContext;
	public OptionRequestStepDefs(TestContext testContext)
	{
		this.testContext=testContext;
	}
	/*Scenario scn;
	@Before 
	public void SetUp(Scenario s)
	{
	 this.scn=s;
	}*/
	@When("I hit the api with options request")
	public void i_hit_the_api_with_options_request() 
	{
		testContext.resp = testContext.req_spec.when().options("/public-api/users/6199"); 
		testContext.scn.write("Response Put Request: " + testContext.resp.asString());
	}

	@Then("API should return the list of available methods")
	public void api_should_return_the_list_of_available_methods() 
	{
		testContext.resp.then().assertThat().body("_meta.allow", equalTo("GET, PUT, PATCH, DELETE, HEAD, OPTIONS"));
		
	}
}
