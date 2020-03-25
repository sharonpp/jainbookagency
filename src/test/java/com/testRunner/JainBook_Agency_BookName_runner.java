package com.testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

public class JainBook_Agency_BookName_runner {
	@RunWith(Cucumber.class)
	@CucumberOptions(
			features = "src\\main\\resources\\feature\\Testcase.feature",
			plugin = {"pretty", "html:reports/cucumber-html-report"},
			tags = {"@TC_04_jainBook"},
			glue = {"com.Stepdefinition"},
			monochrome = true
			)
	public class Jainbook_Testrunner {

	}
}
