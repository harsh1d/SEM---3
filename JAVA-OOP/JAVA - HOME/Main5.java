//  SCOPE OF VARIABLES 

public class Main5 {
    static int var = 10;
    Main5()
    {
        // variable var from outer scope is accessed here
        System.out.println("Variable assessed from outer scope = "+var);
    }

    public static void main(String args []) {

        int var = 25;
        //variable var from current scope is accessed here
        System.out.println("Variable assessed from current scope = "+var);
    }
    
}
