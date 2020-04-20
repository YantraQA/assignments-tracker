package stefDefs;
import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

	import cucumber.api.Scenario;
	import cucumber.api.java.Before;
	import cucumber.api.java.en.Given;
	import cucumber.api.java.en.Then;
	import cucumber.api.java.en.When;

	public class StefDefs
	{
		WebDriver driver;
		Scenario scn;// can access in many methods
		@Before
	    public void beforeMethodSetup(Scenario s) // scenario interface can be use to write the logs.
	    {   										 //fetch information of steps at run time.again introduced screenshots in reports{
		this.scn=s;
	    }

		@Given("when I open a {string} browser")
	    public void when_I_open_a_browser(String browser)
	    {
		
		if(browser.equalsIgnoreCase("chrome"))
		 {
			 driver= new ChromeDriver();
			 scn.write("Chrome driver is opened");
		 }else
		if(browser.equalsIgnoreCase("firefox"))
		 {
			driver= new FirefoxDriver();	
			scn.write("Firefox driver is opened");
		 }
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
	   
	}

	@Given("I navigate to URL {string}")
	public void i_navigate_to_URL(String url) 
	 	{
	       driver.get(url);
	 	}

	@When("I enter text {string} in search box")
	public void i_enter_text_in_search_box(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@When("I click on submit Button")
	public void i_click_on_submit_Button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("Page is navigate to search page")
	public void page_is_navigate_to_search_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}


	}
	
	
	
	


