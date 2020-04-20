package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
  (
	features="classpath:features",
	glue="",
	tags="",
	plugin={"pretty",
			"html:target/html/",
			"json:target/json/file.json",
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
				//for extent report generation use this adapter also add dependancy in pom.xml
				//by anshul arora indian <!-- For Extent Reports --> 4 dependacies we added for extent reporte
		       //extent report cucumber and extentreports are depends on free marker and mangodb
	dryRun=false
  )
public class RunTest 
{

}
