package com.tic.tac.toe.model;

public class PlayerFactory {
    public static Player createPlayer(char symbol) {
        return new HumanPlayer(symbol);
    }
}
