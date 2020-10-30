package hangman;

import java.util.ArrayList;
import java.util.List;

public final class Picture {
    private static Picture picture = null;
    private final List<String> elements = new ArrayList<>();

    private Picture() {
        elements.add("  /");
        elements.add("  / \\");
        elements.add("   |\n  / \\");
        elements.add("   |\n   |\n  / \\");
        elements.add("   |\n   |\n   |\n  / \\");
        elements.add("   |\n   |\n   |\n   |\n  / \\");
        elements.add("   |/\n   |\n   |\n   |\n  / \\");
        elements.add("    _____\n   |/\n   |\n   |\n   |\n  / \\");
        elements.add("    _____\n   |/    |\n   |\n   |\n   |\n  / \\");
        elements.add("    _____\n   |/    |\n   |     O\n   |\n   |\n  / \\");
        elements.add("    _____\n   |/    |\n   |     O\n   |     |\n   |\n  / \\");
        elements.add("    _____\n   |/    |\n   |     O\n   |    /|\n   |\n  / \\");
        elements.add("    _____\n   |/    |\n   |     O\n   |    /|\\\n   |\n  / \\");
        elements.add("    _____\n   |/    |\n   |     O\n   |    /|\\\n   |    / \n  / \\");
        elements.add("    _____\n   |/    |\n   |     O\n   |    /|\\\n   |    / \\\n  / \\");
    }

    public List<String> getElements() {
        return elements;
    }

    public void drawElement(int index) {
        System.out.println(elements.get(index));
    }

    public static Picture getInstance() {
        if (picture == null) picture = new Picture();
        return picture;
    }
}
