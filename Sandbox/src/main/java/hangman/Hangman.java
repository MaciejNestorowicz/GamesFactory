package hangman;

import game.Game;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Hangman extends Game {
    private Words words = Words.getInstance();
    private Picture picture = Picture.getInstance();
    private Random random = new Random();
    private Scanner reader = new Scanner(System.in);

    private String word = getWord();
    private String[] underscores = new String[word.length()];
    private int attempt = 0;

    @Override
    public void start() {
        initializeUnderscores();
        printUnderscores();

        while (!checkForWin()) {
            System.out.println("\nGive me a letter");
            String letter = reader.nextLine();
            checkLetter(letter);
            printUnderscores();
            if (checkForLose()) break;
        }
    }

    private String getWord() {
        return words.getWords().get(random.nextInt(words.getWords().size()));
    }

    private void checkLetter(String letter) {
        if (letter.length() > 1) {
            System.out.println("Type only one letter");
            return;
        }
        if (letter.equals("")) return;
        boolean found = false;
        for (int i = 0; i < word.length(); i++) {
            if (letter.charAt(0) == word.charAt(i)){
                underscores[i] = letter;
                found = true;
            }
        }
        if (!found) {
            System.out.println("This word does not contain this letter");
            picture.drawElement(attempt);
            attempt++;
        }
    }

    private void initializeUnderscores() {
        Arrays.fill(underscores,"_ ");
    }

    private void printUnderscores() {
        for (int i = 0; i < underscores.length; i++) {
            System.out.print(underscores[i]);
        }
    }

    private boolean checkForWin() {
        for (int i = 0; i < underscores.length; i++) {
            if (underscores[i].equals("_ ")) return false;
        }
        System.out.println("\nYou Won!");
        return true;
    }

    private boolean checkForLose() {
        if (attempt == picture.getElements().size()) {
            System.out.println("\nGame Over!\n" +
                    "Your word was: " + word);
            return true;
        }
        return false;
    }
}
