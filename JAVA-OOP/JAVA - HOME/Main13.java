// CHARACTER EXTRACTION

// SUBSTRING - a part of string is called substring .in other words substring is a subset of string
// public String substring(int startIndex)
// public String substring(int startIndex,int endIndex)



public class Main13 {
   public static void main(String[] args) {
    
    String s = "Indian Cricketer";
    System.out.println(s.substring(6));
    System.out.println(s.substring(0,6));


// USING CHARACTER 

    System.out.println(s.startsWith("In"));
    System.out.println(s.endsWith("r"));


// USING charAt() FUNCTION

    System.out.println(s.charAt(0));
    System.out.println(s.charAt(3));


// USING getChars() METHOD

    char substring[] = new char[9];
    s.getChars(8,9,substring,0);
    System.out.println("Substring extracted from : Indian Cricketer :" + new String(substring));


   } 
}
