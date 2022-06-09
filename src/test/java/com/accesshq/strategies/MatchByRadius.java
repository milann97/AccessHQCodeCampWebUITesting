package com.accesshq.strategies;

import com.accesshq.models.PlanetCard;

public class MatchByRadius implements MatchingStrategy {
    double planetRadius;

    public MatchByRadius(double planetRadius) { this.planetRadius = planetRadius; }

    @Override
    public boolean match(PlanetCard strategy) {
        return strategy.getRadius().equals(planetRadius);
    }
}
