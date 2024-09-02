package com.tic.tac.toe.statergy;

import com.tic.tac.toe.model.Board;

public class DefaultMoveStrategy implements MoveStrategy {
    @Override
    public boolean isValidMove(Board board, int x, int y) {
        return board.getCell(x, y) == '\0';
    }
}
