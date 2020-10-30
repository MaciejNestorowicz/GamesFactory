package game;

import java.util.Scanner;

public class GameSelector {

    private Scanner reader = new Scanner(System.in);
    private GameFactory gameFactory = new GameFactory();

    public void mainMenu() {
        System.out.println("Welcome to my sandbox project!\n" +
                "Type a number of a game you would like to play:\n" +
                "1. Hangman\n" +
                "2. Tic Tac Toe\n" +
                "3. Guessing Game");

        String answer = reader.nextLine();

        try {
            handleResponse(answer).start();
        } catch (NumberFormatException e) {
            System.out.println("Please type a number\n");
            mainMenu();
        } catch (NullPointerException e) {
            System.out.println("Number not found\n");
            mainMenu();
        }
    }

    private Game handleResponse(String answer) throws NumberFormatException {
            return gameFactory.provideGame(Integer.parseInt(answer));
    }
}
