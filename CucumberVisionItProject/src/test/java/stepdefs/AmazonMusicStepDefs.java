package stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AmazonMusicStepDefs {
	WebDriver driver=null;
	String url="https://www.facebook.com/";
	@Given("I open fb page")
	public void i_open_fb_page() {
		driver=new ChromeDriver();
		driver.get(url);
	}
	@When("I enter email idpriti")
	public void i_enter_email_idpriti() {
	    
	}

	@Then("I en password {int} & click on login")
	public void i_en_password_click_on_login(Integer int1) {
	    
	}
}
