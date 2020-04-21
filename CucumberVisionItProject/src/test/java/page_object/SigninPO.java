package page_object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SigninPO {
	WebDriver driver;
	private By mouse_Over=By.id("nav-link-accountList");
	private By ClickOn_Signin=By.xpath("//a[@rel='nofollow' and @class='nav-action-button']");
    private By email=By.xpath("//input[@id='ap_email']");
    private By clickemail=By.xpath("//input[@class='a-button-input']");
    private By pass=By.xpath("//input[@id='ap_password']");
    private By clickpass=By.xpath("//input[@id='signInSubmit']");
    
public SigninPO(WebDriver driver)
{
	this.driver=driver;
}
public void MouseAction()
{
	Actions A= new Actions(driver);
	WebElement S=driver.findElement(mouse_Over);
	A.moveToElement(S).build().perform();
}
public void SignInClick(){
	
	driver.findElement(ClickOn_Signin).click();	}

public void enter_email(){
	
	driver.findElement(email).sendKeys("priti@gmail.com");}

public void click_email() {
	
	driver.findElement(clickemail).click();}

public void enter_pass() {

	driver.findElement(pass).sendKeys("12432");;}

public void click_pass() {
	driver.findElement(clickpass).click();
}

      }