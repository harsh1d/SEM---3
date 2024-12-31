package PRACTICAL - 3;

// Write a program that reads a number in meters, converts it to feet, and displays the result Input From User
import java.util.Scanner;
public class Main
  {
    public static void main(String[] args)
    {
      Scanner input = new Scanner(System.in);
      System.out.print("Enter a value for meters: ");
      double meters = input.nextDouble();
      double feet = meters * 3.28084;
      System.out.println(meters + " meters is " + feet + " feet");
    }
  }