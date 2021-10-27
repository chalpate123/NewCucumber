package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src\\test\\resources\\Features\\Homepage.feature" }, glue = {
		"HomeStep" }, plugin = { "pretty",
				"html:target/cucumber-reports.html" }, dryRun = false, monochrome = true, tags = "@smoke")
public class RunnerHomepage {

}
