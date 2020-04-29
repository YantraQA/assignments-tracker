package stepdefs.api;

import java.util.HashMap;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import utils.api.Testbase;


public class PatchReuestStepDefs extends Testbase
{
	TestContextAPI tesContext;
	public PatchReuestStepDefs(TestContextAPI testContext)
	{
		this.tesContext = testContext;
	}
		
		String email=GetRandomString(10)+ "@gmail.com"; 
		
		/*@Before 
		public void SetUp(Scenario s)
		{
			this.scn =s;
		}*/
		@When("I hit the api with patch request to update the existing user details")
		public void i_hit_the_api_with_patch_request_to_update_the_existing_user_details()
		{
			HashMap<String,String> hm_header = new HashMap<String,String>();
			hm_header.put("Content-Type", "application/json");
			
			String body_string ="{\n" +
								"  \"email\":\""+email +"\"\n" +
								"}";
			tesContext.scn.write("body sent as:" + body_string);
			tesContext.req_spec.headers(hm_header).body(body_string);
			tesContext.scn.write("End Point:" + "/public-api/users/" + email);
			tesContext.resp=tesContext.req_spec.when().relaxedHTTPSValidation().put("/public-api/users/" + tesContext.newUserID);
			tesContext.scn.write("Response Patch Request:" + tesContext.resp.asString());
			
			
			
		}
}
