package com.codecool.marsexploration.logic.routine;

import com.codecool.marsexploration.data.Context;

import java.io.IOException;

public interface Routine {
    void move(Context context) throws IOException;
}
