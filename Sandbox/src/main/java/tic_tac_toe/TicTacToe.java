package tic_tac_toe;

import game.Game;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TicTacToe extends Game {

    private Board board = Board.getInstance();
    private Scanner scanner = new Scanner(System.in);
    private Set<String> positions = new HashSet<>();
    private int moves = 0;

    @Override
    public void start() {
        System.out.println("Work in progress");
        board.initializeBoard();
        board.printBoard();
        logic();
    }

    public void logic() {
        while (true) {
            handlePlayer("X");
            if (checkForWin()) {
                System.out.println("Game Over!\n" +
                        "X wins!");
                break;
            }
            moves++;
            if (moves == 9) {
                System.out.println("Game Over!\n" +
                        "Draw.");
                break;
            }

            handlePlayer("O");
            if (checkForWin()) {
                System.out.println("Game Over!\n" +
                        "O wins!");
                break;
            }
            moves++;
        }
    }

    private void handlePlayer(String shape) {
        while (true) {
            System.out.println("Select position to place an " + shape);
            String positionX = scanner.nextLine();
            if (handleMove(positionX, shape)) {
                board.printBoard();
                break;
            }
        }
    }

    private boolean handleMove(String position, String shape) {
        if (checkForTakenPosition(position)) {
            System.out.println("This position is already taken");
            return false;
        }
        else {
            switch (position) {
                case "1":
                    board.getBoard()[0][0] = shape;
                    return true;
                case "2":
                    board.getBoard()[0][1] = shape;
                    return true;
                case "3":
                    board.getBoard()[0][2] = shape;
                    return true;
                case "4":
                    board.getBoard()[1][0] = shape;
                    return true;
                case "5":
                    board.getBoard()[1][1] = shape;
                    return true;
                case "6":
                    board.getBoard()[1][2] = shape;
                    return true;
                case "7":
                    board.getBoard()[2][0] = shape;
                    return true;
                case "8":
                    board.getBoard()[2][1] = shape;
                    return true;
                case "9":
                    board.getBoard()[2][2] = shape;
                    return true;
                default:
                    System.out.println("position not found");
                    return false;
            }
        }
    }

    private boolean checkForTakenPosition(String position) {
        if (positions.contains(position)) return true;
        else positions.add(position);
        return false;
    }

    private boolean checkForWin() {
        if ((board.getBoard()[0][0].equals(board.getBoard()[0][1])) && (board.getBoard()[0][1].equals(board.getBoard()[0][2]))) return true;
        else if ((board.getBoard()[1][0].equals(board.getBoard()[1][1])) && (board.getBoard()[1][1].equals(board.getBoard()[1][2]))) return true;
        else if ((board.getBoard()[2][0].equals(board.getBoard()[2][1])) && (board.getBoard()[2][1].equals(board.getBoard()[2][2]))) return true;

        else if ((board.getBoard()[0][0].equals(board.getBoard()[1][0])) && (board.getBoard()[1][0].equals(board.getBoard()[2][0]))) return true;
        else if ((board.getBoard()[0][1].equals(board.getBoard()[1][1])) && (board.getBoard()[1][1].equals(board.getBoard()[2][1]))) return true;
        else if ((board.getBoard()[0][2].equals(board.getBoard()[1][2])) && (board.getBoard()[1][2].equals(board.getBoard()[2][2]))) return true;

        else if ((board.getBoard()[0][0].equals(board.getBoard()[1][1])) && (board.getBoard()[1][1].equals(board.getBoard()[2][2]))) return true;
        else if ((board.getBoard()[0][2].equals(board.getBoard()[1][1])) && (board.getBoard()[1][1].equals(board.getBoard()[2][0]))) return true;

        else return false;
    }
}
