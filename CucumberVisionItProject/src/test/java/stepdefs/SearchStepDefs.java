package stepdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page_object.SearchPO;

public class SearchStepDefs {
	WebDriver driver=null;
	String url="https://www.amazon.com/";
	SearchPO SearchPO=null;
	Scenario scn;
	@Before
	public void set_up(Scenario S)
	{
		this.scn = S;
	}
	@After
	public void clean_up()
	{
		TakesScreenshot Scnshot=(TakesScreenshot)driver;
		byte [] data =Scnshot.getScreenshotAs(OutputType.BYTES);
		scn.embed(data, "image/png");	
		
	driver.quit();
	scn.write("Browser close");
	
	}
	@Given("I open browser")
	public void i_open_browser() {
	   driver=new ChromeDriver();
	   driver.get(url);
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   scn.write("navigated to url");}
   
	@When("Send key {string}")
	public void send_key(String string) {
		SearchPO Spo=new SearchPO(driver, scn);
	Spo.SendkeysBox(string);
	Spo.iconclick();
	}

	@Then("I get List of {string}")
	public void i_get_List_of(String string3) {
		SearchPO Spo=new SearchPO(driver, scn);
	  Spo.Check_ProductList(string3);
	  scn.write("sucessful");
	
	}

}