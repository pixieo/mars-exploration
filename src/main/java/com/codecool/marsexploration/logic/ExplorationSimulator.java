package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Rover;
import com.codecool.marsexploration.data.SimulationInput;
import com.codecool.marsexploration.logic.routine.Routine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.codecool.marsexploration.logic.filereader.MapCoordinates.getMapCoordinates;
import static com.codecool.marsexploration.logic.filereader.ReadMap.readFileToString;

public class ExplorationSimulator {
    private final List<Routine> routines;
    public ExplorationSimulator(List<Routine> routines) {
        this.routines = routines;
    }
    public void simulate(SimulationInput input) throws IOException {
        List<Coordinate> mineralToCollect = new ArrayList<>();
        List<Coordinate> waterToCollect = new ArrayList<>();
        Set<Coordinate> trackRecords = new HashSet<>();

        Rover rover = new Rover(
                input.roverId(),
                input.landing(),
                input.roverSight(),
                mineralToCollect,
                waterToCollect,
                0,
                0,
                routines.get(0),
                trackRecords, false);

        Context context = new Context(
                1,
                input.landing(),
                input.timeout(),
                getMapCoordinates(readFileToString(input.mapPath())),
                rover,
                input.mineralToCollect(),
                input.waterToCollect(),
                null,
                false,
                input.logPath()
        );

        while(!context.hasOutcomeBeenReached()) {
            context.getRover().getRoutine().move(context);
        }
    }
}
