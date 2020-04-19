package stepdefs.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.not;

import context.TestBaseAPI;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GetRequestStepdefs extends TestBaseAPI {
	
	//RequestSpecification req_spec = null;
	//Response resp = null;	
	Scenario s;
	@Before
	public void setUp(Scenario s)
	{
		this.s = s;
	}
	
	@Given("Go Rest API up and running")
	public void go_Rest_API_up_and_running() {
		req_spec = given().baseUri(server).auth().oauth2(accessToken);
				
	}
	@When("I hit the API with Get request and end point as {string}")
	public void i_hit_the_API_with_Get_request_and_end_point_as(String endPoint) {
		resp = req_spec.when().get(endPoint);
		s.write("Response of the request is:" + resp.asString()+"<br>" );
	}

	@Then("API should return all the users")
	public void api_should_return_all_the_users() {
		resp.then()
		.assertThat()
		.statusCode(200)
		.body("_meta.success", equalTo(true))
		.body("_meta.code",equalTo(200))
		.body("_meta.message",equalTo("OK. Everything worked as expected."))
		.body("result", not(emptyArray()));
	}
	@Then("API should return user details of user id {string}")
	public void api_should_return_user_details_of_user_id(String user_id) {
		resp.then()
		.assertThat()
		.statusCode(200)
		.body("_meta.success", equalTo(true))
		.body("_meta.code",equalTo(200))
		.body("_meta.message",equalTo("OK. Everything worked as expected."))
		.body("result", not(emptyArray()))
		.body("result.id", equalTo(user_id));
	   
	}
	@Then("API should return all the users on page {int} only")
	public void api_should_return_all_the_user_on_page_only (int pagenumber) {
		resp.then()
		.assertThat()
		.statusCode(200)
		.body("_meta.success", equalTo(true))
		.body("_meta.code",equalTo(200))
		.body("_meta.message",equalTo("OK. Everything worked as expected."))
		.body("_meta.currentPage", equalTo(pagenumber))
		.body("result", not(emptyArray()));
		
	}
	
	@Then("API should return user not found response for id {string}")
	public void api_should_return_user_not_found_response_for_id(String user_id) {
		
		resp.then()
		.assertThat()
		.statusCode(200)
		.body("_meta.success", equalTo(false))
		.body("_meta.code",equalTo(404))
		.body("_meta.message",equalTo("The requested resource does not exist."))			
		.body("result.name", equalTo("Not Found"))	
		.body("result.message", equalTo("Object not found: "  + user_id))
		.body("result.code", equalTo(0))	
		.body("result.status", equalTo(404));
	}

	@Then("API should return all female users")
	public void api_should_return_all_female_users() {
		resp.then()
		.assertThat()
		.statusCode(200)
		.body("_meta.success", equalTo(true))
		.body("_meta.code																																																																										",equalTo(200))
		.body("_meta.message",equalTo("OK. Everything worked as expected."))			
		.body("result.gender", everyItem(equalTo("female")));
	}

	@Then("API should return all female users with status as active")
	public void api_should_return_all_female_users_with_status_as_active() {
		resp.then()
		.assertThat()
		.statusCode(200)
		.body("_meta.success", equalTo(true))
		//.body("_meta.code",equalTo(200))																																																																									",equalTo(200))
		.body("_meta.message",equalTo("OK. Everything worked as expected."))			
		.body("result.gender", everyItem(equalTo("female")))
		.body("result.status",everyItem(equalTo("active")));
	}

	@After
	public void postMethod(Scenario s) {
		if(s.isFailed()) {
			
		}
	}
}
