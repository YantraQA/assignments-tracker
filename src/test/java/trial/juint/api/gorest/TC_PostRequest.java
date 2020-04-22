package trial.juint.api.gorest;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import utils.ui.Ineract;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

import org.junit.Test;


public class TC_PostRequest extends Ineract{

	String server = LoadProperties().getProperty("url");
	String accessToken = LoadProperties().getProperty("token");
	
	@Test
	public void tc_01_post_positive_create_user() {
		
		
		//Get Random String for Email
		String email = GetRandomString(10)  + "@gmail.com";
		
		//Set Header
		HashMap<String, String> hm_header = new HashMap<String, String>();
		hm_header.put("Content-Type", "application/json");
		
		System.out.println("Header " + hm_header.toString());
		
		//Set Body
		String body_string = "{\r\n" + 
				"	\"gender\":\"female\",\r\n" + 
				"	\"last_name\":\"lastnamevisionit\",\r\n" + 
				"	\"first_name\":\"firstnamevisionit\",\r\n" + 
				"	\"email\":\"" + email + "\"\r\n" + 
				"}";
		
		System.out.println("Body Text sent as: " + body_string);
		
		//POST and fetch response
		Response resp = given()
		.baseUri(server)
		.auth().oauth2(accessToken)
		.headers(hm_header)
		.body(body_string)
		.when()
		.post("/public-api/users")
		
		//System.out.println("Response for this POST Request is:" + resp.asString());
		
		.then()
		.statusCode(302)
		.assertThat()
		.body("_meta.code", equalTo(201))
		.body("_meta.success", equalTo(true))
		.body("_meta.message", equalTo("A resource was successfully created in response to a POST request. The Location header contains the URL pointing to the newly created resource."))
		.body("result.first_name",equalTo("firstnamevisionit"))
		.body("result.last_name",equalTo("lastnamevisionit"))
		.body("result.gender",equalTo("female"))
		.body("result.email",equalTo(email))
		.body("result.dob",equalTo(null))
		.body("result.status",equalTo(null))
		.body("result.phone",equalTo(null))
		.body("result.address",equalTo(null))
		.body("result.website",equalTo(null))
		.extract()
		.response();
		
		System.out.println("Response for this POST Request is:" + resp.asString());
		
		//fire a get & check POST has successfully created the data
		String id = resp.jsonPath().getString("result.id");
		Response resp_get = given()
				.baseUri(server)
				.auth().oauth2(accessToken)
				.when()
				.get("/public-api/users/" + id)
				.then()
				.assertThat()
				.statusCode(200)
				.body("_meta.success", equalTo(true))
				.body("_meta.code", equalTo(200))
				.body("_meta.message", equalTo("OK. Everything worked as expected."))
				.body("result.first_name",equalTo("firstnamevisionit"))
				.body("result.last_name",equalTo("lastnamevisionit"))
				.body("result.gender",equalTo("female"))
				.body("result.email",equalTo(email))
				.body("result.dob",equalTo(null))
				.body("result.status",equalTo(null))
				.body("result.phone",equalTo(null))
				.body("result.address",equalTo(null))
				.body("result.website",equalTo(null))
				.extract()
				.response();
							
		System.out.println("Response for the get Request: " + resp_get.asString());
	}	
	
			
//		String dynamic_fname = GetRandomString(8);
//		String dynamic_lname = GetRandomString(5);
//		String dynamic_email = GetRandomString(7);
//				
//		//Body Text
//		String body_text = "{\"gender\":\"female\",\"last_name\":\"" + dynamic_lname + "\",\"first_name\":\"" + dynamic_fname +"\",\"email\":\"" + dynamic_email + "@gmail.com\"}";
//		
//		System.out.println("Body Text sent as: " + body_text);
//		
//		//Header Hash Map
//		HashMap<String,String> hm_header = new HashMap<String,String>();
//		hm_header.put("Content-Type", "application/json");
//		
//		System.out.println("Header " + hm_header.toString());
//		
//		//Req Specification with Base URI and Header 
//		RequestSpecification req_spec = given().baseUri(server).auth().oauth2(accessToken).headers(hm_header);
//		
//		//Getting the response of Post, Note body is also sent in the Post request
//		Response response = req_spec.when().body(body_text).post("/public-api/users");
	
//		System.out.println("Response received after Post Request " + response.asString());
//		
//		ValidatableResponse valid_response = response.then();
//		
//		//Assertion 1
//		valid_response.assertThat().body("_meta.success", equalTo(true))
//		.body("_meta.code", equalTo(201))
//		.body("_meta.message", equalTo("A resource was successfully created in response to a POST request. The Location header contains the URL pointing to the newly created resource."))
//		.body("result.first_name",equalTo(dynamic_fname))
//		.body("result.last_name",equalTo(dynamic_lname))
//		.body("result.gender",equalTo("female"))
//		.body("result.email",equalTo(dynamic_email + "@gmail.com"));
//
//		
//		//Assertion 2 - Get Request using the ID generated in previous Step
//		int id = response.jsonPath().getInt("result.id");
//		//String salary = response.jsonPath().getString("data.salary");
//		//Map<String, String> hm_data = response.jsonPath().getMap("data");
//		
//		Response response_get = given().baseUri(server).when().get("/api/v1/employee/" + id);
//		//Response response_get = given().when().get("http://dummy.restapiexample.com/api/v1/employee/93");
//		System.out.println("Response received after Get Request: " + response_get.asString());
//		
//		response_get.then().
//		assertThat().body("_meta.code", equalTo(200))
//		.body("_meta.success", equalTo(true))
//		.body("_meta.message", equalTo("OK. Everything worked as expected."))
//		.body("result.first_name",equalTo(dynamic_fname))
//		.body("result.last_name",equalTo(dynamic_lname))
//		.body("result.gender",equalTo("female"))
//		.body("result.email",equalTo(dynamic_email));
//	}
	
	

}
