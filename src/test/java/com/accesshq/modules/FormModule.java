package com.accesshq.modules;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class FormModule {
    WebDriver driver;
    public FormModule(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String name) {
        driver.findElement(By.id("name")).sendKeys(name);
    }

    public void setEmail(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
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
