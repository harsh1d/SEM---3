// Write a program that prompts the user to enter a letter and check whether a letter is a vowel or constant. using Switch Case
import java.util.Scanner;
public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a letter: ");
    char letter = sc.next().charAt(0);
    switch(letter){
      case 'a':
      case 'e':
      case 'i':
      case 'o':
      case 'u':
      case 'A':
      case 'E':
      case 'I':
      case 'O':
      case 'U':
        System.out.println("The letter is a vowel");
        break;
      default:
        System.out.println("The letter is a constant");
    }
  }
}