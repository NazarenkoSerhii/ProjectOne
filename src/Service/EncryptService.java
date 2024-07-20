package Service;

import Alphabets.Alphabets;
import TextTransformer.TextTransformer;
import java.io.*;

public class EncryptService {
    TextTransformer textTransformer = new TextTransformer();
    StringBuilder dataFromEncryptFileBuilder = new StringBuilder();
    Alphabets alphabetsEng = new Alphabets();

    public void encrypt(File file, int key, char[] alphabet) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                dataFromEncryptFileBuilder.append(data);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
        String dataFromFile = dataFromEncryptFileBuilder.toString();
        String encryptText = textTransformer.moveLetterOnRightPositions(key, dataFromFile, alphabetsEng.ALPHABET_ENG);
        String fileName = file.getName() + "[Encrypt]";

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(encryptText);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
