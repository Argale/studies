package com.epam.project.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/test/resources/com/epam/project/runner" },	
		plugin = { "pretty", "html:target/cucumber", "junit:target/surefire-reports/junit-report.xml" }, 
		tags = { "@Test" }, 
		glue = {"com.epam.project.steps"}, 
		monochrome = (true), 
		strict = (true))
public class RunCukesTest {

}
