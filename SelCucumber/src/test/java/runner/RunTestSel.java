package runner;
import org.junit.runner.RunWith;




import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features="src/test/resources/UI/Search.feature",
		glue="stepdef",
		plugin = {"pretty",   // this mostly used for plugin generation
				"html:target/html/",
				"json:target/json/file.json",
				
				//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				},
						// specially used foe our extends report
	
		strict=false,
		dryRun=false 

		)
		


public class RunTestSel {

}
