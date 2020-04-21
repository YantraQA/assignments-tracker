package api.gorest;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import java.util.HashMap;
import java.util.Random;

import org.junit.Test;

import context.TestBase;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;


public class TC_PostRequest extends TestBase
{
   	   String server="https://gorest.co.in/";
	   String accessToken="nX0nqxDcaL6N-Ay6wR8Fpie28R5l43UlfXu_";
	   
	   @Test
	   public void t_01_post_req_create_new_user()
	   {
		   String email=GetRandomString(7)+"@gmail.com";     //i.e. it will take 7 char
		   
		   //Body
		   String Body="{\r\n" + 
		   		"	\"gender\":\"female\",\r\n" + 
		   		"	\"last_name\":\"Dhande\",\r\n" + 
		   		"	\"first_name\":\"Neha\",\r\n" + 
		   		"	\"email\":\""+email+"\"\r\n" + 
		   		"}";
		   
		   //Header
		   HashMap<String,String> hm_header=new HashMap<String,String>();
		   hm_header.put("Content-Type", "application/json");
		 
		   //to check the error we ll check what it is returning
		   /*String a= given().relaxedHTTPSValidation()
					.baseUri(server)
				   .auth().oauth2(accessToken)
				   .headers(hm_header)
				   .body(Body)
				   .when()
				   .post("/public-api/users").asString();
		
		   System.out.println(a);
		
	   }		   */              
		   
		   
		 //post and fetch response
		Response resp= given().relaxedHTTPSValidation()
			.baseUri(server)
		   .auth().oauth2(accessToken)
		   .headers(hm_header)
		   .body(Body)
		   .when()
		   .post("/public-api/users");
		
		System.out.println("Response recieved after Post req "+resp.asString());
		   
		   resp.then()
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
		  
		
		//System.out.println("Response recieved after Post req "+resp.asString());
		   
		  
	  //fire the get req and check post has successfully created the data
		   String id=resp.jsonPath().getString("result.id");
			Response resp_get=given().relaxedHTTPSValidation()
					.baseUri(server)
					.auth().oauth2(accessToken)
					.when()
					.get("/public-api/users"+id)
					.then()
					.assertThat()
					.statusCode(200)
					.body("_meta.success", equalTo(true))
					.body("_meta.code", equalTo(200))
					.body("_meta.message", equalTo("OK. Everything worked as expected."))
					.body("result", not(emptyArray()))
					.body("result.first_name", equalTo("Neha"))
					.body("result.last_name", equalTo("Dhande"))  
					.body("result.gender", equalTo("female"))
					.body("result.email", equalTo(email))
					.body("result.dob", equalTo(null))
					.extract()
					.response();
		
			System.out.println("Response recieved after get req "+resp_get.asString());
	   }
		
	   @Test
	   public void t_02_post_req_negative_send_empty_body()
	   {
           String email=GetRandomString(7)+"@gmail.com";     //i.e. it will take 7 char
		    
		   //Header
		   HashMap<String,String> hm_header=new HashMap<String,String>();
		   hm_header.put("Content-Type", "application/json");
		   
		   
		 
			 //post and fetch response
			Response resp= given().relaxedHTTPSValidation()
				.baseUri(server)
			   .auth().oauth2(accessToken)
			   .headers(hm_header)
			   .when()
			   .post("/public-api/users");
			
			System.out.println("Response recieved after Post req "+resp.asString());
			   
			   resp.then()
			   .assertThat()
			   .statusCode(200)
			   .body("_meta.success", equalTo(false))
			   .body("_meta.code", equalTo(422))
			   .body("_meta.message", equalTo("Data validation failed. Please check the response body for detailed error messages."))
			   .body("result[0].field", equalTo("email"))
			   .body("result[0].message", equalTo("Email cannot be blank."))
			   .body("result[1].field", equalTo("first_name"))
			   .body("result[1].message", equalTo("First Name cannot be blank."))
			   .body("result[2].field", equalTo("last_name"))
			   .body("result[2].message", equalTo("Last Name cannot be blank."))
			   .body("result[3].field", equalTo("gender"))
			   .body("result[3].message", equalTo("Gender cannot be blank."));
			  
	   }	
	   
