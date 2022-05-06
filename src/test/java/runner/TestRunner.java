package runner;

import basetests.BaseTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\java\\features\\Login.feature",
        glue = {"steps"}, plugin = {"pretty","html:target/cucumber-html-report"}, monochrome = true)
public class TestRunner extends BaseTests {

}
