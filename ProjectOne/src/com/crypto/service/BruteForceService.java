package com.crypto.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BruteForceService {
    private DecryptService decryptService = new DecryptService();
    StringBuilder dataFromFileEncryptStringBuilder = new StringBuilder();

    public void decrypt(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            int data;
            while ((data = fileReader.read()) != -1) {
                dataFromFileEncryptStringBuilder.append((char) data);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        char[] arrayFromFile = dataFromFileEncryptStringBuilder.toString().toCharArray();
        char lastElement = arrayFromFile[arrayFromFile.length - 1];
        int key = lastElement - '!';
        decryptService.decrypt(file, key);
    }
}