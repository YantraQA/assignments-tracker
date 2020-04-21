package stepdefs.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import java.util.HashMap;

import org.junit.Assert;

import context.TestBase;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import utils.api.CmnApiMethods;

public class PutReqStepdefs extends TestBase {

	 TestContext testContext;
		
	  public PutReqStepdefs(TestContext testContext)
		{
			this.testContext=testContext;
		}
	
	 // String newUserID=null;
		String email=GetRandomString(7)+"@gmail.com";     //i.e. it will take 7 char
			
	@Given("I have a new user created in the system")
	public void i_have_a_new_user_created_in_the_system() {
	    
		CmnApiMethods cmnApiMethod=new CmnApiMethods();
		testContext.newUserID=cmnApiMethod.CreateNewUsersInGoRestApi();
		testContext.scn.write("New user created with id as: "+testContext.newUserID);
		
	}

	@When("I hit the api with put request to update the existing user details")
	public void i_hit_the_api_with_put_request_to_update_the_existing_user_details() {
	    
		 String Body="{\r\n" + 
		 		"\r\n" + 
		 		"	\"email\":\""+email+"\"\r\n" + 
		 		"}";
			  
		       testContext.scn.write("Body sent as: "+Body);
			   
			   HashMap<String,String> hm_header=new HashMap<String,String>();
			   hm_header.put("Content-Type", "application/json");
			  
			   testContext.req_spe.headers(hm_header).body(Body);
			   
			   testContext.scn.write("End Point given as: "+"/public-api/users/"+testContext.newUserID);
			   testContext.resp=testContext.req_spe.put("/public-api/users/"+testContext.newUserID);
			   testContext.scn.write("Response recieved after Put Req: "+testContext.resp.asString());

	}

	@Then("API should update the user")
	public void api_should_update_the_user() {
		testContext.resp.then()
	    .assertThat()
	    .statusCode(200)
		   .body("_meta.success", equalTo(true))
		   .body("_meta.code", equalTo(200))
		   .body("_meta.message", equalTo("OK. Everything worked as expected."))
		   .body("result.email", equalTo(email));
	    
	}

	@Then("get request to the user should return updated information")
	public void get_request_to_the_user_should_return_updated_information() {
		Response resp_get = given().relaxedHTTPSValidation()
				.baseUri(server)
				.auth().oauth2(accessToken)
				.when()
				.get("/public-api/users/" + testContext.newUserID);
		testContext.scn.write("get reponse after put: " + resp_get.asString());
		
		resp_get.then()
				.assertThat()
				.statusCode(200)
				.body("_meta.success", equalTo(true))
				.body("_meta.code", equalTo(200))
				.body("_meta.message",equalTo("OK. Everything worked as expected."))
				.body("result", not(emptyArray()))
				.body("result.email", equalTo(email));		  
	}

	@When("I hit the api with put request and setting wrong email")
	public void i_hit_the_api_with_put_request_and_setting_wrong_email() {
	   
		 String Body="{\r\n" + 
		 		"	\"gender\":\"32424\",\r\n" + 
		 		"	\"email\":\"23442443\"\r\n" + 
		 		"}";
				  
		 testContext.scn.write("Body sent as: "+Body);
				   
				   HashMap<String,String> hm_header=new HashMap<String,String>();
				   hm_header.put("Content-Type", "application/json");
				  
				   testContext.req_spe.headers(hm_header).body(Body);
				   
				   testContext.scn.write("End Point given as: "+"/public-api/users/"+testContext.newUserID);
				   testContext.resp=testContext.req_spe.put("/public-api/users/"+testContext.newUserID);
				   testContext.scn.write("Response recieved after Put Req: "+testContext.resp.asString());

	}

	@Then("API returned the error code as {int}")
	public void api_returned_the_error_code_as(Integer code) {
		testContext.resp.then().assertThat().body("_meta.code", equalTo(code));
	}

	@Then("error message displayed as {string}")
	public void error_message_displayed_as(String msg) {
	    String Body_as=testContext.resp.asString();
	    Assert.assertTrue("Validation failed.Error msg not found.", Body_as.contains(msg));
	}

	@When("I hit the api with put request to update the incorrect user")
	public void i_hit_the_api_with_put_request_to_update_the_incorrect_user() {
		
		String Body="{\r\n" + 
		 		"	\"gender\":\"female\",\r\n" + 
		 		"	\"email\":\""+email+"\"\r\n" + 
		 		"}";
				  
		testContext.scn.write("Body sent as: "+Body);
				   
				   HashMap<String,String> hm_header=new HashMap<String,String>();
				   hm_header.put("Content-Type", "application/json");
				  
				   testContext.req_spe.headers(hm_header).body(Body);
				   
				   testContext.scn.write("End Point given as: "+"/public-api/users/"+234576878);
				   testContext.resp=testContext.req_spe.put("/public-api/users/"+234576878);
				   testContext.scn.write("Response recieved after Put Req: "+testContext.resp.asString());  
	}


	
}
