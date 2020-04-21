package stepdefs.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import java.util.HashMap;

import context.TestBase;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import utils.api.CmnApiMethods;

public class PatchReqStepdefs extends TestBase
{
    TestContext testContext;
	
	public PatchReqStepdefs(TestContext testContext)
	{
		this.testContext=testContext;
	}
	
	 //String newUserID=null;	
		String email=GetRandomString(7)+"@gmail.com"; 
		
		@When("I hit the api with patch request to update the existing user details")
		public void i_hit_the_api_with_patch_request_to_update_the_existing_user_details() {
		    
			 String Body="{\r\n" + 
			 		"\r\n" + 
			 		"	\"email\":\""+email+"\"\r\n" + 
			 		"}";
				  
			       testContext.scn.write("Body sent as: "+Body);
				   
				   HashMap<String,String> hm_header=new HashMap<String,String>();
				   hm_header.put("Content-Type", "application/json");
				  
				   testContext.req_spe.headers(hm_header).body(Body);
				   
				   testContext.scn.write("End Point given as: "+"/public-api/users/"+testContext.newUserID);
				   testContext.resp=testContext.req_spe.patch("/public-api/users/"+testContext.newUserID);
				   testContext.scn.write("Response recieved after Patch Req: "+testContext.resp.asString());

		}
		
		
}
