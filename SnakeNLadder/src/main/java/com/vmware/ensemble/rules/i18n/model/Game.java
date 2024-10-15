package com.vmware.ensemble.rules.i18n.model;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Game {

    private Board board;
    private Deque<Player> players;
    private Dice dice;
    private Player winner;

    public Game() {
        initializeGame();
    }

    private void initializeGame() {
        this.board = new Board(10, 5, 4);
        this.dice = new Dice(1);
        this.winner = null;
        this.players = new LinkedList<>();
        addPlayer();
    }

    private void addPlayer() {
        Player player1 = new Player("p1", 0);
        Player player2 = new Player("p2", 0);

        players.add(player1);
        players.add(player2);
    }

    public void startGame() {

        while (winner == null) {
            Player playerTurn = findPlayerTurn();
            System.out.println("Player turn is: [" + playerTurn.getPlayerId() + "] current position is: " + playerTurn.getPosition());

            int diceNumber = dice.rollDice();

            int playerNewPosition = playerTurn.getPosition() + diceNumber;
            playerNewPosition = jumpCheck(playerNewPosition);
            playerTurn.setPosition(playerNewPosition);

            System.out.println("Player turn is: [" + playerTurn.getPlayerId() + "] new position is: " + playerNewPosition +" dice: "+diceNumber);

            if (playerNewPosition >= board.getSize()) {
                winner = playerTurn;
            }
        }
        System.out.println("WINNER IS: " + winner.getPlayerId());
    }

    private int jumpCheck(int playerNewPosition) {
        if (playerNewPosition > board.getSize()) {
            return playerNewPosition;
        }

        Cell cell = board.getCellCoordinates(playerNewPosition);
        if(cell.getJump() != null && cell.getJump().getStart() == playerNewPosition) {
            String jumpBy = (cell.getJump().getStart() < cell.getJump().getEnd())? "ladder" : "snake";
            System.out.println("jump done by: " + jumpBy);
            return cell.getJump().getEnd();
        }
        return playerNewPosition;
    }

    private Player findPlayerTurn() {
        Player player = players.removeFirst();
        players.addLast(player);
        return player;
    }
}
