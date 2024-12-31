// // OBJECT ORIENTED PROGRAMMING

// public class Main18 {
    
// // 1. THE New OPERATOR

//     int id; // field or data member or instance variable
//     String name;
//     public static void main(String[] args) {
//         Main18 s1 = new Main18();
//         System.out.println(s1.id);
//         System.out.println(s1.name);

// // 2. CREATING A METHOD
        
//         int a = 11;
//         int b = 6;
//         int c = minFunction(a,b);
//         System.out.println("Minimum value = "+c);

//     }
//     public static int minFunction(int n1,int n2)
//     {
//         int min;
//         if (n1 > n2) 
//         min = n2;    
//         else
//         min = n1;
//         return min;
//     }


// }

/**
 * Main18
 */

// // PASSING Argument to Methods

// public class Main18 {

//     void calc (int x)
//     {
//         int sq = x * x;
//         System.out.println("The Square OF " + x + " is = " + sq + "sq.cms");
//     }
//     public static void main(String[] args) 
//     {
//         Main18 s = new Main18();
//         s.calc(12);
//     }
// }


// write a java code to add two object of Distance class, which stores the distance in feet and inches

// class Distance {
//     int feet;
//     int inches;

//     // Constructor to initialize distance
//     Distance(int feet, int inches) {
//         this.feet = feet;
//         this.inches = inches;
//     }

//     // Method to add two distances
//     Distance add(Distance d) {
//         int totalInches = this.inches + d.inches;
//         int totalFeet = this.feet + d.feet + totalInches / 12;
//         totalInches = totalInches % 12;
//         return new Distance(totalFeet, totalInches);
//     }

//     // Method to display the distance
//     void display() {
//         System.out.println("Feet: " + feet + ", Inches: " + inches);
//     }

//     public static void main(String[] args) {
//         Distance d1 = new Distance(5, 9);
//         Distance d2 = new Distance(4, 11);
//         Distance d3 = d1.add(d2);

//         System.out.print("Distance 1: ");
//         d1.display();
//         System.out.print("Distance 2: ");
//         d2.display();
//         System.out.print("Sum of Distances: ");
//         d3.display();
//     }
// }


public class Main18
{
    public static void main(String[] args) {
        
    System.out.println("Hello");
    }
}