package cucumberOptions;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(		
		features= {"src/test/java/features"},
		glue= {"stepDefinitions"},
		tags = {"@DeletePlace"},
		//plugin = "json:target/jsonReports/cucumber-report.json"
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/report.html"}
		//plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/report.html"}
		)
public class TestRunner {
	
}
