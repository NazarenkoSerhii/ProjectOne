package com.crypto.transformer;

import java.util.HashMap;
import java.util.Map;

public class TextTransformer {
    public String moveLetterOnRightPositions(int pos, String text) {

        //pos = 2 a  =>  c
        //iterate text using prepareAlphabet method

        return "";
    }

    public String moveLetterOnLeftPositions(int pos, String text) {

        //pos = 2 a  =>  c
        //iterate text using prepareAlphabet method

        return "";
    }

    /*
     * mode - 0: left moving; 1:right moving
     */
    private Map<String, String> prepareAlphabet(int move, int mode) {
        // if move = 2;
        Map<String, String> letters = new HashMap<>();
        if (mode == 1) {
            letters.put("A", "C");
        } else {
            letters.put("Z", "A");
        }

        return letters;
    }

}
