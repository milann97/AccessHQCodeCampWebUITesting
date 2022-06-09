package com.accesshq.strategies;

import com.accesshq.models.PlanetCard;

public class MatchByName implements MatchingStrategy {
    String planetName;

    public MatchByName(String planetName) { this.planetName = planetName; }

    @Override
    public boolean match(PlanetCard strategy) {
        return strategy.getName().equalsIgnoreCase(planetName);
    }
}
