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
import utils.ui.Ineract;

public class GetRequestsStepDefs extends TestBase{
	
	
	TestBase testContext;
	
	public GetRequestsStepDefs(TestBase testContext) {
		this.testContext = testContext;
	}

	@Given("Go Rest API is up and running")
	public void go_rest_API_is_up_and_running() {
	//Write code here that turns the phrase above into concrete actions
	//Given
		testContext.req_spec = given().baseUri(server).auth().oauth2(accessToken);
	}
		
	@When("I hit the API with GET Request and end point as {string}")
	public void i_hit_the_API_with_get_request_and_end_point_as(String endPoint) {
	//Write code here that turns the phrase above into concrete actions
	//When
		testContext.resp =	testContext.req_spec.when().get(endPoint);
		testContext.scn.write("Response of the request is:  " + testContext.resp.asString());
	}
	
	@Then("API should return all the users")
	public void api_should_return_all_the_users() {
	//Write code here that turns the phrase above into concrete actions	
	//Then
		 testContext.resp.then().assertThat().statusCode(200)
		.body("_meta.success", equalTo(true))
		.body("_meta.code", equalTo(200))
		.body("_meta.message", equalTo("OK. Everything worked as expected."))
		.body("result", not(emptyArray()));
	 
	}
	
	@Then("API should return all the users on page {int} only")
	public void api_should_return_all_the_users_on_specific_pagination_value(int pageNumber) {
	//Write code here that turns the phrase above into concrete actions	
		 testContext.resp.then().assertThat().statusCode(200)
		.body("_meta.success", equalTo(true))
		.body("_meta.code", equalTo(200))
		.body("_meta.message", equalTo("OK. Everything worked as expected."))
		.body("result", not(emptyArray()))
		.body("_meta.currentPage", equalTo(pageNumber));
	}
	
	@Then("API should return user details of user id {string}")
	public void api_should_return_single_user_details(String user_id) {
	//Write code here that turns the phrase above into concrete actions		
		 testContext.resp.then().assertThat().statusCode(200)
		.body("_meta.success", equalTo(true))
		.body("_meta.code", equalTo(200))
		.body("_meta.message", equalTo("OK. Everything worked as expected."))
		.body("result", not(emptyArray()))
		.body("result.id", equalTo(user_id));
	}
	
	@Then("API should return user not found response for id {string}")
	public void api_should_return_incorrect_user_details(String user_id) {
	//Write code here that turns the phrase above into concrete actions		
		
		
		 testContext.resp.then().assertThat().statusCode(200)
		.body("_meta.success", equalTo(false))
		.body("_meta.code", equalTo(404))
		.body("_meta.message", equalTo("The requested resource does not exist."))
		.body("result.name", equalTo("Not Found"))
		.body("result.message", equalTo("Object not found: " + user_id))
		.body("result.code", equalTo(0))
		.body("result.status", equalTo(404));
	}
	
	@Then("API should return all female users")
	public void api_should_return_all_users_with_gender_as_female() {
	//Write code here that turns the phrase above into concrete actions		
		testContext.resp.then().assertThat().statusCode(200)
		.body("_meta.success", equalTo(true))
		.body("_meta.code", equalTo(200))
		.body("_meta.message", equalTo("OK. Everything worked as expected."))
		.body("result.gender", everyItem(equalTo("female")));
	}
	
	@Then("API should return all users with gender as female and status as active")
	public void api_should_return_all_users_with_gender_as_female_and_status_as_active() {
	//Write code here that turns the phrase above into concrete actions		
		testContext.resp.then().assertThat().statusCode(200)
		.body("_meta.success", equalTo(true))
		.body("_meta.code", equalTo(200))
		.body("_meta.message", equalTo("OK. Everything worked as expected."))
		.body("result.gender", everyItem(equalTo("female")))
		.body("result.status", everyItem(equalTo("active")));
	}
}
