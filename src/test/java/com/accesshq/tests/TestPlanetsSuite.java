package com.accesshq.tests;

import com.accesshq.models.PlanetCard;
import com.accesshq.models.PlanetModel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

public class TestPlanetsSuite {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
    }

//    @AfterEach
//    public void close() {
//        driver.quit();
//    }

    @Test
    public void explorePlanetTest() {
        //Arrange
        var planet = new PlanetModel(driver);
        planet.selectPlanets();
        String input = "Earth";
        //Act
        planet.explorePlanet(input);

        //Assert
        planet.checkExploration(input);
    }

    @Test
    public void furthestPlanetTest() throws Exception {
        var furthest = new PlanetModel(driver);
        furthest.selectPlanets();
        furthest.checkFurthest();
    }

    @Test
    public void getPlanet() {
        var planets = new PlanetModel(driver);
        planets.selectPlanets();
    }
}
