package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;

public class StepIncrement implements Phase{
    @Override
    public void perform(Context context) {
        context.setStepNumber((int) (context.getStepNumber() + 1));
    }
}
