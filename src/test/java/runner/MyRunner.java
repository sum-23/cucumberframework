package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = { "stepdefinitions", "hooks" }, plugin = {
		"html:target/cucumber/cucumberReport.html", "pretty" }, publish=true)
public class MyRunner {

}
