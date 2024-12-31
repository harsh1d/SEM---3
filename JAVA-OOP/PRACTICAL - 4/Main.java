
// Body Mass Index (BMI) is a measure of health on weight. It can be calculated by taking your weight in kilograms and dividing by the square of your height in meters. Write a program that prompts the user to enter a  weight in pounds and height in inches and displays the BMI. Note:- 1 pound=.45359237 Kg and 1 inch=.0254 meters. 
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your weight in pounds: ");
        double weight = input.nextDouble();
        System.out.print("Enter your height in inches: ");
        double height = input.nextDouble();
        double kg = weight * 0.45359237;
        double meters = height * 0.0254;
        double bmi = kg / (meters * meters);
        System.out.println("Your BMI is " + bmi);
    }
}