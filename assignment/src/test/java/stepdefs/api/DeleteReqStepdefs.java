package stepdefs.api;


import context.TestBase;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import utils.api.CmnApiMethods;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;


public class DeleteReqStepdefs extends TestBase
{
	
    TestContext testContext;
	
	public DeleteReqStepdefs(TestContext testContext)
	{
		this.testContext=testContext;
	}
	
	 // String newUserID=null;
		String email=GetRandomString(7)+"@gmail.com"; 

	@When("I hit the api with delete request")
	public void i_hit_the_api_with_delete_request() {
		testContext.resp=testContext.req_spe.when().delete("public-api/users/"+testContext.newUserID);
		testContext.scn.write("Response recieved after delete Req: "+testContext.resp.asString());
	}

	@Then("API should delete the user")
	public void api_should_delete_the_user() {
		testContext.resp.then()
	   .assertThat()
	   .body("_meta.success", equalTo(true))
	   .body("_meta.code", equalTo(204))
	   .body("_meta.message", equalTo("The request was handled successfully and the response contains no body content."))
	   .body("result", equalTo(null));
	   
	}

	@Then("get request to the user should not return the user")
	public void get_request_to_the_user_should_not_return_the_user() {
		
		Response resp_get=given().relaxedHTTPSValidation()
				.baseUri(server)
				.auth().oauth2(accessToken)
				.when()
				.get("/public-api/users/" + testContext.newUserID);
		testContext.scn.write("get reponse after delete: " + resp_get.asString());
		
		resp_get.then()
				.assertThat()
				.body("_meta.success", equalTo(false))
				.body("_meta.code", equalTo(404))
				.body("_meta.message",equalTo("The requested resource does not exist."))
				.body("result.name", equalTo("Not Found"))
				.body("result.message", equalTo("Object not found: " + testContext.newUserID));
	}


	
}
