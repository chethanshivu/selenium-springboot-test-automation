package com.springboot.selenium;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class SeleniumApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(SeleniumApplicationTests.class);

	@Autowired
	private WebDriver webDriver;

	@Test
	void contextLoads() {
        webDriver.get("https://www.orangehrm.com");
		log.info(webDriver.getTitle());
	}

}
