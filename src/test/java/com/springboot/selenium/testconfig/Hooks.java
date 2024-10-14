package com.springboot.selenium.testconfig;

import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;

public class Hooks {


    @Autowired
    private WebDriver driver;

    @BeforeAll
    public void SetUp(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterAll
    public void tearDown(){

    }

    @Before
    public void preSetup(){

    }

    @After
    public void report(){

    }

    @AfterStep
    public void addInformation(){

    }

    @BeforeStep
    public void addLogs(){

    }
}
