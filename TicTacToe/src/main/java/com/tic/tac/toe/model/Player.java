package com.tic.tac.toe.model;

public abstract class Player {
    char symbol;

    public char getSymbol() {
        return this.symbol;
    }

    public abstract void makeMove(Board board);
}
