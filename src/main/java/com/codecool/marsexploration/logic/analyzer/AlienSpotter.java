package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.data.Symbol;

import java.util.Optional;

public class AlienSpotter implements Analyzer{
    @Override
    public Optional<Outcome> analyze(Context context) {
        if (context.getRover().getTrackRecords().contains(Symbol.ALIEN)){
            talk(context);
        }
        return Optional.empty();
    }
    public void talk(Context context){
        int random = (int) (Math.random() * 2);
        if(random == 0){
            context.setExplorationOutcome(Outcome.NOT_COLONIZABLE_ALIENS);
        }else if (random == 1){
            context.setExplorationOutcome(Outcome.FRIENDLY_ALIENS);
        }
    }
}
