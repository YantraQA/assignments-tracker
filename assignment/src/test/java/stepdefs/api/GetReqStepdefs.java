package stepdefs.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.not;

import context.TestBase;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetReqStepdefs extends TestBase
{
	TestContext testContext;
	
	public GetReqStepdefs(TestContext testContext)
	{
		this.testContext=testContext;
	}
			
	@Given("Go rest API is up and running")
	public void go_rest_API_is_up_and_running() {
		testContext.req_spe=given().relaxedHTTPSValidation().baseUri(server).auth().oauth2(accessToken);
	}

	@When("I hit the api with get request and end point as {string}")
	public void i_hit_the_api_with_get_request_and_end_point_as(String endpoint) {
		testContext.resp=testContext.req_spe.when().get(endpoint);
		testContext.scn.write("Response of the request is: "+testContext.resp.asString());
	}

	@Then("API should return all the users")
	public void api_should_return_all_the_users() {
		testContext.resp.then().assertThat()
		.statusCode(200)
		.body("_meta.success", equalTo(true))
		.body("_meta.code", equalTo(200))
		.body("_meta.message", equalTo("OK. Everything worked as expected."))
		.body("result", not(emptyArray()));
	}

	@Then("API should return all the users on page 5 only")
	public void api_should_return_all_the_users_on_page_5_only() {
		testContext.resp.then().assertThat()
	    .statusCode(200)
		.body("_meta.success", equalTo(true))
		.body("_meta.code", equalTo(200))
		.body("_meta.message", equalTo("OK. Everything worked as expected."))
		.body("_meta.currentPage", equalTo(5))
		.body("result", not(emptyArray()));
	}

	@Then("API should return user details of user id {string}")
	public void api_should_return_user_details_of_user_id(String s) {
		testContext. resp.then().assertThat()
			.statusCode(200)
			.body("_meta.success", equalTo(true))
			.body("_meta.code", equalTo(200))
			.body("_meta.message", equalTo("OK. Everything worked as expected."))
			.body("result", not(emptyArray()))
			.body("result.id", equalTo("477"));
	}
	
	@Then("API should return user not found response for id {string}")
	public void api_should_return_user_not_found_response_for_id(String s) {
		testContext.resp.then()
		.assertThat()
		.statusCode(200)
		.body("_meta.success", equalTo(false))
		.body("_meta.code", equalTo(404))
		.body("_meta.message", equalTo("The requested resource does not exist."))
		.body("result.name", equalTo("Not Found"))
		.body("result.message", equalTo("Object not found: 345355353534554355"))
		.body("result.code", equalTo(0))
		.body("result.status", equalTo(404));
		
	}
	
	@Then("API should return all the female users")
	public void api_should_return_all_the_female_users() {
		testContext.resp.then()
		.assertThat()
		.statusCode(200)
		.body("_meta.success", equalTo(true))
		.body("_meta.code", equalTo(200))
		.body("_meta.message", equalTo("OK. Everything worked as expected."))
		.body("result.gender", everyItem(equalTo("female")));
		
	}

	@Then("API should return all the female users with status as active")
	public void api_should_return_all_the_female_users_with_status_as_active() {
		testContext.resp.then()
		.assertThat()
		.statusCode(200)
		.body("_meta.success", equalTo(true))
		.body("_meta.code", equalTo(200))
		.body("_meta.message", equalTo("OK. Everything worked as expected."))
		.body("result.gender", everyItem(equalTo("female")))
		.body("result.status", everyItem(equalTo("active")));
		
	}

}
