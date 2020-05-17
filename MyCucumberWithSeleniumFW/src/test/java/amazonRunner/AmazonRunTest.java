package amazonRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions //it is act as driver like what is to be executed and what is not to be
  (
	features="classpath:AmazonFeatures", //where the AmazonFeatures is located shows that path
	glue="amazonStefDefs", // where the stefDefs is located shows that path
	tags="@TC0004",
	plugin={"pretty",
			"html:Amazontarget/html/",
			"json:Amazontarget/json/file.json",
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
			//for extent report generation use this adapter also add dependancy in pom.xml
			//by anshul arora indian <!-- For Extent Reports --> 4 dependacies we added for extent reporte
	       //extent report cucumber and extentreports are depends on free marker and mangodb
	
	dryRun=false//generate signature of a stef defination of a method
  )
public class AmazonRunTest {

}
