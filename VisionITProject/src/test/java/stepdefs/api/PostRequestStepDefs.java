package stepdefs.api;

import java.util.HashMap;

import org.junit.Assert;

import context.TestBase;

import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

public class PostRequestStepdefs extends TestBase {
	
	TestContext testContext;
	
	public PostRequestStepdefs(TestContext testContext)
	{
		this.testContext = testContext;
	}
	String email = GetRandomString(10) + "@gmail.com";
	
	
	@Given("I set header and body is create new user")
	public void i_set_header_and_body_is_create_new_user() {
		
		//Get Random String for Email
				
				//Set Header
				HashMap<String,String> hm_header = new HashMap<String,String>();
				hm_header.put("Content-Type", "application/json");
				
				//Set Body
				String body_string = "{\n" + 
						"	\"gender\":\"female\",\n" + 
						"	\"last_name\":\"lastnamevisionit\",\n" + 
						"	\"first_name\":\"firstnamevisionit\",\n" + 
						"	\"email\":\""+ email +"\"\n" + 
						"}";
				
				req_spec.headers(hm_header).body(body_string);
				
	}

	@When("I hit the API with post request and end point as {string}")
	public void i_hit_the_API_with_post_request_and_end_point_as(String endPoint) {
	   resp= req_spec.when().post(endPoint);
	   System.out.println(resp.asString());
	}

	@Then("API created new user in the system")
	public void api_created_new_user_in_the_system() {
		resp.then()
		.statusCode(302)
		.assertThat()
		.body("_meta.success", equalTo(true))
		.body("_meta.code", equalTo(201))
		.body("_meta.message", equalTo("A resource was successfully created in response to a POST request. The Location header contains the URL pointing to the newly created resource."))
		.body("result.first_name", equalTo("firstnamevisionit"))
		.body("result.last_name", equalTo("lastnamevisionit"))
		.body("result.gender", equalTo("female"))
		.body("result.email", equalTo(email))
		.body("result.dob", equalTo(null));
	}

	@Then("I can find new user in the system when i get the user")
	public void i_can_find_new_user_in_the_system_when_i_get_the_user() {
	   String id = resp.jsonPath().getString("result.id");
	   Response resp_get= given()
			   .baseUri(server)
			   .auth().oauth2(accessToken)
			   .when()
			   .get("/public-api/users/" + id);
	   testContext.scn.write("get response after post:" + resp_get.asString());
	   
	   resp_get.then()
	   .assertThat()
	    .statusCode(200)
		.body("_meta.success", equalTo(true))
		.body("_meta.code", equalTo(200))
		.body("_meta.message", equalTo("OK. Everything worked as expected."))
		.body("result.first_name", equalTo("firstnamevisionit"))
		.body("result.last_name", equalTo("lastnamevisionit"))
		.body("result.gender", equalTo("female"))
		.body("result.email", equalTo(email))
		.body("result.dob", equalTo(null));
	   	
	}
	
	@Given("I set header and without any body")
	public void i_set_header_and_without_any_body() {
		HashMap<String,String> hm_header = new HashMap<String,String>();
		hm_header.put("Content-Type","application/json");
		req_spec.headers(hm_header);
		
	}

	@Then("API returned the error code as {int}")
	public void api_returned_the_error_code_as(Integer statusCode) {
	   resp.then().assertThat().body("meta.code",equalTo(statusCode));
	}

	@Then("error message display as {string}")
	public void error_message_display_as(String msg) {
	  String body_as_string = resp.asString();
	  Assert.assertTrue("Error Message:", body_as_string.contains(msg));
	}

	@Given("I set header and with fields but no values")
	public void i_set_header_and_with_fields_but_no_values() {
	   HashMap<String, String> hm_header = new HashMap<String, String>();
	   hm_header.put("Contect-Type", "application/json");
	   String body_string = "{\n" + 
				"	\"last_name\":\"\",\n" + 
				"	\"first_name\":\"\",\n" + 
				"	\"email\":\"\"\n" + 
				"	\"gender\":\"\"\n" + 
				"}";
	   testContext.scn.write("body sent as: " + body_string);
	   testContext.req_spec.headers(hm_header).body(body_string);
	   
	   
	}

	@Given("I set header and with incorrect email and gender")
	public void i_set_header_and_with_incorrect_email_and_gender() {
	   HashMap<String, String> hm_header = new HashMap<String, String>();
	   hm_header.put("Content-Type","application/json");
	   String body_string = "{\n" + 
				"	\"last_name\":1234,\n" + 
				"	\"first_name\":true,\n" + 
				"	\"email\":34324,\n" + 
				"	\"gender\":2343242\n" + 
				"}";
	   testContext.scn.write("body sent as: " + body_string);
	   testContext.req_spec.headers(hm_header).body(body_string);
	   
	}

	@Given("I set header and body with incorrect data types are sent for every mandatory field")
	public void i_set_header_and_body_with_incorrect_data_types_are_sent_for_every_mandatory_field() {
	  HashMap<String, String> hm_header = new HashMap<String, String>();
	  hm_header.put("Content-Type", "application/json");
	  
	  String body_string = "{\n" + 
				"	\"last_name\":1234,\n" + 
				"	\"first_name\":true,\n" + 
				"	\"email\":34324,\n" + 
				"	\"gender\":2343242\n" + 
				"}";
	  testContext.scn.write("body sent as :" + body_string);
	  
	  testContext.req_spec.headers(hm_header).body(body_string);
	}
}
