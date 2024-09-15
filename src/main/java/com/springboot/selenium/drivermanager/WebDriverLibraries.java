package com.springboot.selenium.drivermanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class WebDriverLibraries {


    private static final Logger log = LoggerFactory.getLogger(WebDriverLibraries.class);

    @Bean
    public WebDriver getChromeDriver(){
        log.info("Chrome browser launched");
         WebDriverManager.chromedriver().setup();
         return new ChromeDriver();
    }
}
