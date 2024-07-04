package TextTransformer;

public class TextTransformer {

    public String moveLetterOnRightPositions(int key, String text, char[] alphabet) {
        StringBuilder encryptFile = new StringBuilder();
        char[] charText = text.toCharArray();
        for (int i = 0; i < charText.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (charText[i] == alphabet[j]) {
                    char moveChar = ' ';
                    int index = j + key;
                    if (index > alphabet.length - 1) {
                        moveChar = alphabet[j + key - alphabet.length];
                    } else moveChar = alphabet[j + key];
                    encryptFile.append(moveChar);
                }
            }
        }
        return encryptFile.toString();
    }

    public String moveLetterOnLeftPositions(int key, String text, char[] alphabet) {
        StringBuilder decryptFile = new StringBuilder();
        char[] charText = text.toCharArray();
        for (int i = 0; i < charText.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (charText[i] == alphabet[j]) {
                    char moveChar = ' ';
                    int index = j - key;
                    if (index < 0) {
                        moveChar = alphabet[j + (alphabet.length - key)];
                    } else moveChar = alphabet[j - key];
                    decryptFile.append(moveChar);
                }
            }
        }
        return decryptFile.toString();
    }
}
