package stepdefs.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import context.TestBase;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import utils.api.CmnApiMethods;
import utils.ui.Ineract;

public class PutRequestsStepDefs extends TestBase{

	TestBase testContext;
	
	public PutRequestsStepDefs(TestBase testContext) {
		this.testContext = testContext;
	}
			
	//Get Random String for Email
	String email = GetRandomString(10)  + "@gmail.com";
	
	@Given("I have a new user created in the system")
	public void i_have_a_new_user_created_in_the_system() {
	    CmnApiMethods cmnApiMethod = new CmnApiMethods();
	    testContext.newUserID = cmnApiMethod.CreateNewUserInGoRestAPI();
	    testContext.scn.write("New user created with id as: " + testContext.newUserID);
	}

	@When("I hit the API with PUT Request to update the existing user details")
	public void i_hit_the_API_with_PUT_Request_to_update_the_existing_user_details() {
		//Set Header
				HashMap<String, String> hm_header = new HashMap<String, String>();
				hm_header.put("Content-Type", "application/json");
				
				System.out.println("Header " + hm_header.toString());
				
				//Set Body
				String body_string = "{\r\n" + 
						"	\"email\":\"" + email + "\"\r\n" + 
						"}";
				
				testContext.scn.write("Body sent aas: " + body_string);
				
				testContext.req_spec.headers(hm_header).body(body_string);

				testContext.scn.write("End Point: " + "/public-api/users/" + testContext.newUserID);
				testContext.resp = testContext.req_spec.put("/public-api/users/" + testContext.newUserID);
				testContext.scn.write("Response PUT Request: " + testContext.resp.asString());
	}

	@Then("API should update the user")
	public void api_should_update_the_user() {
		 testContext.resp.then().assertThat()
	 	.body("_meta.code", equalTo(200))
		.body("_meta.success", equalTo(true))
		.body("_meta.message", equalTo("OK. Everything worked as expected."))
		.body("result.email",equalTo(email));
	}

	@Then("GET request to the user should return updated information")
	public void get_request_to_the_user_should_return_updated_information() {
		//String id = resp.jsonPath().getString("result.id");
		Response resp_get = given()
				.baseUri(server)
				.auth().oauth2(accessToken)
				.when()
				.get("/public-api/users/" + testContext.newUserID);
		
		testContext.scn.write(" GET response after POST: " + resp_get.asString());
				
				resp_get.then().assertThat().statusCode(200)
				.body("_meta.success", equalTo(true))
				.body("_meta.code", equalTo(200))
				.body("_meta.message", equalTo("OK. Everything worked as expected."))
				.body("result.email",equalTo(email));
	}

	@When("I hit the API with PUT Request and setting wrong email and gender")
	public void i_hit_the_API_with_PUT_Request_and_setting_wrong_email_and_gender() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("error message displayed as {string}")
	public void error_message_displayed_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@When("I hit the API with PUT Request to update incorrect user")
	public void i_hit_the_API_with_PUT_Request_to_update_incorrect_user() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}
}
