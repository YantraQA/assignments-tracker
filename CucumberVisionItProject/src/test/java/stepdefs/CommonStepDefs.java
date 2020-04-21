package stepdefs;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page_object.CommonPO;

public class CommonStepDefs {
	CommonPO CommonPO=null;
	WebDriver driver=null;
	Scenario scn;
	String url="https://www.amazon.com/";
	
	@Given("open the Browser and nevigated to url")
	public void open_the_Browser_and_nevigated_to_url() {
	    driver=new ChromeDriver();
	    driver.get(url);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@When("I enter product {string}")
	public void i_enter_product(String products)
	{	
		CommonPO cpo= new CommonPO(driver,scn);
		cpo.SendkeysBox(products);
		scn.write("pass");
		cpo.iconclick();
		/*WebElement pro=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	    pro.sendKeys(products);
	   
	   WebElement icon=driver.findElement(By.xpath("//input[@type='submit']"));
	   icon.click();*/
	}
	@Then("product get appear {string}")
	public void product_get_appear(String ProductName) {
	WebElement Search=driver.findElement(By.xpath("//div[@class='a-section a-spacing-medium']"));
	//Search.click();
	String dep=Search.getText();
	if(dep.contains(ProductName))	
	{
	Assert.assertTrue(true);
	}
	else
	{
		Assert.assertFalse("incorrect",true);
	}
	}
}
