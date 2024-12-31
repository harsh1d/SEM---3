package PRACTICAL - 14;

public class Main {
    // Define the Complex class
class Complex {
    // Attributes for real and imaginary parts
    private int real;  // real part as an integer
    private int imag;  // imaginary part as an integer

    // Constructor to initialize a complex number
    public Complex(int real, int imag) {
        this.real = real;
        this.imag = imag;
    }

    // Method to add two complex numbers
    public Complex add(Complex other) {
        int newReal = this.real + other.real;
        int newImag = this.imag + other.imag;
        return new Complex(newReal, newImag);
    }

    // Method to subtract two complex numbers
    public Complex subtract(Complex other) {
        int newReal = this.real - other.real;
        int newImag = this.imag - other.imag;
        return new Complex(newReal, newImag);
    }

    // Method to multiply two complex numbers
    public Complex multiply(Complex other) {
        int newReal = this.real * other.real - this.imag * other.imag;
        int newImag = this.real * other.imag + this.imag * other.real;
        return new Complex(newReal, newImag);
    }

    // Method to divide two complex numbers
    public Complex divide(Complex other) {
        double denominator = other.real * other.real + other.imag * other.imag;
        int newReal = (int)((this.real * other.real + this.imag * other.imag) / denominator);
        int newImag = (int)((this.imag * other.real - this.real * other.imag) / denominator);
        return new Complex(newReal, newImag);
    }

    // Method to display the complex number
    public void display() {
        if (imag >= 0) {
            System.out.println(real + " + " + imag + "i");
        } else {
            System.out.println(real + " - " + Math.abs(imag) + "i");
        }
    }
}

// Main class to demonstrate the Complex class functionality
public class Main {
    public static void main(String[] args) {
        // Creating complex number objects
        Complex num1 = new Complex(2, 4);  // First complex number (2 + 4i)
        Complex num2 = new Complex(1, 2);  // Second complex number (1 + 2i)

        // Displaying the complex numbers
        System.out.println("First Complex Number: ");
        num1.display();

        System.out.println("Second Complex Number: ");
        num2.display();

        // Performing addition
        Complex sum = num1.add(num2);
        System.out.println("Sum: ");
        sum.display();

        // Performing subtraction
        Complex difference = num1.subtract(num2);
        System.out.println("Difference: ");
        difference.display();

        // Performing multiplication
        Complex product = num1.multiply(num2);
        System.out.println("Product: ");
        product.display();

        // Performing division
        Complex quotient = num1.divide(num2);
        System.out.println("Quotient: ");
        quotient.display();
    }
}
}
