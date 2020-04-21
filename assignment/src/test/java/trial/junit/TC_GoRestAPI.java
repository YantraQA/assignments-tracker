package trial.junit;

import org.junit.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class TC_GoRestAPI 
{
    String server="https://gorest.co.in/";
	String accessToken="nX0nqxDcaL6N-Ay6wR8Fpie28R5l43UlfXu_";
    
	@Test
	public void t_01_get_req()
	{
		Response resp=given().relaxedHTTPSValidation()
				.baseUri(server)
				.auth().oauth2(accessToken)
				.when()
				.get("/public-api/users")
				.then()
				.assertThat().statusCode(200)
				.assertThat().body("_meta.success", equalTo(true))
				.assertThat().body("_meta.code", equalTo(200))
				.assertThat().body("_meta.message", equalTo("OK. Everything worked as expected."))
				.extract()
				.response();
		
		System.out.println(resp.asString());
		
		
	}
	
	@Test
	public void t_02_Negative_get_req_invalid_token()
	{
		Response resp=given().relaxedHTTPSValidation()
				.baseUri(server)
				.auth().oauth2("invalidTokenesrdtfg")
				.when()
				.get("/public-api/users")
				.then()
				.assertThat()
				.body("_meta.success", equalTo(false))
				.body("_meta.code", equalTo(401))
				.body("_meta.message", equalTo("Authentication failed."))
				.body("result.name", equalTo("Unauthorized"))
				.body("result.message", equalTo("Your request was made with invalid credentials."))
				.extract()
				.response();
		
		System.out.println(resp.asString());
		//nX0nqxDcaL6N-Ay6wR8Fpie28R5l43UlfXu_
		
	}
	
}
