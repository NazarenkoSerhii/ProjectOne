package com.crypto.service;

import com.crypto.transformer.TextTransformer;

import java.io.File;

public class EncryptService {
    private TextTransformer textTransformer = new TextTransformer();
    private BruteForceHelper bruteForceHelper = new BruteForceHelper();

    public void encrypt(File file, int key) {
        // read Data from file
        // key 2   a => c;   b => d
        String dataFromFile = "read data from file";
        String encryptedText = textTransformer.moveLetterOnRightPositions(key, dataFromFile);
        // add brute force point
        String fileName = file.getName();
        // create new File, with fileName and save it
        //as result file should be stored in root folder
    }
}
