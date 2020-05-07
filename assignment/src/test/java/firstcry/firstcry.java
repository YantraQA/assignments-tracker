package runner;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Signingmail {
	
	String hostName = "anamikamehta9429.gmail.com";
	String username = "Anamika Mehta";
	String password = "anamika1234";
	int messageCount;
	int unreadMsgCount;
	String emailSubject;
	Message emailMessage;
	@Test
	//static String pagetitle ="Shopping Cart Software & Ecommerce Software Solutions by CS-Cart";
	public static void signin() {
	//System.setProperty("webdriver.chrome.driver", "F:\\\\visionit\\\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	driver.manage().window().maximize();
	driver.navigate().to("https://www.firstcry.com/");
	Reporter.log("URL Opened <br>",true);
	 //Click on Register
	driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div[3]/ul/li[6]/span[2]")).click();
	 //Click on Email Id
	 driver.findElement(By.xpath("//*[@id=\"lemail\"]")).click();
	 //Enter EmailId
	 driver.findElement(By.xpath("//*[@id=\"lemail\"]")).sendKeys("anamikamehta9429@gmail.com");

		driver.findElement(By.xpath("//*[@id=\"login\"]/div[2]")).click();
		Reporter.log("Click on Sign In <br>",true);
		driver.findElement(By.xpath("//*[@id=\"login\"]/div/div[2]")).click();
		
		 //Enter EmailId
		 driver.findElement(By.xpath("//*[@id=\"lpass\"]")).sendKeys("Pooja1234");
		 driver.findElement(By.xpath("//*[@id=\"loginpassword\"]/div[2]")).click();
		
	}
	@AfterMethod
	public void MailReader() throws InterruptedException {
	    Properties sysProps = System.getProperties();
	    sysProps.setProperty("mail.store.protocol", "imaps");
	    WebDriver driver1 = new ChromeDriver();
	    driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver1.manage().window().maximize();
		driver1.navigate().to("https://accounts.google.com/ServiceLogin?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1");
		 driver1.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("anamikamehta9429@gmail.com");
		 driver1.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span")).click();
		 
		 
		 driver1.findElement(By.xpath("	//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("anamika1234");
		 driver1.findElement(By.xpath("//*[@id=\"passwordNext\"]/span/span")).click();
		 
	


}
		/*
		// List of all Unread Emails
		 List<WebElement> unreademail = driver1.findElements(By.className("zE"));
		 // Display count of unread emails
		 System.out.println("Total No. of Unread Mails: " + unreademail.size());
		 

		 // real logic starts here

		 for(int i=0;i<unreademail.size();i++){

		 System.out.println(unreademail.get(i).getText());

		 }

		 unreademail.get(1).click();

		 Thread.sleep(3000);

		 driver1.close();
		 
		 */
		 
	/*
	    
	    try {
	        Session session = Session.getInstance(sysProps, null);
	        Store store = session.getStore();
	        store.connect(hostName, username, password);
	        Folder emailInbox = store.getFolder("INBOX");
	        emailInbox.open(Folder.READ_WRITE);
	        messageCount = emailInbox.getMessageCount();
	        System.out.println("Total Message Count: " + messageCount);
	        unreadMsgCount = emailInbox.getNewMessageCount();
	        System.out.println("Unread Emails count:" + unreadMsgCount);
	        emailMessage = emailInbox.getMessage(messageCount);
	        emailSubject = emailMessage.getSubject();

	        Pattern linkPattern = Pattern.compile("href=\"(.*)\" target"); // here you need to define regex as per you need
	        Matcher pageMatcher =
	                linkPattern.matcher(emailMessage.getContent().toString());

	        while (pageMatcher.find()) {
	            System.out.println("Found OTP " + pageMatcher.group(1));
	        }
	        emailMessage.setFlag(Flags.Flag.SEEN, true);
	        emailInbox.close(true);
	        store.close();

	    } catch (Exception mex) {
	        mex.printStackTrace();
	    }
}*/
}


