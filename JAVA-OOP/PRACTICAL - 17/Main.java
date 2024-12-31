package PRACTICAL - 17;

public class Main {
    // Class representing a student with roll number and name
class Student {
    protected int roll_no;
    protected String name;

    // Default constructor
    public Student() {
        roll_no = 0;
        name = null;
    }

    // Parameterized constructor
    public Student(int rno, String n) {
        roll_no = rno;
        name = n;
    }

    // Method to set student information
    void getStudent(int rno, String n) {
        roll_no = rno;
        name = n;
    }

    // Method to display student information
    void showStudent() {
        System.out.println("Roll No: " + roll_no);
        System.out.println("Name: " + name);
    }
}

// Class representing marks of a student, inheriting from Student
class Marks extends Student {
    int marks_1, marks_2;

    // Default constructor
    public Marks() {
        super();
        marks_1 = marks_2 = 0;
    }

    // Parameterized constructor
    Marks(int rno, String n, int m1, int m2) {
        super(rno, n);
        marks_1 = m1;
        marks_2 = m2;
    }

    // Method to set marks data
    void getMarksData(int m1, int m2) {
        marks_1 = m1;
        marks_2 = m2;
    }

    // Method to display marks data
    void showMarksData() {
        System.out.println("Marks 1: " + marks_1);
        System.out.println("Marks 2: " + marks_2);
    }
}

// Interface for sports attributes
interface Sports {
    float grace_marks = 6.0f; // Constant grace marks

    // Method to show grace marks
    public void showGraceMarks();
}

// Class representing the result of the student, inheriting from Marks and implementing Sports
class Result extends Marks implements Sports {
    float total_score;

    // Default constructor
    public Result() {
        super();
        total_score = 0;
    }

    // Parameterized constructor
    public Result(int rno, String n, int m1, int m2) {
        super(rno, n, m1, m2);
    }

    // Implementing method from Sports interface
    public void showGraceMarks() {
        System.out.println("\nGrace Marks: " + grace_marks);
    }

    // Method to display the total score
    void showResult() {
        total_score = marks_1 + marks_2 + grace_marks;
        System.out.println("\nTotal Score: " + total_score);
    }
}

// Main class to run the program
class Main {
    public static void main(String[] args) {
        // Create an instance of Result
        Result r = new Result(1, "Raj", 10, 20);

        // Show student details
        r.showStudent();

        // Show marks data
        r.showMarksData();

        // Show grace marks
        r.showGraceMarks();

        // Show the total result
        r.showResult();
    }
}
}
