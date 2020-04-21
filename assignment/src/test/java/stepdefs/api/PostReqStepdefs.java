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

public class PostReqStepdefs extends TestBase
{
    TestContext testContext;
	
	public PostReqStepdefs(TestContext testContext)
	{
		this.testContext=testContext;
	}
	
	String email=GetRandomString(7)+"@gmail.com";     //i.e. it will take 7 char
	
	@Given("I set Header and Body to create new user")
	public void i_set_Header_and_Body_to_create_new_user() {
		
		   
		   String Body="{\r\n" + 
		   		"	\"gender\":\"female\",\r\n" + 
		   		"	\"last_name\":\"Dhande\",\r\n" + 
		   		"	\"first_name\":\"Neha\",\r\n" + 
		   		"	\"email\":\""+email+"\"\r\n" + 
		   		"}";
		  
		   testContext.scn.write("Body sent as: "+Body);
		   
		   HashMap<String,String> hm_header=new HashMap<String,String>();
		   hm_header.put("Content-Type", "application/json");
		   
		   testContext.req_spe.headers(hm_header).body(Body);
		 
	}
	
	@Given("I set Header and pass empty body")
	public void i_set_Header_and_pass_empty_body() {
		
		HashMap<String,String> hm_header=new HashMap<String,String>();
		   hm_header.put("Content-Type", "application/json");
		   
		   testContext.req_spe.headers(hm_header);
		
	}
	
	@Given("I set Header and Body with empty fields")
	public void i_set_Header_and_Body_with_empty_fields() {
		
		   
		   String Body="{\r\n" + 
			   		"	\"last_name\":\"\",\r\n" + 
			   		"	\"first_name\":\"\",\r\n" + 
			   		"	\"email\":\"\",\r\n" + 
			   		"	\"gender\":\"\"\r\n" + 
			   		"}";
		   testContext.scn.write("Body sent as: "+Body);
		   
		   HashMap<String,String> hm_header=new HashMap<String,String>();
		   hm_header.put("Content-Type", "application/json");
		   
		   testContext.req_spe.headers(hm_header).body(Body);
		 
	}
	
	@Given("I set Header and Body with incorrect email and gender")
	public void i_set_Header_and_Body_with_incorect_email_and_gender() {
		
		   String Body="{\r\n" + 
			   		"	\"last_name\":\"temp\",\r\n" + 
			   		"	\"first_name\":\"temp1\",\r\n" + 
			   		"	\"email\":\"234234\",\r\n" + 
			   		"	\"gender\":\"2344424\"\r\n" + 
			   		"}";
		   testContext.scn.write("Body sent as: "+Body);
		   
		   HashMap<String,String> hm_header=new HashMap<String,String>();
		   hm_header.put("Content-Type", "application/json");
		   
		   testContext.req_spe.headers(hm_header).body(Body);
		 
	}
	
	@Given("I set Header and Body with all fields incorrect")
	public void i_set_Header_and_Body_with_all_fields_incorrect() {
		
		   String Body="{\r\n" + 
			   		"	\"last_name\":1234,\r\n" + 
			   		"	\"first_name\":true,\r\n" + 
			   		"	\"email\":34324,\r\n" + 
			   		"	\"gender\":2343242\r\n" + 
			   		"}";
		 
		   testContext.scn.write("Body sent as: "+Body);
		   
		   HashMap<String,String> hm_header=new HashMap<String,String>();
		   hm_header.put("Content-Type", "application/json");
		   
		   testContext.req_spe.headers(hm_header).body(Body);
		 
	}

	@When("I hit the api with post request and end point as {string}")
	public void i_hit_the_api_with_post_request_and_end_point_as(String endpoint) {
	    
		testContext.resp= testContext.req_spe.when().post(endpoint);
		testContext.scn.write("Response of the request is: "+testContext.resp.asString());
	}

	@Then("API created a new User in the system")
	public void api_created_a_new_User_in_the_system() {
		testContext.resp.then()
		   .assertThat()
		   .statusCode(302)
		   .body("_meta.success", equalTo(true))
		   .body("_meta.code", equalTo(201))
		   .body("_meta.message", equalTo("A resource was successfully created in response to a POST request. The Location header contains the URL pointing to the newly created resource."))
		   .body("result.first_name", equalTo("Neha"))
		   .body("result.last_name", equalTo("Dhande"))  
		   .body("result.gender", equalTo("female"))
		   .body("result.email", equalTo(email))
		   .body("result.dob", equalTo(null));
	}
	
	@Then("API returned the code as 422")
	public void api_returned_the_code_as_422() 
	{
		testContext.resp.then()
		   .assertThat()
		   .statusCode(200)
		   .body("_meta.success", equalTo(false))
		   .body("_meta.code", equalTo(422))
		   .body("_meta.message", equalTo("Data validation failed. Please check the response body for detailed error messages."));
		   
	}

	@Then("displayed error messages")
	public void displayed_error_messages() {
		testContext.resp.then()
		   .assertThat()
		   .body("result[0].field", equalTo("email"))
		   .body("result[0].message", equalTo("Email cannot be blank."))
		   .body("result[1].field", equalTo("first_name"))
		   .body("result[1].message", equalTo("First Name cannot be blank."))
		   .body("result[2].field", equalTo("last_name"))
		   .body("result[2].message", equalTo("Last Name cannot be blank."))
		   .body("result[3].field", equalTo("gender"))
		   .body("result[3].message", equalTo("Gender cannot be blank."));
	}
	
	@Then("displayed the error msg as {string}")
	public void displayed_the_error_msg_as(String s) {
		testContext.resp.then()
		   .assertThat()
		   .body("result[0].field", equalTo("email"))
		   .body("result[0].message", equalTo("Email is not a valid email address."))
		   .body("result[1].field", equalTo("gender"))
		   .body("result[1].message", equalTo("Gender is invalid."));
		   
	}
	
	@Then("displayed invalid datatype msgs")
	public void displayed_invalid_datatype_msgs() {
		testContext.resp.then()
		   .assertThat()
		   .body("result[0].field", equalTo("gender"))
		   .body("result[0].message", equalTo("Gender must be a string."))
		   .body("result[1].field", equalTo("email"))
		   .body("result[1].message", equalTo("Email is not a valid email address."))
		   .body("result[2].field", equalTo("first_name"))
		   .body("result[2].message", equalTo("First Name must be a string."))
		   .body("result[3].field", equalTo("last_name"))
		   .body("result[3].message", equalTo("Last Name must be a string."));
	}
		   
}
