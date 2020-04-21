package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		     
		features="classpath:Features/UI",
		glue="stepdefs.ui",            //stepdefs.api:-if inside folder need to track
		tags="",
		plugin= {"pretty",
				"html:target/cucumber-reports",
				"json:target/json/file.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
				//monochrome = true,
		strict=false,
		dryRun=false
		        )

public class RunTestUI {

}
