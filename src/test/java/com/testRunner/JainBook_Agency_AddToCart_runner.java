package com.testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

public class JainBook_Agency_AddToCart_runner {

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\main\\resources\\feature\\Testcase.feature",
		plugin = {"pretty", "html:reports/cucumber-html-report","json:reports/cucumber-html-report/jsonreport","com.cucumber.listener.ExtentCucumberFormatter:reports/report.html"},
		tags = {"@TC_01_jainBook"},
		glue = {"com.Stepdefinition"},
		monochrome = true
		)
public class Jainbook_Testrunner {

}
}