package com.tic.tac.toe.statergy;

import com.tic.tac.toe.model.Board;

public interface WinStrategy {
    boolean checkWin(Board board, char symbol);
}
