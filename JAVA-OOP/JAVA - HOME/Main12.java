// FINDING STRING LENGTH

// public class Main12{
//     public static void main(String[] args) {
//         String str = "Hello World";
//         int length = str.length();
//         System.out.println("Length of the string is: " + length);
//     }
// }


//method - 2


// public class Main12 {

//     public static void main(String[] args) {
//         char charray[]={'W','E','L','C','O','M','E'};
//         String str = new String(charray);
//         String str1 ="WELCOME";
//         System.out.println("Length of string is : "+str.length());
//         System.out.println("Length of string is : "+str1.length());
//         System.out.println("Length of 'WELCOME' id :"+"WELCOME".length());
//     }
// }


// CONCAT OF STRING
// public class Main12 {

//     public static void main(String[] args) {
        

        // USING CONCAT() METHOD

//         String s = "Hello";                 
//         String str = "java";
//         String str2 = s.concat(str);
//         String str1 = "Hello".concat("JAVA");

//         System.out.println(str2);
//         System.out.println(str1);

//         // USING + OPERATOR
//         String s1 = "RAHUL";
//         String s2 = "DRAVID";
//         String str3 = s1 +s2;
//         String str4 = "RAHUL"+"DRAVID";

//         System.out.println(str3);
//         System.out.println(str4);
//     }
// }




// CHANGE CASE OF STRING ==> UPPER CASE <==> LOWER CASE

public class Main12 {

    public static void main (String[]args){

        String s = "Indian";
        System.out.println(s.toUpperCase()); //INDIAN
        System.out.println(s.toLowerCase());

        System.out.println(s);

    }
}