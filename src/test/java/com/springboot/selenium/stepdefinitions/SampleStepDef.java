package com.springboot.selenium.stepdefinitions;


import com.springboot.selenium.pageobjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Slf4j
public class SampleStepDef {

    @Autowired
    private WebDriver webDriver;

    @Autowired
    private HomePage homePage;

    @When("User enters the Username {string}")
    public void userEntersTheUsername(String arg0) {
    }

    @And("User enters the Password {string}")
    public void userEntersThePassword(String arg0) {
    }

    @And("User clicked on Login")
    public void userClickedOnLogin() {
    }

    @Then("Home page should be open")
    public void homePageShouldBeOpen() {
    }

    @Given("User launch the web application with url {string}")
    public void userLaunchTheWebApplicationWithUrl(String url){
        webDriver.get(url);
        log.info(webDriver.getTitle());
        homePage.clickOn("30 Days Free Trial");
        log.info(webDriver.getTitle());
    }
}
