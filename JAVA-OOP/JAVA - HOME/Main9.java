// Garbage collector gc Method

public class Main9 {
    public static void main(String[] args) 
    {
        Main9 t = new Main9();
        t = null;
        System.gc();
    }
    public void finalize()
    {
        System.out.println("Garbage Collected");
    }
}
