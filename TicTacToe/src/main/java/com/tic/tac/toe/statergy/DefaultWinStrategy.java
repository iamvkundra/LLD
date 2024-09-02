package com.tic.tac.toe.statergy;

import com.tic.tac.toe.model.Board;

public class DefaultWinStrategy implements WinStrategy {

    @Override
    public boolean checkWin(Board board, char symbol) {
        int size = board.length();
        for (int i=0; i<size; i++) {
            if (checkRow(board, symbol, i) || checkColumn(board, symbol, i)) {
                return true;
            }
        }
        return checkDiagonal(board, symbol) || checkAntiDiagonal(board, symbol);
    }

    private boolean checkAntiDiagonal(Board board, char symbol) {
        for (int i=0; i<board.length(); i++) {
            if (board.getCell(i, board.length()-1-i) != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal(Board board, char symbol) {
        for (int i=0; i<board.length(); i++) {
            if (board.getCell(i, i) != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(Board board, char symbol, int col) {
        for (int i=0; i<board.length(); i++) {
            if (board.getCell(i, col) != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkRow(Board board, char symbol, int row) {
        for (int i=0; i<board.length(); i++) {
            if (board.getCell(row, i) != symbol) {
                return false;
            }
        }
        return true;
    }
}
