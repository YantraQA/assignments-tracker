package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
(		features= {"classpath:api"},
		glue="stepdefs",
		tags= "@sanity",
		//tags="@get,@post,@put,@delete,@patch,@options",
		plugin = {"pretty",
				"html:target/html/",
				"json:target/json/file.json"},		
		dryRun=false
)
public class RunTestAPI {

}
