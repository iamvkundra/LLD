package com.tic.tac.toe.statergy;

import com.tic.tac.toe.model.Board;

public interface MoveStrategy {
    boolean isValidMove(Board board, int x, int y);
}
