package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = {"src\\test\\resources\\features"},
    glue = {"stepdefinitions","setup"},
    plugin = {"pretty","html:reports/cucumber-reports.html"},
    monochrome = true
)

public class Test_Runner extends AbstractTestNGCucumberTests {

}

