package PRACTICAL - 10;

import java.util.Scanner;
public class Main
{
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter ten numbers: ");
    int[] numbers = new int[10];
    for (int i = 0; i < 10; i++) {
      numbers[i] = input.nextInt();
    }
    System.out.println("The numbers in reverse order are: ");
    for (int i = 9; i >= 0; i--) {
      System.out.println(numbers[i]);
    }
  }
}
