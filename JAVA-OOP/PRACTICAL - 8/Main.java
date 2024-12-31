package PRACTICAL - 8;
// Write a program that reads an integer and displays all its smallest factors in increasing order. For example if input number is 120, the output should be as follows:2,2,2,3,5. 
import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);{
            System.out.print("Enter a number: ");
            int number = input.nextInt();
            int i = 2;
            while (i <= number) {
                if (number % i == 0) {
                    System.out.print(i + " ");
                    number /= i;
                } else {
                    i++;
                }
            }
        }
    }
}