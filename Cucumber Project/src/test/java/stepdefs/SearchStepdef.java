package stepdefs;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import singletonandchromemanager.ChromeDriverManager;
import util.Di;

public class SearchStepdef {
	
	Di Di;
	public  SearchStepdef(Di di) {
		this.Di=di;
	}
	Scenario scn;
	//SearchPO SearchPO =null;
    //WebDriver driver=null;
	String url="https://www.amazon.com/";
	
	@Given("I open browser")
	public void i_open_browser() {
		//from chromedriverManager class
		WebDriver driver=ChromeDriverManager.getDriver("chrome");
	     //	WebDriver  driver=new ChromeDriver();
		    driver.get(url);
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		   // Di.setDriver(driver);
		    Di.intializePageObject(driver, scn);}
	
	@When("Send key {string}")
	public void send_key(String Product) {
		Di.getSearchPO().SendkeysBox(Product);
		Di.getSearchPO().iconclick();
		//SearchPO spo=new SearchPO(driver, scn);
		//spo.SendkeysBox(Product);
		//scn.write("pass");
		//spo.iconclick();
	}

	@Then("I get List of {string}")
	public void i_get_List_of(String ProductName) {
		//Di.getSearchPO().ValidatePro(ProductName);
		
		Di.getSearchPO().ValidateProductList(ProductName);

	}
	/*
	@Before
	public void Setup(Scenario S) {
		this.scn=S;
	}
		
	@After
	public void EndUp() {
		TakesScreenshot scrnshot=(TakesScreenshot)Di.getDriver();
		byte[] data1=scrnshot.getScreenshotAs(OutputType.BYTES);
		scn.embed(data1,"image/png1");
	Di.getDriver().quit();	
	}*/
	}