package com.accesshq.models;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class FormModel {
    WebDriver driver;
    public FormModel(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String name) {
        driver.findElement(By.id("name")).sendKeys(name);
    }

    public void setEmail(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    public void selState(String state) {
//        Select selectState = new Select(driver.findElement(By.id("state")));
//        selectState.selectByVisibleText(state);
//        driver.findElement(By.cssSelector("[id=state]")).click();
//        driver.findElement(By.id("list-item-377-0")).click();
        driver.findElement(By.id("state")).sendKeys(state);
    }

    public void clickAgree() {
        driver.findElement(By.cssSelector("[for=agree]")).click();
    }

    public void clickSubmit() {
        var buttons = driver.findElements(By.cssSelector("button"));
        for (WebElement button : buttons)
        {
            if(button.getText().equalsIgnoreCase("submit")){
                button.click();
                break;
            }
        }
    }

    public void setAddress(String address) {
        driver.findElement(By.id("address")).sendKeys(address);
    }

    public void setGender(String gender) {
        Select selectGender = new Select(driver.findElement(By.id("gender")));
        selectGender.selectByVisibleText(gender);
    }

    public void clickAllow() {
        driver.findElement(By.id("allow")).click();
    }

    public void checkSubmission() {
        var submitConfirmation = driver.findElement(By.cssSelector("[aria-live=polite]"));
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(submitConfirmation));
    }
}
