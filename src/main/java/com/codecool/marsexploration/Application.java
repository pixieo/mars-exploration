package com.codecool.marsexploration;

import com.codecool.marsexploration.data.SimulationInput;
import com.codecool.marsexploration.logic.ExplorationSimulator;
import com.codecool.marsexploration.logic.routine.ExplorationRoutine;
import com.codecool.marsexploration.logic.routine.ReturningRoutine;
import com.codecool.marsexploration.logic.routine.Routine;
import com.codecool.marsexploration.logic.ui.UserInput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {
        UserInput userInput = new UserInput();

        List<Routine> routines = new ArrayList<>();
        routines.add(new ExplorationRoutine());
        routines.add(new ReturningRoutine());

        ExplorationSimulator simulator = new ExplorationSimulator(routines);

        SimulationInput input = userInput.getConfiguration();
        simulator.simulate(input);
    }
}
