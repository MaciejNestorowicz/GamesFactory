package tic_tac_toe;

public class Board {

    private static Board boardInstance = null;
    private String[][] board = new String[3][3];

    public void printBoard() {
        System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2] + "\n" +
                           "----------\n" +
                           board[1][0] + " | " + board[1][1] + " | " + board[1][2] + "\n" +
                           "----------\n" +
                           board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }

    public String[][] getBoard() {
        return board;
    }

    public void initializeBoard() {
        board[0][0] = "1"; board[0][1] = "2"; board[0][2] = "3";
        board[1][0] = "4"; board[1][1] = "5"; board[1][2] = "6";
        board[2][0] = "7"; board[2][1] = "8"; board[2][2] = "9";
    }

    public static Board getInstance() {
        if (boardInstance == null) boardInstance = new Board();
        return boardInstance;
    }
}
