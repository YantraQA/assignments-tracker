package trial.junit;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
public class APITestCase
{

	String server_name="http://dummy.restapiexample.com/";
	
	@Test
	public void t_01_get_request()
	{
		given().baseUri("http://dummy.restapiexample.com/")
		.when().get("/api/v1/employees")
		.then()
		.assertThat().statusCode(200)
		.assertThat().body("status",equalTo("success"))
		.assertThat().body("data[0].id",equalTo("1"))
		.assertThat().body("data[0].employee_name",equalTo("Tiger Nixon"))
		.assertThat().body("data[2].id", equalTo("3"));
	}
	
	@Test
	public void t_02_get_request_breaking_steps()
	{
		RequestSpecification req_spec=given().baseUri(server_name);
		Response response=req_spec.when().get("/api/v1/employees");
		ValidatableResponse valid_response=response.then();
		
		valid_response.assertThat().statusCode(200)
		.assertThat().body("status",equalTo("success"))
		.assertThat().body("data[0].id",equalTo("1"))
		.assertThat().body("data[0].employee_name",equalTo("Tiger Nixon"))
		.assertThat().body("data[2].id", equalTo("3"));
	}
	
	@Test
	public void t_03_get_request_get_single_employee_detail()
	{
		RequestSpecification req_spec=given().baseUri(server_name);
		Response response=req_spec.when().get("/api/v1/employee/1");
		ValidatableResponse valid_response=response.then();
		
		valid_response.assertThat().statusCode(200)
		.assertThat().body("status",equalTo("success"))
		.assertThat().body("data[0].id",equalTo("1"))
		.assertThat().body("data[0].employee_name",equalTo("Tiger Nixon"));
		
	}
	
	@Test
	public void t_04_get_request_incorrect_employee_detail()
	{
		RequestSpecification req_spec=given().baseUri(server_name);
		Response response=req_spec.when().get("/api/v1/employee/23456776897734456");
		ValidatableResponse valid_response=response.then();
		
		//To b validated.Need to check status code and Json msg
		//wd text as Data Not Found.
		Assert.assertTrue("validation yet tob written, untill then marked as fail", false);
		/*valid_response.assertThat().statusCode(200)
		.assertThat().body("status",equalTo("success"))
		.assertThat().body("data[0].id",equalTo("1"))
		.assertThat().body("data[0].employee_name",equalTo("Tiger Nixon"));
		*/
	}
	
	@Test
	public void t_05_post_positive_create_new_employee()
	{
		String dynamic_name=GetRandomString(8);   //in API we can't hav same name 
		
		//Body Text
		String body_txt="{\"name\":\"" + dynamic_name + "\",\"salary\":\"123\",\"age\":\"23\"}"; 
		
		System.out.println("Body Text sent as: "+ body_txt);
		
		//Header HashMap
		HashMap<String,String> hm_header =new HashMap<String,String>();
		hm_header.put("Content-Type", "application/x-www-form-urlencoded");
		
		System.out.println("Header"+ hm_header.toString());
		
		//Request Specification wd Base URI and Master
		RequestSpecification req_spec=given().baseUri(server_name).headers(hm_header);
		
		//Getting the response of Post, Note Body is also sent in the Post request
		Response response=req_spec.when().body(body_txt).post("/api/v1/create");
		System.out.println("Response recieved after Post req"+ response.asString());
		
		ValidatableResponse valid_response=response.then();
		
		//Assertion 1
		valid_response.assertThat().body("status",equalTo("success"))
		.assertThat().body("data.name",equalTo(dynamic_name))
		.assertThat().body("data.salary",equalTo("123"))
		.assertThat().body("data.age",equalTo("23"));
		
		
		//Assertion 2:Get Req using the id generated in the previous step
		int id=response.jsonPath().getInt("data.id");
		//String salary=response.jsonPath().getString("data.salary");
		
		//if want to fetch all the data inside the object which is present in key value pair
		//Map<String, String> hm_data=response.jsonPath().getMap("data");
		
		Response response_get=given().baseUri("http://dummy.restapiexample.com").when().get("/api/v1/employee/"+id);
		//Response response_get = given().when().get("http://dummy.restapiexample.com/api/v1/employee/34");
		System.out.println("Response recieved after Get req"+ response_get.asString());
		
		response_get.then()
		.assertThat().statusCode(200)
		.assertThat().body("status",equalTo("success"))
		.assertThat().body("data.id",equalTo(id))
		.assertThat().body("data.employee_name",equalTo(dynamic_name))  //here we r not using array[] 
		.assertThat().body("data.employee_salary",equalTo("123")) //as get req is returning only one obj
		.assertThat().body("data.employee_age",equalTo("23"));    //Not the list of obj
					
	}
	
