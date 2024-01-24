package com.crypto.service;

import java.io.File;

public class BruteForceService {
    private DecryptService decryptService = new DecryptService();

    public void decrypt(File file) {
        //analyse text and get key  ===> key!
        int key = 1;
        decryptService.decrypt(file, key);
    }
}
