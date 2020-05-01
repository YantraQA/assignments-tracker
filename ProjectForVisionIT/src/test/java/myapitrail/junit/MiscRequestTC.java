package myapitrail.junit;

import org.junit.Test;

import contexts.Testbase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import io.restassured.response.Response;


public class MiscRequestTC extends Testbase
{
	String server = LoadProperties().getProperty("url");
	String accessToken = LoadProperties().getProperty("token");
	@Test
	public void t_01_Option_CheckAllTheAllowedVerbs()
	{
		Response resp=given().relaxedHTTPSValidation()
				.baseUri(server)
				.auth().oauth2(accessToken)
				.when()
				.options("public-api/users")
				.then()
				.assertThat()
				.statusCode(200)
				.body("_meta.success", equalTo(true))
				.body("_meta.code", equalTo(200))
				.body("_meta.message", equalTo("OK. Everything worked as expected."))
				.body("_meta.allow",equalTo("GET, POST, HEAD, OPTIONS"))
				.extract()
				.response();
		System.out.println("Response returend as:" + resp.asString());
		
	}
	@Test
	public void t_02_Delete_The_User()
	{
		Response resp=given().relaxedHTTPSValidation()
				.baseUri(server)
				.auth().oauth2(accessToken)
				.when()
				.delete("public-api/users/336")
				.then()
				.assertThat()
				.statusCode(200)
				.body("_meta.success", equalTo(true))
				.body("_meta.code", equalTo(204))
				.body("_meta.message", equalTo("The request was handled successfully and the response contains no body content."))
				.extract()
				.response();
		System.out.println("Response retruned as:" +resp.asString());
				
	}
}
