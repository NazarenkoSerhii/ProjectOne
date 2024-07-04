package Service;

import Alphabets.Alphabets;
import TextTransformer.TextTransformer;

import java.io.*;

public class DecryptService {
    TextTransformer textTransformer = new TextTransformer();
    StringBuilder dataFromDecryptFileBuilder = new StringBuilder();
    Alphabets alphabetsEng = new Alphabets();

    public void decrypt(File file, int key, char[] alphabet) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                dataFromDecryptFileBuilder.append(data);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        String dataFromFile = dataFromDecryptFileBuilder.toString();
        String decryptText = textTransformer.moveLetterOnLeftPositions(key, dataFromFile, alphabetsEng.ALPHABET_ENG);
        String fileName = file.getName().replaceAll("\\[.*?\\]", "") + "[Decrypt]";

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(decryptText);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
