package stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page_object.SigninPO;

public class SignInStrepDefs {
	WebDriver driver=null;
	SigninPO SigninPO=null;

	
	@Given("open the Browser and send url")
	public void open_the_Browser_and_send_url() {
	driver =new ChromeDriver();  
	driver.get("https://www.amazon.com/");
	}

	@When("I over on signBlock & I Click on sign In")
	public void i_over_on_signBlock_I_Click_on_sign_In() {
	   SigninPO spo=new SigninPO(driver);
	   spo.MouseAction();
	   spo.SignInClick();
	}

	@When("I Enter email and click on continue")
	public void i_Enter_email_and_click_on_continue() {
		SigninPO spo=new SigninPO(driver);
	spo.enter_email();
	spo.click_email();
	}
	@Then("I also Enter Password then on signin")
	public void i_also_Enter_Password_then_on_signin() {
	SigninPO spo=new SigninPO(driver);
	spo.enter_pass();
	spo.click_pass();
	
	}
}