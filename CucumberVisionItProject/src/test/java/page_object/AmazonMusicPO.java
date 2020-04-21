package page_object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import cucumber.api.Scenario;

public class AmazonMusicPO {
	WebDriver driver;
	Scenario scn;
 By email=By.xpath("//input[@id='email']");
 By pass=By.xpath("//input[@id='pass']");

public AmazonMusicPO(WebDriver driver,Scenario scn)
{
	this.driver=driver;
	this.scn=scn;
}
public void email()
{
	
}
}
