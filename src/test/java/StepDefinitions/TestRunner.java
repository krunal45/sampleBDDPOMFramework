package StepDefinitions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = {"StepDefinitions"},
        monochrome = true, plugin = {"pretty", "html:src/test/resources/Reports/Automation/cucumberReport.html"},
        tags = "@signUp"
//        name = ""
)
public class TestRunner {
}