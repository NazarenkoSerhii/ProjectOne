package com.crypto.util;

import com.crypto.model.Mode;
import exception.InvalidArgumentException;

import java.nio.file.Files;
import java.nio.file.Path;

public class InputValidation {
    public static void validateInput(String[] args) {
        if (args.length < 2) {
            throw new InvalidArgumentException("Command and File are required!");
        }
        if (args.length > 3) {
            throw new InvalidArgumentException("More than 3 arguments");
        }
    }

    public static void validateCommand(String command) {
        boolean isCommandExist = false;
        for (Mode mode : Mode.values()) {
            if (mode.toString().equals(command)) {
                isCommandExist = true;
                break;
            }
        }
        if (!isCommandExist) {
            throw new InvalidArgumentException("Command is not exist!");
        }
    }

    public static void validateFilePath(String path) {
        if (path.isBlank()) {
            throw new InvalidArgumentException("Filename is empty!");
        }
        if (!Files.exists(Path.of(path))) {
            throw new InvalidArgumentException("File not found!");
        }
    }

    public static void validateKey(String key) {
        int k = Integer.parseInt(key);
        if (k > 20 | k < 0) {
            throw new InvalidArgumentException("Error! Enter another key...");
        }
    }
}
