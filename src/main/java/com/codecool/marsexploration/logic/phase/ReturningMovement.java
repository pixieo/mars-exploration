package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;

public class ReturningMovement implements Phase{
    @Override
    public void perform(Context context) {
        context.getRover().setPosition(context.getStartingCoords());
    }
}
