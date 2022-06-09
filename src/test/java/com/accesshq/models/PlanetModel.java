package com.accesshq.models;

import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class PlanetModel {
    WebDriver driver;

    public PlanetModel(WebDriver driver) {
        this.driver = driver;
    }

    public void selectPlanets() {
        driver.findElement(By.cssSelector("[aria-label=planets]")).click();
    }

    public void explorePlanet(String planet) {
        for (var p : driver.findElements(By.className("planet"))) {
            if (p.findElement(By.className("name")).getText().equalsIgnoreCase(planet)) {
                p.findElement(By.cssSelector("[type=button]")).click();
                break;
            }
        }
    }

    public void checkExploration(String planet) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).
                until(ExpectedConditions.visibilityOf(driver.findElement(By.className("snackbar"))));
        Assertions.assertEquals("Exploring " + planet,
                driver.findElement(By.className("snackbar")).getText());
    }

    public Long checkDistance(WebElement planet) {
        return Long.parseLong(planet.findElement(By.className("distance")).getText().
                replace(" km", "").replaceAll(",", ""));
    }

    public String checkFurthest() throws Exception {
        Long distance = Long.valueOf(0);
        for(var p : driver.findElements(By.className("planet"))) {
            if(checkDistance(p) > distance){
                distance = checkDistance(p);
            }
            else {
                return p.findElement(By.className("planet")).getText();
            }
        }
        throw new Exception("Planet does not exist");
    }
}
