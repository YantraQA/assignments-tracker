package v3purestudy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class PureStudy {
	String username = "red";
	String password = "RED@123";
	static WebElement dropCourse;
	@Test
	public static void login() throws InterruptedException {
	//System.setProperty("webdriver.chrome.driver", "F:\\visionit\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	driver.manage().window().maximize();
	//open url
	driver.navigate().to("http://v3.purestudy.com/auth/login");
	Reporter.log("URL Opened <br>",true);
	 //Enter Username
	 driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).click();
	 driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).sendKeys("red");
	 //Enter pass
	 driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).click();
	 driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).sendKeys("RED@123");
	 //click on login
	 driver.findElement(By.xpath("//*[@id=\"login-form\"]/form/button")).click();
	 //click on user
	 driver.findElement(By.xpath("//*[@id=\"container-1\"]/fuse-sidebar/navbar/navbar-vertical-style-1/div[2]/div[1]/fuse-navigation/div/fuse-nav-vertical-group/div[2]/fuse-nav-vertical-collapsable[1]/a/mat-icon[1]")).click();
	 //click on User Management
	 driver.findElement(By.xpath("//span[contains(text(),\"User Managment\")]")).click();
	 //Back to this page
	 driver.findElement(By.xpath("//*[@id=\"faculty\"]")).click();
	 
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 Thread.sleep(1500);
	 	//Click on the course dropdown
		driver.findElement(By.xpath("//form[@name='searchFacultyForm']/div/mat-form-field/div/div/div[3]")).click();	//click on course dropdown
		Thread.sleep(1500);
		//Click on Master Of Business Admintration	
		driver.findElement(By.xpath("//*[@id=\"mat-option-28\"]/span")).click(); //click on Master Of Business Admintrations from the dropdown
		Thread.sleep(1500);
		//Click on the course year	
		driver.findElement(By.xpath("//form[@name='searchFacultyForm']/div/mat-form-field[2]/div/div/div[3]")).click();	//click on course year dropdown
	    //Click on First Year
		driver.findElement(By.xpath("//mat-option[@class='mat-option ng-star-inserted mat-active']/span[@class='mat-option-text' and contains(text(),' First Year ')]")).click(); //click on Master Of Business Admintrations from the dropdown
		Thread.sleep(1500);
		//Click on the Academic Year
		driver.findElement(By.xpath("//form[@name='searchFacultyForm']/div/mat-form-field[3]/div/div/div[3]")).click();	//click on academic year dropdown
		//Click on 2018-2019 
		driver.findElement(By.xpath("//mat-option[@class='mat-option ng-star-inserted mat-active']/span[@class='mat-option-text' and contains(text(),' 2018-2019 ')]")).click(); //click on Master Of Business Admintrations from the dropdown
		Thread.sleep(1500);
		//Click on the semester
		driver.findElement(By.xpath("//form[@name='searchFacultyForm']/div/mat-form-field[4]/div/div/div[3]")).click();	//click on semester dropdown
		//Click on sem 1
		driver.findElement(By.xpath("//mat-option[@class='mat-option ng-star-inserted mat-active']/span[@class='mat-option-text' and contains(text(),' sem1 ')]")).click(); //click on Master Of Business Admintrations from the dropdown
		Thread.sleep(1500);
		//Click on the specialization
		driver.findElement(By.xpath("//form[@name='searchFacultyForm']/div/mat-form-field[5]/div/div/div[3]")).click();	//click on specialization dropdown	
		driver.findElement(By.xpath("//*[@id=\"mat-option-49\"]/span")).click(); //click on Master Of Business Admintrations from the dropdown
		Thread.sleep(1500);
		//Click on the section/division
		driver.findElement(By.xpath("//form[@name='searchFacultyForm']/div/mat-form-field[6]/div/div/div[3]")).click();	//click on division dropdown
		//Click on div-1
		driver.findElement(By.xpath("//span[contains(text(),' MBAF DIV[A] ')]")).click(); //click on Master Of Business Admintrations from the dropdown
		Thread.sleep(1500);
		//Click on search button
		driver.findElement(By.xpath("//b[contains(text(),'Search')]")).click();		//click on search button
		
		Thread.sleep(1500);
		int table = driver.findElements(By.xpath("//div[@class='fuse-card ng-star-inserted']/table/tbody/tr")).size();
		System.out.println("Size of table is: " + table);
		System.out.println("Below are the Details of Faculty: ");
		for (int i = 1; i<=table; i++) {
			System.out.println();
			for(int j = 1; j <= 5; j++) {
				String data = driver.findElement(By.xpath("//div[@class='fuse-card ng-star-inserted']/table/tbody/tr[" + i + "]/td[" + j + "]")).getText();
				System.out.print("\t " + data);
			}
	 
	/* 
	
    //click on first year
	driver.findElement(By.xpath("//span[contains(text(),\"First Year \")]")).click();
	
*/

		
		}
	
}
}