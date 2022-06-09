package com.accesshq.strategies;

import com.accesshq.models.PlanetCard;

public class MatchByDistance implements MatchingStrategy {
    Long planetDistance;

    public MatchByDistance(Long planetDistance) { this.planetDistance = planetDistance; }

    @Override
    public boolean match(PlanetCard strategy) {
        return strategy.getDistance().equals(planetDistance);
    }
}
