package com.springboot.selenium;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.test.context.SpringBootTest;

import static io.cucumber.core.options.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME,
                        value = "com.springboot.selenium.stepdefinitions,"+
                                "com.springboot.selenium.testconfig")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@Regression")
@SpringBootTest
class SeleniumApplicationTests {

}
