//AUTOBOXING :- Automatically conversion of primitive type to the object of there corresponding wrapper class
// is known as autoboxing .For example - conversion of int to integer , long to Long , double to Double

import java.util.ArrayList;;
public class Main6 {

    public static void main(String[] args) {
        
        char ch = 'a';

        // Autoboxing :- primitive to character object conversion 
        Character a = ch;

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        // Autoboxing because ArrayList stores only object 

        arrayList.add(25);
        //printing the values from object

        System.out.println(arrayList.get(0));
    }
    
}
