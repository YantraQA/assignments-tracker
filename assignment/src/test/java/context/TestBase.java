package context;

import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TestBase {

	 protected String server=LoadProp().getProperty("url");
	 protected String accessToken=LoadProp().getProperty("Token");
	 protected String server_UI=LoadProp().getProperty("url_ui");	
	 
		public Properties LoadProp()
		{
			try {
			InputStream inputstream=getClass().getClassLoader().getResourceAsStream("config.properties");
			Properties prop=new Properties();
			prop.load(inputstream);
			return prop;
			}catch(Exception e)
			{
				System.out.println("File not found exception thrwon for the config.properties"+e);
				return null;
			}
			
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
