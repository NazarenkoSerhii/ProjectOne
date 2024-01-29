package com.crypto.service;

import com.crypto.transformer.TextTransformer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DecryptService {
    private TextTransformer textTransformer = new TextTransformer();
    private StringBuilder dataFromDecryptFileBuilder = new StringBuilder();

    public void decrypt(File file, int key) {
        try (FileReader fileReader = new FileReader(file)) {
            int data;
            while ((data = fileReader.read()) != -1) {
                dataFromDecryptFileBuilder.append((char) data);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        String fileName = file.getName() + "[Decrypt]";
        String dataFromFile = dataFromDecryptFileBuilder.toString();
        String decryptedText = textTransformer.moveLetterOnLeftPositions(key, dataFromFile);

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(decryptedText);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}

