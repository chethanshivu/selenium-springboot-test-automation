package com.springboot.selenium.drivermanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class WebDriverLibraries {

    @Bean
    public WebDriver getChromeDriver(){
        log.info("Chrome browser launched");
         WebDriverManager.chromedriver().setup();
         return new ChromeDriver();
    }
}
