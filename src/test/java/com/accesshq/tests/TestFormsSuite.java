package com.accesshq.tests;

import com.accesshq.models.FormModel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

public class TestFormsSuite {
    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
    }

    @AfterEach
    public void close() {
        driver.quit();
    }

    @Test
    public void loginButtonTest() throws InterruptedException {
        driver.findElement(By.id("loginButton")).click();
        Thread.sleep(2000);
    }

    @Test
    public void modernFormTest() {
        //Arrange
        var form = new FormModel(driver);
        driver.findElement(By.cssSelector("[aria-label=forms]")).click();
        form.setName("A");
        form.setEmail("a@gmail.com");
        form.selState("NSW");
        form.clickAgree();

        //Act
        form.clickSubmit();

        //Assert
        form.checkSubmission();
    }

    @Test
    public void tradFormTest() {
        //Arrange
        var form = new FormModel(driver);
        driver.findElement(By.cssSelector("[aria-label=forms]")).click();
        driver.findElement(By.cssSelector("[aria-selected=false")).click();
        form.setAddress("1 A Road");
        form.setGender("Male");
        form.clickAllow();

        //Act
        form.clickSubmit();

        //Assert
        form.checkSubmission();
    }
}
