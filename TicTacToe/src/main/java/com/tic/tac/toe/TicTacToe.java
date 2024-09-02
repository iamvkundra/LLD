package com.tic.tac.toe;

import java.util.Scanner;

import com.tic.tac.toe.model.Board;
import com.tic.tac.toe.model.Player;
import com.tic.tac.toe.model.PlayerFactory;
import com.tic.tac.toe.statergy.DefaultMoveStrategy;
import com.tic.tac.toe.statergy.DefaultWinStrategy;
import com.tic.tac.toe.statergy.MoveStrategy;
import com.tic.tac.toe.statergy.WinStrategy;

public class TicTacToe {

    private static Board board = new Board(3);;
    private static Player currentPlayer;
    private static Player player1=PlayerFactory.createPlayer('X');
    private static Player player2=PlayerFactory.createPlayer('O');
    private static MoveStrategy moveStrategy=new DefaultMoveStrategy();
    private static WinStrategy winStrategy=new DefaultWinStrategy();;

    public TicTacToe() {

    }

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        currentPlayer = player1;
        board.addObserver(player1);
        while (true) {
            System.out.println("Player " + currentPlayer.getSymbol() + "'s turn");
            System.out.println("Enter row (0, 1, or 2): ");
            int x = scanner.nextInt();
            System.out.println("Enter column (0, 1, or 2): ");
            int y = scanner.nextInt();

            if (moveStrategy.isValidMove(board, x, y)) {
                board.updateBoard(x, y, currentPlayer.getSymbol());

                if (winStrategy.checkWin(board, currentPlayer.getSymbol())) {
                    System.out.println("Player: "+currentPlayer.getSymbol()+" wins!");
                    break;
                }

                if (isDraw()) {
                    System.out.println("Game is Draw!");
                    break;
                }
                switchPlayer();
            }else {
                System.out.println("Invalid Move. Please provide valid move!");
            }
        }
        scanner.close();
        System.out.println("----------------_CLOSED-------------------");
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public static boolean isDraw() {
        for (int i=0; i<board.length(); i++) {
            for (int j=0; j<board.length(); j++) {
                if (board.getCell(i, j) == '\0') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("------------------TIC TAC TOE-------------------------");
        playGame();
    }
}