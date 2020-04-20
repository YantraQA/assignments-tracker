package stepdefs.api;

import java.util.HashMap;

import context.TestBase;
import cucumber.api.java.en.When;

public class PatchRequestStepdefs extends TestBase {
	TestContext testContext;
	
	public PatchRequestStepdefs(TestContext testContext) {
		this.testContext = testContext;
		
	}
	
	String email = GetRandomString(10) + "@gmail.com";
	
	
	@When("I hit the api with patch request to update the existing user details")
	public void i_hit_the_api_with_patch_request_to_update_the_existing_user_details() {
		HashMap<String, String> hm_header =new HashMap<String, String>();
		hm_header.put("Content-Type", "application/json");
		
		String body_string = "{\n" + 
				"	\"email\":\""+ email +"\"\n" + 
				"}";
		
		testContext.scn.write("body sent as:" + body_string);
		testContext.req_spec.headers(hm_header).body(body_string);
		
		
		testContext.scn.write("End Point:" + "/public-api/users/" +testContext.newUserID);
		testContext.resp = testContext.req_spec.when().put("/public-api/users/" + testContext.newUserID);
			
	
	}
	
}
