package com.tic.tac.toe.model;

public class HumanPlayer extends Player {

    public HumanPlayer(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void makeMove(Board board) {
        for (int i=0; i< board.length(); i++) {
            System.out.print("[");
            for (int j=0; j<board.length(); j++) {
                System.out.print(board.getCell(i,j) + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }
}

