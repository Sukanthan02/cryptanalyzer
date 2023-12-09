import java.io.*;
import java.nio.file.Path;
import java.sql.SQLOutput;

public class Techniques {
    private static final String RESULT_FILE = "C:\\Users\\Admin\\IdeaProjects\\cryptanalyzer\\src\\files\\file2";

    public static void encrypt(String sourceFile, int key) {
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(RESULT_FILE))) {

            int data;
            while ((data = reader.read()) != -1) {
                writer.write((char) (data + key));
            }
            System.out.println("Your text is encrypted. Check in: " + Path.of(RESULT_FILE));
        } catch (IOException e) {
            handleException("Error while encrypting", e);
        }
    }

    public static void decrypt(String sourceFile, int key) {
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(RESULT_FILE))) {

            int data;
            while ((data = reader.read()) != -1) {
                writer.write((char) (data - key)); // Reverse the encryption by subtracting the key
            }
            System.out.println("Your text is decrypted. Check in: " + Path.of(RESULT_FILE));
        } catch (IOException e) {
            handleException("Error while decrypting", e);
        }
    }

    public static void bruteForce(String sourceFile) {
        int maxKey = 100; // Maximum key value to check (you can adjust this)

        for (int key = 1; key <= maxKey; key++) {
            try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile))) {
                StringBuilder decryptedText = new StringBuilder();
                int data;
                while ((data = reader.read()) != -1) {
                    decryptedText.append((char) (data - key));
                }

                // Print the potential decryption for each key
                System.out.println("Key: " + key + ", Decrypted Text: " + decryptedText.toString());
                System.out.println("bruteforce ended, check possible key and text");
            } catch (IOException e) {
                handleException("Error while brute-forcing", e);
            }
        }
    }

    private static void handleException(String message, Exception e) {
        System.out.println(message + ": " + e.getMessage());
    }
}