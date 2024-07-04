package RunService;

import Alphabets.Alphabets;
import Service.BruteForceService;
import Service.DecryptService;
import Service.EncryptService;
import Util.InputValidation;
import java.io.File;
import java.util.Scanner;

public class Run {
    public void run() {
        DecryptService decryptService = new DecryptService();
        EncryptService encryptService = new EncryptService();
        BruteForceService bruteForceService = new BruteForceService();
        Alphabets alphabetsEng = new Alphabets();
        InputValidation inputValidation = new InputValidation();
        Scanner scanner = new Scanner(System.in);

        int command = 0;
        int key = 0;
        String filePath;
        while (true) {
            System.out.println("Input command:\n [1] - Decrypt; [2] - Encrypt; [3] - Brute Force");
            if (scanner.hasNextInt()) {
                command = scanner.nextInt();
                if (inputValidation.validateCommand(command)) {
                    scanner.nextLine();
                } else break;
            } else System.out.println("Error!");
            scanner.nextLine();
        }
        scanner.nextLine();

        while (true) {
            System.out.println("Input file path ");
            if (scanner.hasNextLine()) {
                filePath = scanner.nextLine();
                if (inputValidation.validateFilePath(filePath)) {
                } else break;
            } else System.out.println("Error!");
        }
        if (command < 3) {
            while (true) {
                System.out.println("Input key");
                if (scanner.hasNextInt()) {
                    key = scanner.nextInt();
                    if (inputValidation.validateKey(key)) {
                        scanner.nextLine();
                    } else break;
                } else System.out.println("Error!");
                scanner.nextLine();
            }
        } scanner.close();

        switch (command) {
            case 1:
                decryptService.decrypt(new File(filePath), key, alphabetsEng.ALPHABET_ENG);
                break;
            case 2:
                encryptService.encrypt(new File(filePath), key, alphabetsEng.ALPHABET_ENG);
                break;
            case 3:
                bruteForceService.bruteForce(new File(filePath));
                break;
        }
    }
}




