package com.accesshq.tests;

import com.accesshq.models.PlanetModel;
import com.accesshq.strategies.MatchByDistance;
import com.accesshq.strategies.MatchByName;
import com.accesshq.strategies.MatchByRadius;
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

    @AfterEach
    public void close() throws InterruptedException {
        Thread.sleep(1500);
        driver.quit();
    }

    @Test
    public void exploreEarthByNameTest() throws Exception {
        //Arrange
        var planet = new PlanetModel(driver);
        planet.selectPlanets();

        //Act
        planet.getPlanet(new MatchByName("Earth")).explorePlanet();

        //Assert
        planet.checkExploration("Earth");
    }

    @Test
    public void exploreJuptiterByDistanceTest() throws Exception {
        //Arrange
        var planet = new PlanetModel(driver);
        planet.selectPlanets();

        //Act
        planet.getPlanet(new MatchByDistance(778500000L)).explorePlanet();

        //Assert
        planet.checkExploration("Jupiter");

    }

    @Test
    public void exploreVenusByRadiusTest() throws Exception {
        //Arrange
        var planet = new PlanetModel(driver);
        planet.selectPlanets();

        //Act
        planet.getPlanet(new MatchByRadius(6051.8)).explorePlanet();

        //Assert
        planet.checkExploration("Venus");
    }

    @Test
    public void exploreFurthestPlanetTest() throws Exception {
        //Arrange
        var planet = new PlanetModel(driver);
        planet.selectPlanets();

        //Act
        planet.getPlanet(new MatchByDistance(planet.checkFurthest())).explorePlanet();

        //Assert
        planet.checkExploration("Neptune");

    }
}
