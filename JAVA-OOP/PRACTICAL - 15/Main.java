package PRACTICAL - 15;

public class Main {
    class Publication {
    protected String title;
    protected double price;
    protected int copies;

    Publication(String t, double p, int c) {
        title = t;
        price = p;
        copies = c;
    }

    public void sale() {
        System.out.println("Publication sale: " + (price * copies));
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Price: Rs." + price);
        System.out.println("Copies: " + copies);
    }
}

class Book extends Publication {
    String author;

    Book(String t, double p, int c, String a) {
        super(t, p, c);
        author = a;
    }

    // Change the return type to int
    public int order(int n) {
        copies = copies + n;
        return copies; // Return the updated copies count
    }

    public void sale() {
        System.out.println("Book sale: " + (price * copies));
    }

    public void displayBookInfo() {
        displayInfo();
        System.out.println("Author: " + author);
    }
}

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Java Programming", 180, 450, "xyz");

        System.out.println("Book Details:");
        book1.displayBookInfo();
        book1.sale();
        System.out.println("Book value after order:- ");
        // Print the returned value from order
        System.out.println("New Order : " + book1.order(100)); 
        book1.order(100);
        book1.sale();
    }
}
}
