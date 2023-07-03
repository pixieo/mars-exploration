package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Symbol;
import com.codecool.marsexploration.logic.routine.AproachingAlienRoutine;

import java.io.IOException;

public class ChangeExploringToAproachingAlien implements Phase{
    @Override
    public void perform(Context context) throws IOException {
        if(context.getRover().getTrackRecords().contains(Symbol.ALIEN.getSymbol())){
            context.getRover().setRoutine(new  AproachingAlienRoutine());
        }
    }
}
