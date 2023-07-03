package com.codecool.marsexploration.data;

public record SimulationInput(
        String mapPath,
        String roverId,
        int roverSight,
        Coordinate landing,
        int mineralToCollect,
        int waterToCollect,
        int timeout,
        String logPath
) {}