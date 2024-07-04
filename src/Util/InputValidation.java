package Util;

import Exceptions.InvalidArgumentException;

import java.nio.file.Files;
import java.nio.file.Path;

public class InputValidation {

    public  boolean validateFilePath(String path) {
        boolean result = true;
        if (path.isBlank()) {
            System.out.println("Filename is empty!");
            return result;
        }
        if (!Files.exists(Path.of(path))) {
            System.out.println("File not found!");
            return result;
        } else return false;
    }

    public  boolean validateCommand(int command) {
        boolean result = true;
        if (command > 3 || command <= 0) {
            System.out.println("Wrong command! Try again ");
            return result;
        }else return false;
    }
    public  boolean validateKey(int key) {
        boolean result = true;
        if (key<0) {
            System.out.println("Wrong key! Try again ");
            return result;
        }else return false;
    }
}
