package com.tic.tac.toe.model;

import java.util.ArrayList;
import java.util.List;

import com.tic.tac.toe.exceptions.BoadException;

public class Board{

    private char[][] board;
    private List<Player> observers = new ArrayList<>();

    public Board(int size) {
        board = new char[size][size];
    }

    public void addObserver(Player player) {
        this.observers.add(player);
    }

    public void notifyObservers() {
        for (Player player : observers) {
            player.makeMove(this);
        }
    }

    public void updateBoard(int x, int y, char symbol) {
        board[x][y] = symbol;
        notifyObservers();
    }

    public char getCell(int x, int y) {
        return board[x][y];
    }

    public int length() {
        return board.length;
    }
}
