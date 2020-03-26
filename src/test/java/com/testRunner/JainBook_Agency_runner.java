package com.testRunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


	@RunWith(Cucumber.class)
	@CucumberOptions(
			features="src\\main\\resources\\feature\\jain.feature",
					plugin= {"pretty","html:reports/cucumber-html-report","json:reports/cucumber-html-report/jsonreport",
					        "com.cucumber.listener.ExtentCucumberFormatter:reports/report.html"},
			tags= {"@TC_01_jainBook,@TC_02_jainBook,@TC_03_jainBook,@TC_04_jainBook,@TC_05_jainBook"},
			glue= {"com.stepDefinition"},
			monochrome=true
			)
	public class JainBook_Agency_runner {
		

		@AfterClass
		  public static void extendReport() 
		{
		      Reporter.loadXMLConfig("src/test/resources/extent-config.xml");
		      Reporter.setSystemInfo("user", System.getProperty("user.name"));
		      Reporter.setSystemInfo("os", "Windows");
		      Reporter.setTestRunnerOutput("Sample test runner output message");
		}
	}
