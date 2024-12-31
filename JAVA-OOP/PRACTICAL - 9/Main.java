
// Write a method with following method header. public static intgcd(int num1, int num2) Write a program that prompts the user to enter two integers and compute the gcd of two integers. 
import java.util.Scanner;

public class Main {
    public static int gcd(int num1, int num2) {
        // Implement the GCD calculation logic here
        // Example using the Euclidean Algorithm:
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

    public static void main(String[] args) {
        // GET INPUT FROM USER
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first integer: ");
        int num1 = input.nextInt();
        System.out.print("Enter the second integer: ");
        int num2 = input.nextInt();
        System.out.println("The gcd of " + num1 + " and " + num2 + " is " + gcd(num1, num2));
    }
}