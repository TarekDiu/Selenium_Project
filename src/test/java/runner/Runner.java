package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src\\test\\resources\\features"},	
		glue = {"step_definations"},
		tags = "@login and not @excelfile",  //@excelfile or @logininvalid or @login
		monochrome = true,
		dryRun = false,
		plugin = {"pretty", "html:test-output", "json:target/cucumber-report/cucumber.json",}
		
)
public class Runner {

}

