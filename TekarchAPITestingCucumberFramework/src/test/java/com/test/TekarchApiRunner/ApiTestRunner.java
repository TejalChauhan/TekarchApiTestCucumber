package com.test.TekarchApiRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/com/ApiTest/Features/TekarchApiTest.feature"},
glue= {"com.test.TekarchApiStepDefinition"})
public class ApiTestRunner extends  AbstractTestNGCucumberTests{
	

}
