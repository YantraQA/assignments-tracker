package stepdefs.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.junit.Assert;

import context.TestBase;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ui.Ineract;

public class PostRequestStepDefs extends TestBase {
	
	TestBase testContext;
	
	public PostRequestStepDefs(TestBase testContext) {
		this.testContext = testContext;
	}
	
	
	//Get Random String for Email
	String email = GetRandomString(10)  + "@gmail.com";

	Integer statusCode = 200;
	
	@Given("I set header and Body to create new user")
	public void i_set_header_and_Body_to_create_new_user() {	
		//Set Header
		HashMap<String, String> hm_header = new HashMap<String, String>();
		hm_header.put("Content-Type", "application/json");
		
		System.out.println("Header " + hm_header.toString());
		
		//Set Body
		String body_string = "{\r\n" + 
				"	\"gender\":\"female\",\r\n" + 
				"	\"last_name\":\"lastnamevisionit\",\r\n" + 
				"	\"first_name\":\"firstnamevisionit\",\r\n" + 
				"	\"email\":\"" + email + "\"\r\n" + 
				"}";
		
		testContext.req_spec.headers(hm_header).body(body_string);

	}

	@When("I hit the API with POST Request and end point as {string}")
	public void i_hit_the_API_with_POST_Request_and_end_point_as(String endPoint) {
		testContext.resp = testContext.req_spec.when().post(endPoint);
//		System.out.println(resp.asString());
		testContext.scn.write("Response :" + testContext.resp.asString());
	}

	@Then("API created a new USER in the system")
	public void api_should_create_a_new_USER_in_the_system() {
		testContext.resp.then().statusCode(302).assertThat()
	 	.body("_meta.code", equalTo(201))
		.body("_meta.success", equalTo(true))
		.body("_meta.message", equalTo("A resource was successfully created in response to a POST request. The Location header contains the URL pointing to the newly created resource."))
		.body("result.first_name",equalTo("firstnamevisionit"))
		.body("result.last_name",equalTo("lastnamevisionit"))
		.body("result.gender",equalTo("female"))
		.body("result.email",equalTo(email))
		.body("result.dob",equalTo(null))
		.body("result.status",equalTo(null))
		.body("result.phone",equalTo(null))
		.body("result.address",equalTo(null))
		.body("result.website",equalTo(null));
	}

	@Then("I can find the new user in the system when i get the user")
	public void when_I_can_find_the_new_user_in_the_system_when_i_get_the_user() {
		String id = testContext.resp.jsonPath().getString("result.id");
		Response resp_get = given()
				.baseUri(server)
				.auth().oauth2(accessToken)
				.when()
				.get("/public-api/users/" + id);
		
		testContext.scn.write(" GET response after POST: " + resp_get.asString());
				
				resp_get.then().assertThat().statusCode(200)
				.body("_meta.success", equalTo(true))
				.body("_meta.code", equalTo(200))
				.body("_meta.message", equalTo("OK. Everything worked as expected."))
				.body("result.first_name",equalTo("firstnamevisionit"))
				.body("result.last_name",equalTo("lastnamevisionit"))
				.body("result.gender",equalTo("female"))
				.body("result.email",equalTo(email))
				.body("result.dob",equalTo(null))
				.body("result.status",equalTo(null))
				.body("result.phone",equalTo(null))
				.body("result.address",equalTo(null))
				.body("result.website",equalTo(null));
	}
	

	@Given("I set header but without any body")
	public void i_set_header_but_without_any_body() {
		HashMap<String, String> hm_header = new HashMap<String, String>();
		hm_header.put("Content-Type", "application/json");
		
		testContext.req_spec.headers(hm_header);
	}

	@Then("API returned the error code as {int}")
	public void api_returned_the_error_code_as(Integer int1) {
		testContext.resp.then().assertThat().body("_meta.code", equalTo(statusCode));
	}

	@Then("error message displayed {string}")
	public void error_message_displayed(String msg) {
		String body_as_string = testContext.resp.asString();
		Assert.assertTrue("Validation failed." , body_as_string.contains(msg));
	}

	@Given("I set header and body with fields but no values")
	public void i_set_header_and_body_with_fields_but_no_values() {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@Given("I set header and body with incorrect email and gender")
	public void i_set_header_and_body_with_incorrect_email_and_gender() {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@Given("I set header and body with incorrect data types are sent for every mandatory field")
	public void i_set_header_and_body_with_incorrect_data_types_are_sent_for_every_mandatory_field() {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}
}
