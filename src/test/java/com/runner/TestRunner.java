package com.runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

	@CucumberOptions(
			features = "src/test/resources/resources/features/launch.feature",
			glue ="com.stepDefinition",
			plugin = {"pretty","html:Reports/cucumber-html-report.html"}
			
			)
	

public class TestRunner extends AbstractTestNGCucumberTests{
		
	}
	

