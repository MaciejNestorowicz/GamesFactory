package guessing_game;

import game.Game;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame extends Game {

    private Random random = new Random();
    private int searched = random.nextInt(1000);
    private int numberOfAttempts = 10;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void start() {
        System.out.println("There is a random number between 1 and 1000.\n" +
                "Your task is to find that number in 10 attempts or quicker\n" +
                "Give me your first number!");
        game();
    }

    private void game() {
        while (true) {
            if (guess()) {
                System.out.println("You Won!");
                break;
            } else {
                numberOfAttempts--;
                System.out.println("You have " + numberOfAttempts + " attempts left");
            }
            if (numberOfAttempts == 0) {
                System.out.println("Game Over!\n" +
                        "Number you were looking for is: " + searched);
                break;
            }
        }
    }

    private boolean guess() {
        String answer = scanner.nextLine();
        try {
            if (Integer.parseInt(answer) == searched) return true;
            else if (Integer.parseInt(answer) < searched) System.out.println("Number you are looking for is bigger");
            else System.out.println("Number you are looking for i smaller");
        } catch (NumberFormatException e) {
            System.out.println("Please provide a number");
        }
        return false;
    }

}
