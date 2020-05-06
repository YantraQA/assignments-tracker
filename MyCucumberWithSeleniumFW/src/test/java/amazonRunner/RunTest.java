package amazonRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions 
  (
	features="classpath:AmazonFeatures", 
	glue="amazonStefDefs",

	plugin={"pretty",
			"html:Amazontarget/html/",
			"json:Amazontarget/json/file.json",
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
			
	dryRun=false
  )
public class RunTest 
{

}
