import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompting the user to enter three integers
        System.out.print("Enter the first integer: ");
        int num1 = input.nextInt();
        System.out.print("Enter the second integer: ");
        int num2 = input.nextInt();
        System.out.print("Enter the third integer: ");
        int num3 = input.nextInt();

        // Sorting and displaying the integers in decreasing order
        System.out.print("Decreasing Order = ");
        if (num1 >= num2 && num1 >= num3) {
            if (num2 >= num3) {
                System.out.print(num1 + ", " + num2 + ", " + num3);
            } else {
                System.out.print(num1 + ", " + num3 + ", " + num2);
            }
        } else if (num2 >= num1 && num2 >= num3) {
            if (num1 >= num3) {
                System.out.print(num2 + ", " + num1 + ", " + num3);
            } else {
                System.out.print(num2 + ", " + num3 + ", " + num1);
            }
        } else if (num3 >= num1 && num3 >= num2) {
            if (num1 >= num2) {
                System.out.print(num3 + ", " + num1 + ", " + num2);
            } else {
                System.out.print(num3 + ", " + num2 + ", " + num1);
            }
        }
    }
}
