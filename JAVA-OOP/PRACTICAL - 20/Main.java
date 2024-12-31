import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// package PRACTICAL20;


public class Main {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile)) {

            int byteContent;
            while ((byteContent = fis.read()) != -1) {
                fos.write(byteContent);
            }

            System.out.println("File copied successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
