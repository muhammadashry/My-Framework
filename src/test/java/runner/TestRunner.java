package runner;

import basetests.BaseTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/feature",glue = {"steps"},plugin = {"pretty","html:target/cucmber-html-report"})
public class TestRunner extends BaseTests {
}
