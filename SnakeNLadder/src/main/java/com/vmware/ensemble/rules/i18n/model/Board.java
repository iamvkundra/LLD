package com.vmware.ensemble.rules.i18n.model;

import java.util.concurrent.ThreadLocalRandom;

import com.vmware.ensemble.rules.i18n.enums.JumpType;

public class Board {
    private Cell[][] cells;

    Board(int boardSize, int numberOfSnakes, int noOfLadders) {
        initializeCells(boardSize);
        addSnakes(cells, numberOfSnakes);
        addLadder(cells, noOfLadders);
    }

    private void initializeCells(int boardSize) {
        this.cells = new Cell[boardSize][boardSize];
        for (int i=0; i<cells.length; i++) {
            for (int j=0; j<cells[0].length; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public int getSize() {
        return cells.length * cells[0].length-1;
    }

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    public Cell getCellCoordinates(int position) {
        int row = position/cells.length;
        int col = (position % cells.length);
        return cells[row][col];
    }

    private void addSnakes(Cell[][] cells, int numberOfSnakes) {
        while (numberOfSnakes > 0) {
            int snakeHead = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length-1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length-1);

            if (snakeTail >= snakeHead) {
                continue;
            }
            Jump snakeObject = new Jump(snakeHead, snakeTail, JumpType.SNAKE);
            Cell cell = getCellCoordinates(snakeHead);
            cell.setJump(snakeObject);
            numberOfSnakes--;
        }
    }

    private void addLadder(Cell[][] cells, int numberOfLadder) {
        while(numberOfLadder > 0) {
            int ladderHead = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length-1);
            int ladderTail = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length-1);

            if (ladderHead >= ladderTail) {
                continue;
            }

            Jump ladder = new Jump(ladderHead, ladderTail, JumpType.LADDER);
            Cell cell = getCellCoordinates(ladderHead);
            cell.setJump(ladder);

            numberOfLadder--;
        }
    }
}
