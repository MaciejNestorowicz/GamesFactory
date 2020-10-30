package game;

import guessing_game.GuessingGame;
import hangman.Hangman;
import tic_tac_toe.TicTacToe;

public class GameFactory {
    public Game provideGame(int number) {
        if (number == 1) return new Hangman();
        else if (number == 2) return new TicTacToe();
        else if (number == 3) return new GuessingGame();
        else return null;
    }
}
