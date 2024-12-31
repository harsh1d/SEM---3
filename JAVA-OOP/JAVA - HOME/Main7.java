// Primitive to wrapper class

public class Main7 {

    public static void main(String[] args) {
        
        // converting int to integer
        int a = 20;
        Integer i = Integer.valueOf(a);
        Integer j = a; // autoboxing , now compiler will write Integer.valueOf(a) internally
        System.out.println(a + " " + i + " " + j);
    }
    
}