	   @Test
	   public void t_03_post_req_negative_send_body_with_empty_field()
	   {
           String email=GetRandomString(7)+"@gmail.com";     //i.e. it will take 7 char
		    
		   //Header
		   HashMap<String,String> hm_header=new HashMap<String,String>();
		   hm_header.put("Content-Type", "application/json");
		   
		   //Body
		   String Body="{\r\n" + 
		   		"	\"last_name\":\"\",\r\n" + 
		   		"	\"first_name\":\"\",\r\n" + 
		   		"	\"email\":\"\",\r\n" + 
		   		"	\"gender\":\"\"\r\n" + 
		   		"}";
		 
			 //post and fetch response
			Response resp= given().relaxedHTTPSValidation()
				.baseUri(server)
			   .auth().oauth2(accessToken)
			   .headers(hm_header)
			   .body(Body)
			   .when()
			   .post("/public-api/users");
			
			System.out.println("Response recieved after Post req "+resp.asString());
			   
			   resp.then()
			   .assertThat()
			   .statusCode(200)
			   .body("_meta.success", equalTo(false))
			   .body("_meta.code", equalTo(422))
			   .body("_meta.message", equalTo("Data validation failed. Please check the response body for detailed error messages."))
			   .body("result[0].field", equalTo("email"))
			   .body("result[0].message", equalTo("Email cannot be blank."))
			   .body("result[1].field", equalTo("first_name"))
			   .body("result[1].message", equalTo("First Name cannot be blank."))
			   .body("result[2].field", equalTo("last_name"))
			   .body("result[2].message", equalTo("Last Name cannot be blank."))
			   .body("result[3].field", equalTo("gender"))
			   .body("result[3].message", equalTo("Gender cannot be blank."));
			  
	   }	
	   
	   @Test
	   public void t_04_post_req_negative_body_with_incorrect_values()
	   {
           String email=GetRandomString(7)+"@gmail.com";     //i.e. it will take 7 char
		    
		   //Header
		   HashMap<String,String> hm_header=new HashMap<String,String>();
		   hm_header.put("Content-Type", "application/json");
		   
		   //Body
		   String Body="{\r\n" + 
		   		"	\"last_name\":\"temp\",\r\n" + 
		   		"	\"first_name\":\"temp1\",\r\n" + 
		   		"	\"email\":\"234234\",\r\n" + 
		   		"	\"gender\":\"2344424\"\r\n" + 
		   		"}";
		 
			 //post and fetch response
			Response resp= given().relaxedHTTPSValidation()
				.baseUri(server)
			   .auth().oauth2(accessToken)
			   .headers(hm_header)
			   .body(Body)
			   .when()
			   .post("/public-api/users");
			
			System.out.println("Response recieved after Post req "+resp.asString());
			   
			   resp.then()
			   .assertThat()
			   .statusCode(200)
			   .body("_meta.success", equalTo(false))
			   .body("_meta.code", equalTo(422))
			   .body("_meta.message", equalTo("Data validation failed. Please check the response body for detailed error messages."))
			   .body("result[0].field", equalTo("email"))
			   .body("result[0].message", equalTo("Email is not a valid email address."))
			   .body("result[1].field", equalTo("gender"))
			   .body("result[1].message", equalTo("Gender is invalid."));
			  
	   }	
	   
	   @Test
	   public void t_05_post_req_negative_body_with_all_incorrect_datatype()
	   {
           String email=GetRandomString(7)+"@gmail.com";     //i.e. it will take 7 char
		    
		   //Header
		   HashMap<String,String> hm_header=new HashMap<String,String>();
		   hm_header.put("Content-Type", "application/json");
		   
		   //Body
		   String Body="{\r\n" + 
		   		"	\"last_name\":1234,\r\n" + 
		   		"	\"first_name\":true,\r\n" + 
		   		"	\"email\":34324,\r\n" + 
		   		"	\"gender\":2343242\r\n" + 
		   		"}";
		 
			 //post and fetch response
			Response resp= given().relaxedHTTPSValidation()
				.baseUri(server)
			   .auth().oauth2(accessToken)
			   .headers(hm_header)
			   .body(Body)
			   .when()
			   .post("/public-api/users");
			
			System.out.println("Response recieved after Post req "+resp.asString());
			   
			   resp.then()
			   .assertThat()
			   .statusCode(200)
			   .body("_meta.success", equalTo(false))
			   .body("_meta.code", equalTo(422))
			   .body("_meta.message", equalTo("Data validation failed. Please check the response body for detailed error messages."))
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
