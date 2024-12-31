// KEYWORDS
 

// 1. USING 'This' KEYWORD
public class Main19 {



    int age;
    
    // Main19(int age) 
    // {
    //     this.age = age;                                         
    // }
    // public static void main(String[] args) {
    //     Main19 t1 = new Main19(38);
    //     System.out.println("Age of t1 is: " + t1.age);
    // }





    // Main19()
    // {
    //     this(20);
    // }
    // Main19(int age)
    // {
    //     this.age = age;
    // }
    // public static void main(String[] args) 

    // {
    //     Main19 t1 = new Main19(38);
    //     Main19 t2 = new Main19();
    //     System.out.println("Age of t1 is: " + t1.age);
    //     System.out.println("Age of t2 is: " + t2.age);
    // }




    // Main19(int age)
    // {
    //     this.age =age;
    // }
    // public void getAge()
    // {
    //     System.out.println("Age = " + age);
    // }
    // public void display()
    // {
    //     this.getAge();
    //     System.out.println();
    // }
    // public static void main(String[] args)
    // {
    //     Main19 t1 = new Main19(38);
    //     System.out.println(t1.age);
    // }
    



// 2. STATIC KEYWORD
 
    static int count = 0;
    Main19()
    {
        count ++;
        System.out.println(count);
    }
    public static void main(String[] args) {
        Main19 c1 = new Main19();
        Main19 c2 = new Main19();
        Main19 c3 = new Main19();
    }



}
