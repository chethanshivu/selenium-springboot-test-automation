package com.springboot.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SeleniumApplicationTests {

	@Autowired
	private WebDriver webDriver;

	@Test
	void contextLoads() {
        webDriver.get("https://www.orangehrm.com");
	}

}
