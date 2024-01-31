package com.crypto.service;

import com.crypto.transformer.TextTransformer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EncryptService {
    private TextTransformer textTransformer = new TextTransformer();
    private StringBuilder dataFromEncryptFileBuilder = new StringBuilder();

    public void encrypt(File file, int key) {
        try (FileReader fileReader = new FileReader(file)) {
            int data;
            while ((data = fileReader.read()) != -1) {
                dataFromEncryptFileBuilder.append((char) data);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        String dataFromFile = dataFromEncryptFileBuilder.toString();
        String encryptedText = textTransformer.moveLetterOnRightPositions(key, dataFromFile);
        String fileName = file.getName() + "[Encrypt]";

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(encryptedText);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}