package com.codecool.marsexploration.data;

public enum Symbol {
    EMPTY(' '),
    MOUNTAIN('^'),
    PIT('#'),
    MINERAL('*'),
    WATER('~'),
    ALIEN('A');

    private final char symbol;

    Symbol(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
