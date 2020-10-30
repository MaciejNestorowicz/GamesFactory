package hangman;

import java.util.ArrayList;
import java.util.List;

public final class Words {
    private static Words wordsInstance = null;
    private List<String> words = new ArrayList<>();

    private Words() {
        words.add("kasa");
        words.add("strzelce");
        words.add("zabawka");
        words.add("sklep");
        words.add("karton");
    }

    public List<String> getWords() {
        return words;
    }

    public static Words getInstance() {
        if (wordsInstance == null) wordsInstance = new Words();
        return wordsInstance;
    }
}
