package api.gorest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.junit.Test;

import context.TestBase;
import io.restassured.response.Response;
import junit.framework.Assert;

public class TC_GetRequest extends TestBase
{

	String server=LoadProp().getProperty("url");
	String accessToken=LoadProp().getProperty("Token");
	
	/*public void setup() throws IOException
	{
		InputStream inputstream=getClass().getClassLoader().getResourceAsStream("config.properties");
		Properties prop=new Properties();
		prop.load(inputstream);
	    server=prop.getProperty("url");
	    accessToken=prop.getProperty("Token");
		
	}*/
	
	@Test
	public void t_01_get_req_fetch_all_users()
	{
		Response resp=given()
				.relaxedHTTPSValidation()
				.baseUri(server)
				.auth().oauth2(accessToken)
				
				.when()
				.get("/public-api/users")
				
				.then()
				.assertThat()
				.statusCode(200)
				.body("_meta.success", equalTo(true))
				.body("_meta.code", equalTo(200))
				.body("_meta.message", equalTo("OK. Everything worked as expected."))
				.body("result", not(emptyArray()))
				.extract()
				.response();
		
		System.out.println("Response returned as:" + resp.asString());
		
		//org.hamcrest.Matchers     //to check which method can b used 4 validation
	}
	
	@Test
	public void t_02_Get_req_validate_pagination()
	{
		Response resp=given().relaxedHTTPSValidation()
				.baseUri(server)
				.queryParam("page", "5")
				.auth().oauth2(accessToken)
				.when()
				.get("/public-api/users")
				.then()
				.assertThat()
				.statusCode(200)
				.body("_meta.success", equalTo(true))
				.body("_meta.code", equalTo(200))
				.body("_meta.message", equalTo("OK. Everything worked as expected."))
				.body("_meta.currentPage", equalTo(5))
				.body("result", not(emptyArray()))
				.extract()
				.response();
		
		//System.out.println("Response returned as:" + resp.toString());  //toString() will return hashcode
		System.out.println("Response returned as:" + resp.asString());
		
	}
	
	@Test
	public void t_03_Get_req_single_user()
	{
		String user_id="447";
		Response resp=given().relaxedHTTPSValidation()
				.baseUri(server)
				.auth().oauth2(accessToken)
				.when()
				.get("/public-api/users/447")
				.then()
				.assertThat()
				.statusCode(200)
				.body("_meta.success", equalTo(true))
				.body("_meta.code", equalTo(200))
				.body("_meta.message", equalTo("OK. Everything worked as expected."))
				.body("result", not(emptyArray()))
				.body("result.id", equalTo(user_id))
				.extract()
				.response();
		
		
		System.out.println("Response returned as:" + resp.asString());
		
	}
	
	@Test
	public void t_04_Get_req_negative_incorrect_user()
	{
		String user_id="380434567890";
		Response resp=given().relaxedHTTPSValidation()
				.baseUri(server)
				.auth().oauth2(accessToken)
				.when()
				.get("/public-api/users"+user_id)
				.then()
				.assertThat()
				.statusCode(200)
				.body("_meta.success", equalTo(false))
				.body("_meta.code", equalTo(404))
				.body("_meta.message", equalTo("The requested resource does not exist."))
				.body("result.name", equalTo("Not Found"))
				.body("result.message", equalTo("Object not found: "+user_id))
				.body("result.code", equalTo(0))
				.body("result.status", equalTo(404))
				.extract()
				.response();
		
		
		System.out.println("Response returned as:" + resp.asString());
		
	}
	
	@Test
	public void t_05_Get_req_all_users_wd_gender_as_female()
	{
		
		Response resp=given().relaxedHTTPSValidation()
				.baseUri(server)
				.queryParam("gender", "female")
				.auth().oauth2(accessToken)
				.when()
				.get("/public-api/users")
				.then()
				.assertThat()
				.statusCode(200)
				.body("_meta.success", equalTo(true))
				.body("_meta.code", equalTo(200))
				.body("_meta.message", equalTo("OK. Everything worked as expected."))
				.body("result.gender", everyItem(equalTo("female")))
				.extract()
				.response();
		
		//Below is another way of doing the validation for
		//Line:.body("result.gender", everyItem(equalTo("female")))
		
		/*List<String> list_gender=resp.jsonPath().getList("result.gender");
		for(int i=0; i<list_gender.size(); i++)
		if(list_gender.get(i).equalsIgnoreCase("female"))
		{
			Assert.assertTrue("Validated", true);
		}else
		{
			Assert.assertTrue("female is not present in atleast one entry", false);
		}*/
			
		System.out.println(resp.jsonPath().getList("result.gender"));
		
		System.out.println("Response returned as:" + resp.asString());
		
	}
	
	@Test
	public void t_06_Get_req_all_users_wd_gender_as_female_and_status_as_active()
	{
		
		Response resp=given().relaxedHTTPSValidation()
				.baseUri(server)
				.queryParam("gender", "female")
				.queryParam("status", "active")
				.auth().oauth2(accessToken)
				.when()
				.get("/public-api/users")
				.then()
				.assertThat()
				.statusCode(200)
				.body("_meta.success", equalTo(true))
				.body("_meta.code", equalTo(200))
				.body("_meta.message", equalTo("OK. Everything worked as expected."))
				.body("result.gender", everyItem(equalTo("female")))
				.body("result.status", everyItem(equalTo("active")))
				.extract()
				.response();
		
		
			
		System.out.println(resp.jsonPath().getList("result.gender"));
		
		System.out.println("Response returned as:" + resp.asString());
		
	}
	
	
}
