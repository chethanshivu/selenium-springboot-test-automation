package com.springboot.selenium.pageobjects;

import com.springboot.selenium.utils.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomePage {

    SeleniumActions seleniumActions;

    @Autowired
    public HomePage(WebDriver driver){
        seleniumActions = new SeleniumActions();
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="[id='Form_submitForm_action_request']")
    private WebElement freeTrial30Days;

      public void clickOn(String elementName){
       switch (elementName){
           case "30 Days Free Trial": seleniumActions.clickOn(freeTrial30Days);
           break;
           case "test": seleniumActions.clickOn(freeTrial30Days);
           break;
           default:
               throw new IllegalArgumentException("Invalid elementName : "+elementName);
       }
      }
}
