package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		     
		features="classpath:Features/API",
		glue="stepdefs.api",            //stepdefs.api:-if inside folder need to track
		tags="@get,@Post,@Put,@Patch,@delete,@options",
		//tags="@Sanity"
		plugin= {"pretty",
				"html:target/cucumber-reports",
				"json:target/json/file.json"},
				//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
				//monochrome = true,
		dryRun=false
		        )
public class RunTestAPI {

}
