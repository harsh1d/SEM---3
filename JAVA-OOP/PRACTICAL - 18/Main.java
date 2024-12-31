package PRACTICAL - 18;

public class Main {
    public static void main(String[] args) {
        try {
            int a = 10 / 0;
            System.out.println(a);
            int b[] = {1, 2, 3, 4};
            b[10] = 10;
            String small = "";
            System.out.print("small");
        }
        catch (ArithmeticException e1) {
            System.out.println("Division by zero");
        }
        catch (ArrayIndexOutOfBoundsException e2) {
            System.out.println("Invalid Index");
        }
        catch (NullPointerException e3) {
            System.out.println("Null reference");
        }
        finally {
            System.out.println("Finally block executed");
        }
        System.out.println("Rest of the code");
    }
}
