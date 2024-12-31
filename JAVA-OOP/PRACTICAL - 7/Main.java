package PRACTICAL - 7;

// Assume a vehicle plate number consists of three uppercase letters followed by four digits. Write a program to generate a plate number. using random function. 
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Generate a random plate number
        String plateNumber = generatePlateNumber();

        // Display the generated plate number
        System.out.println("Generated Plate Number: " + plateNumber);
    }

    public static String generatePlateNumber() {
        Random random = new Random();
        StringBuilder plateNumber = new StringBuilder();

        // Generate three random uppercase letters
        for (int i = 0; i < 3; i++) {
            char letter = (char) (random.nextInt(26) + 'A');
            plateNumber.append(letter);
        }

        // Generate four random digits
        for (int i = 0; i < 4; i++) {
            int digit = random.nextInt(10);
            plateNumber.append(digit);
        }

        return plateNumber.toString();
    }
}
