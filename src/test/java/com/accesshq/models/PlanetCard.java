package com.accesshq.models;

import org.openqa.selenium.*;

import java.util.Locale;

public class PlanetCard {
    WebElement planetElement;
    public PlanetCard(WebElement planetElement) {
        this.planetElement = planetElement;
    }

    public String getName() {
        return planetElement.findElement(By.className("name")).getText().toLowerCase(Locale.ROOT);
    }

    public Long getDistance() {
        return Long.parseLong(planetElement.findElement(By.className("distance")).getText().
                replaceAll(" km", "").
                replaceAll(",", ""));
    }

    public void explorePlanet() {
        planetElement.findElement(By.cssSelector("[type=button]")).click();
    }

    public Double getRadius() {
        return Double.parseDouble(planetElement.findElement(By.className("radius")).getText().
                replaceAll(" km","").
                replaceAll(",",""));
    }
}
