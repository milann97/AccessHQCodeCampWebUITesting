package com.accesshq.models;

import org.openqa.selenium.*;

public class PlanetCard {
    WebElement planet;
    public PlanetCard(WebElement planet) {
        this.planet = planet;
    }

    public void PlanetCard() {
        planet.findElement(By.className("planet"));
    }

    public Long getDistance() {
        return Long.parseLong(planet.findElement(By.className("distance")).getText().
                replace(" km", "").replaceAll(",", ""));
    }
}
