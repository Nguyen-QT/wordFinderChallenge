package main;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) throws FileNotFoundException {
        WordFinder wordFinder = new WordFinder(new ArrayList<>());
        wordFinder.findWords("EATEFFF \\nLXRRFFF \\nARTRFFF \\nITSEFFF \\n");
    }

}
