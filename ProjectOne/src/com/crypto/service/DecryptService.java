package com.crypto.service;

import com.crypto.transformer.TextTransformer;

import java.io.File;

public class DecryptService {
    private TextTransformer textTransformer = new TextTransformer();

    public void decrypt(File file, int key) {
        //Read data from File
        // pass data to textTransformer.moveLetterOnLeftPositions(key, data)
        //add method

    }
}
