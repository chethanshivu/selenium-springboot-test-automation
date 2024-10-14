package com.springboot.selenium.drivermanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
@Slf4j
public class WebDriverLibraries {

    @Bean
    public WebDriver getChromeDriver(){
        log.info("Chrome browser launched");

         WebDriverManager.chromedriver().setup();
         WebDriver driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

         return driver;
    }

    @Bean
    public WebDriver getEdgeDriver(){
        log.info("Edge browser launched");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        return driver;
    }

    @Bean
    public WebDriver getFirefoxDriver(){
        log.info("Firefox browser launched");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        return driver;
    }
}