	@Test
	public void t_06_Post_negative_send_incorrect_name()
	{
		String dynamic_name="-234567";
		
		//Send Body
		String body_txt="{\"name\":\"" + dynamic_name + "\",\"salary\":\"123\",\"age\":\"23\"}";
		
		System.out.println("Body "+body_txt);
		
		//Header
		HashMap<String,String> hm_header=new HashMap<String,String>();
		hm_header.put("Content-Type", "application/x-www-form-urlencoded");
		
		System.out.println("Header "+hm_header.toString());
		
		//Req Specification with Base URI and Header
		RequestSpecification  req_spec=given().baseUri(server_name).headers(hm_header);
		
		//Getting the response of Post, Note body is also sent in the Post request
		Response response=req_spec.when().body(body_txt).post("api/v1/create");
		System.out.println("Response after Post req "+response.asString());
		
		ValidatableResponse valid_response=response.then();
		
		//Assertion-1
		//valid_response.assertThat().body("status", not(equalTo("success")));
		valid_response.assertThat().body("status",equalTo("success"))
		.assertThat().body("data.name", equalTo(dynamic_name));
		
		//Assertion 2-Get Request using the ID generated in previous Step
		int id=response.jsonPath().getInt("data.id");
		
		Response response_get=given().baseUri(server_name).when().get("api/v1/employee/"+id);
		System.out.println("Response obtained after get req "+response_get.asString());
		
		response_get.then()
		.assertThat().statusCode(200)
		.assertThat().body("status", equalTo("success"))
		.assertThat().body("data.id", equalTo(id))
		.assertThat().body("data.employee_name", equalTo(dynamic_name));
		
		
		
	}
	
	@Test
	public void t_07_Post_negative_send_incorrect_negative_salary()
	{
        String dynamic_name=GetRandomString(8);   //in API we can't hav same name 
		
		//Body Text
		String body_txt="{\"name\":\"" + dynamic_name + "\",\"salary\":\"-asdf\",\"age\":\"23\"}"; 
		
		System.out.println("Body Text sent as: "+ body_txt);
		
		//Header HashMap
		HashMap<String,String> hm_header =new HashMap<String,String>();
		hm_header.put("Content-Type", "application/x-www-form-urlencoded");
		
		System.out.println("Header"+ hm_header.toString());
		
		//Request Specification wd Base URI and Master
		RequestSpecification req_spec=given().baseUri(server_name).headers(hm_header);
		
		//Getting the response of Post, Note Body is also sent in the Post request
		Response response=req_spec.when().body(body_txt).post("/api/v1/create");
		System.out.println("Response recieved after Post req"+ response.asString());
		
		ValidatableResponse valid_response=response.then();
		
		//Assertion 1
		valid_response.assertThat().body("status",equalTo("success"))
		.assertThat().body("data.name",equalTo(dynamic_name))
		.assertThat().body("data.salary",equalTo("-asdf"));
		
	}
	
	public void t_08_Post_negative_send_incorrect_negative_age()
	{
		
	}
	
	public void t_09_Post_negative_send_special_characters()
	{
		
	}
	
	
	//To get random Key
		public String GetRandomString(int n) {
			// lower limit for LowerCase Letters 
			int lowerLimit = 97; 

			// lower limit for LowerCase Letters 
			int upperLimit = 122; 

			Random random = new Random(); 

			// Create a StringBuffer to store the result 
			StringBuffer r = new StringBuffer(n); 

			for (int i = 0; i < n; i++) { 

				// take a random value between 97 and 122 
				int nextRandomChar = lowerLimit 
						+ (int)(random.nextFloat() 
								* (upperLimit - lowerLimit + 1)); 

				// append a character at the end of bs 
				r.append((char)nextRandomChar); 
			} 

			// return the resultant string 
			return r.toString(); 
		} 
	
}
