package PRACTICAL - 13;

public class Main {
    // Define the Point class
class Point {
    // Attributes (data members)
    private int x;  // x-coordinate
    private int y;  // y-coordinate

    // Constructor to initialize the point
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Method to set the x-coordinate
    public void setX(int x) {
        this.x = x;
    }

    // Method to get the x-coordinate
    public int getX() {
        return x;
    }

    // Method to set the y-coordinate
    public void setY(int y) {
        this.y = y;
    }

    // Method to get the y-coordinate
    public int getY() {
        return y;
    }

    // Method to display the coordinates of the point
    public void display() {
        System.out.println("Point coordinates: (" + x + ", " + y + ")");
    }

    // Method to add two points and return a new Point object
    public Point add(Point other) {
        int newX = this.x + other.x;
        int newY = this.y + other.y;
        return new Point(newX, newY);
    }
}

// Main class to demonstrate the Point class
public class Main {
    public static void main(String[] args) {
        // Create two objects of the Point class
        Point point1 = new Point(3, 4);  // Initialized at (3, 4)
        Point point2 = new Point(5, 6);  // Initialized at (5, 6)

        // Display the initial coordinates of both points
        System.out.println("Initial Coordinates:");
        point1.display();
        point2.display();

        // Add the two points
        Point pointSum = point1.add(point2);

        // Display the sum of the coordinates
        System.out.println("Sum of points:");
        pointSum.display();

        // Modify the coordinates of point1
        point1.setX(10);
        point1.setY(15);

        // Display the modified coordinates of point1
        System.out.println("After modification P1:");
        point1.display();

        // Again add the modified point1 with point2
        pointSum = point1.add(point2);

        // Display the new sum after modification
        System.out.println("New sum after modifying point1:");
        pointSum.display();
    }
}
}
