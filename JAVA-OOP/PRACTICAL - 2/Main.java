package PRACTICAL - 2;

//Write a program that solves the following equation and displays the value x  and y:  1) 3.4x+50.2y=44.5 2) 2.1x+.55y=5.9 (Assume Cramer’s rule to solve  equation 
//ax+by=e x=ed-bf/ad-bc
//cx+dy=f y=af-ec/ad-bc ) 
// Get Input From user
import java.util.Scanner;
public class Main
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // input is the object , System.in means input from keybord and Scanner is the constructor
        System.out.println("Enter the value for Equation 1");
        System.out.println("Enter the value for a: ");
        double a = input.nextDouble();
        System.out.println("Enter the value for b: ");
        double b = input.nextDouble();
        System.out.println("Enter the value for e: ");
        double e = input.nextDouble();
        System.out.println("Enter the value for Equation 2");
        System.out.println("Enter the value for c: ");
        double c = input.nextDouble();
        System.out.println("Enter the value for d: ");
        double d = input.nextDouble();
        System.out.println("Enter the value for f: ");
        double f = input.nextDouble();
        double x = (e*d-b*f)/(a*d-b*c);
        double y = (a*f-e*c)/(a*d-b*c);
        System.out.println("The value of x is: "+x);
        System.out.println("The value of y is: "+y);
    }
}