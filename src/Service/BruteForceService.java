package Service;

import Alphabets.Alphabets;
import TextTransformer.TextTransformer;
import java.io.*;

public class BruteForceService {

    private int key;

    public int getKey() {
        return key;
    }

    TextTransformer textTransformer = new TextTransformer();
    StringBuilder dataFromFileBuilder = new StringBuilder();
    Alphabets alphabetsEng = new Alphabets();

    public void bruteForce(File file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                dataFromFileBuilder.append(data);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        String dataFromFile = dataFromFileBuilder.toString();
        int spaces = 0;
        for (int i = 0; i < alphabetsEng.ALPHABET_ENG.length; i++) {
            String encryptText = textTransformer.moveLetterOnLeftPositions(i, dataFromFile, alphabetsEng.ALPHABET_ENG);
            char[] encryptTextArray = encryptText.toCharArray();
            int spaceCounter = 0;
            for (int j = 0; j < encryptTextArray.length; j++) {

                if (encryptTextArray[j] == ' ') {
                    spaceCounter++;
                }  if (spaceCounter > spaces) {
                    spaces = spaceCounter;
                    key = i;
                }
            }
        }
        String decryptText = textTransformer.moveLetterOnLeftPositions(key, dataFromFile, alphabetsEng.ALPHABET_ENG);
        String fileName = file.getName().replaceAll("\\[.*?\\]", "") + "[DecryptBruteForce] " + "[Key] " + getKey();

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(decryptText);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}


