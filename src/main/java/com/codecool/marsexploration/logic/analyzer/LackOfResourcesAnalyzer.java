package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;

import java.util.Optional;

public class LackOfResourcesAnalyzer implements Analyzer{
    @Override
    public Optional<Outcome> analyze(Context context) {
        if (context.getRover().getCoordinatesOfMineralToCollect().size() <= context.getNumberOfMineralToCollect() && context.getRover().getCoordinatesOfWaterToCollect().size() <= context.getNumberOfWaterToCollect()) {
            context.setHasOutcomeBeenReached(true);
            return Optional.of(Outcome.NOT_COLONIZABLE_RESOURCES);
        }
        return Optional.empty();
    }
}
