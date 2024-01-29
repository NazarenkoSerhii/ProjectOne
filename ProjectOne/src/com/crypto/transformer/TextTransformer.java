package com.crypto.transformer;

public class TextTransformer {

    public String moveLetterOnRightPositions(int pos, String text) {
        StringBuilder encryptFile = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char moveChar = (char) (c + pos);
                if ((Character.isLowerCase(c) && moveChar > 'z') ||
                        (Character.isUpperCase(c) && moveChar > 'Z')) {
                    moveChar = (char) (c - (26 - pos));
                }
                encryptFile.append(moveChar);
            } else {
                encryptFile.append(c);
            }
        }
        return encryptFile.toString() + String.valueOf((char) ('!' + pos));
    }

    public String moveLetterOnLeftPositions(int poss, String text) {
        StringBuilder decryptFile = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char moveChar = (char) (c - poss);
                if ((Character.isLowerCase(c) && moveChar < 'a') ||
                        (Character.isUpperCase(c) && moveChar < 'A')) {
                    moveChar = (char) (c + (26 - poss));
                }
                decryptFile.append(moveChar);
            } else {
                decryptFile.append(c);
            }
        }
        decryptFile.deleteCharAt(decryptFile.length() - 1);
        return decryptFile.toString();
    }
}
