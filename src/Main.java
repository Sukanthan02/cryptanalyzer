import java.util.Scanner;
import java.nio.file.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("WELCOME TO CRYPTANALYZER");
        try (Scanner scanner = new Scanner(System.in)) {
            String filePath = null;
            boolean validFilePath = false;

            while (!validFilePath) {
                System.out.println("Enter the file path to execute the technique:");
                filePath = scanner.nextLine();

                // Check if the file exists before proceeding
                if (Files.exists(Paths.get(filePath))) {
                    validFilePath = true;
                } else {
                    System.out.println("File not found. Please provide a valid file path.");
                }
            }

            boolean exitRequested = false;

            while (!exitRequested) {
                System.out.println("Choose the technique: \n1. Encrypt\n2. Decrypt\n3. Brute Force\n4. Exit");
                int choice;

                // Exception handling for invalid inputs
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid choice (1-4).");
                    scanner.nextLine(); // Consume the invalid input
                    continue;
                }

                switch (choice) {

                    case 1:
                        System.out.println("You selected Encryption. Enter your encryption key:");
                        int encryptionKey;
                        try {
                            encryptionKey = scanner.nextInt();
                            scanner.nextLine(); // Consume the newline character
                            if (encryptionKey < 1 || encryptionKey > 100) {
                                System.out.println("Encryption key should be between 1 and 100.");
                                continue;
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input for the encryption key. Please enter a valid integer.");
                            scanner.nextLine(); // Consume the invalid input
                            continue;
                        }
                        Techniques.encrypt(filePath, encryptionKey);
                        break;


                    case 2:
                        System.out.println("You selected Decryption. Enter your decryption key:");
                        int decryptionKey;
                        try {
                            decryptionKey = scanner.nextInt();
                            scanner.nextLine(); // Consume the newline character
                            if (decryptionKey < 1 || decryptionKey > 100) {
                                System.out.println("Decryption key should be between 1 and 100.");
                                continue;
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input for the decryption key. Please enter a valid integer.");
                            scanner.nextLine(); // Consume the invalid input
                            continue;
                        }
                        Techniques.decrypt(filePath, decryptionKey);
                        break;
                    case 3:
                        System.out.println("You selected Brute Force.");
                        Techniques.bruteForce(filePath);
                        break;
                    case 4:
                        System.out.println("Thanking for using CRYTO ANALYZER");
                        exitRequested = true;
                        break;
                    default:
                        System.out.println("You have selected an invalid choice.");
                }
            }
        }
    }
}
