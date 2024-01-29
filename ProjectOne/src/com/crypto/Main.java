package com.crypto;

import com.crypto.service.BruteForceService;
import com.crypto.service.DecryptService;
import com.crypto.service.EncryptService;

import java.io.File;

import static com.crypto.util.InputValidation.*;

public class Main {
    private static final int COMMAND_ARGUMENT_POSITION = 0;
    private static final int FILE_PATH_ARGUMENT_POSITION = 1;
    private static final int KEY_ARGUMENT_POSITION = 2;

    public static void main(String[] args) {
        EncryptService encryptService = new EncryptService();
        DecryptService decryptService = new DecryptService();
        BruteForceService bruteForceService = new BruteForceService();

        validateInput(args);
        validateCommand(args[COMMAND_ARGUMENT_POSITION]);
        validateFilePath(args[FILE_PATH_ARGUMENT_POSITION]);
        validateKey(args[KEY_ARGUMENT_POSITION]);

        if (args[COMMAND_ARGUMENT_POSITION].equals("ENCRYPT")) {
            encryptService.encrypt(new File(args[FILE_PATH_ARGUMENT_POSITION]), KEY_ARGUMENT_POSITION);
        }
        else if (args[COMMAND_ARGUMENT_POSITION].equals("DECRYPT")) {
            decryptService.decrypt(new File(args[FILE_PATH_ARGUMENT_POSITION]), KEY_ARGUMENT_POSITION);
        }
        else if ((args[COMMAND_ARGUMENT_POSITION].equals("BRUTE_FORCE"))) {
            bruteForceService.decrypt(new File(args[FILE_PATH_ARGUMENT_POSITION]));
        }
    }
}
