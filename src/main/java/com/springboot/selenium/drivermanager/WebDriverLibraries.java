package com.springboot.selenium.drivermanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
@Slf4j
public class WebDriverLibraries {

    @Value("${webdriver.type}")
    String browser;

    @Bean
    public WebDriver getWebDriver() {
        switch (browser.toLowerCase()) {
            case "chrome":
                return getChromeDriver();
            case "edge":
                return getEdgeDriver();
            case "firefox":
                return getFirefoxDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }


    private WebDriver getChromeDriver(){
        log.info("Chrome browser launched");

         WebDriverManager.chromedriver().setup();
         WebDriver driver = new ChromeDriver();
         driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
         driver.manage().window().maximize();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("javascriptEnabled",true);
        chromeOptions.setCapability("version","latest");

         return driver;
    }


    private WebDriver getEdgeDriver(){
        log.info("Edge browser launched");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setCapability("javascriptEnabled",true);
        edgeOptions.setCapability("version","latest");

        return driver;
    }


    private WebDriver getFirefoxDriver(){
        log.info("Firefox browser launched");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability("javascriptEnabled",true);
        firefoxOptions.setCapability("version","latest");

        return driver;
    }
}
