package utils.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import java.util.HashMap;

import context.TestBase;
import io.restassured.response.Response;

public class CmnApiMethods extends TestBase{

	public String CreateNewUsersInGoRestApi()
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
		  
		   String id=resp.jsonPath().getString("result.id");
			return id;
	   }
	
}



