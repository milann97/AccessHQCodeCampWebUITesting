package com.accesshq.models;

import com.accesshq.strategies.MatchingStrategy;
import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;

public class PlanetModel {
    WebDriver driver;
    ArrayList<PlanetCard> allPlanets;

    public PlanetModel(WebDriver driver) {
        this.driver = driver;
    }

    private ArrayList<PlanetCard> getAllPlanets() {
        var allPlanets = new ArrayList<PlanetCard>();
        for(WebElement p : driver.findElements(By.className("planet"))) {
            allPlanets.add(new PlanetCard(p));
        }
        return allPlanets;
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

    public Long checkFurthest() throws Exception {
        Long distance = 0L;
        for(var p : driver.findElements(By.className("planet"))) {
            if(checkDistance(p) > distance){
                distance = checkDistance(p);
            }
            else {
                return distance;
            }
        }
        throw new Exception("Planet not found");
    }

    public PlanetCard getPlanet(MatchingStrategy strategy) throws Exception {
        for(PlanetCard p : getAllPlanets()) {
            if(strategy.match(p)) {
                return p;
            }
        }
        throw new Exception("Planet not found");
    }
}
