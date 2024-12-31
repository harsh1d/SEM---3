// STRING COMPARISON

public class Main14 {
    public static void main(String[] args) {
        

// USING equals() METHOD

        String s = "Java";
        String s1 = "Java";
        String s2 = "Java";

//        s1.equals(s2);
//        s.equals(s1);
        
    System.out.println(s1.equals(s2));
    System.out.println(s.equals(s1));



// USING == OPERATOR

//        String s3 = new String("Java");
        
//        test(s1 == s2);
//        test(s1 == s3);

//        System.out.println(test(s1 == s2));
//        System.out.println(test(s1 == s3));



// BY compareTo() METHOD

        String s3 = "Java";

        s1.compareTo(s2);
        s1.compareTo(s3);
        s2.compareTo(s1);




// STRING BUFFER 

        String str = "Self";
        str.concat("Study");
        System.out.println(str);
        StringBuffer strB = new StringBuffer("Self");

        strB.append("Study");
        System.out.println(strB);


    
// IMPORTANT METHOD OF STRING BUFFER 

// 1. append ()

        // StringBufferappend(String str)
        // StringBufferappend(int n)
        // StringBufferappend(Object obj)

// OR

        StringBuffer str5 = new StringBuffer("Test");
        str5.append(123);
        System.out.println(str5);


// 2. insert()

        // StringBufferinsert(int index, String str);
        // StringBufferinsert(int index, int num);
        // StringBufferinsert(int index, Object obj);

// OR

        StringBuffer str6 = new StringBuffer("Test");
        str6.insert(4,123);
        System.err.println(str6);


// 3. reverse()

        StringBuffer str7 = new StringBuffer("Hello");
        str7.reverse();
        System.out.println(str7);


// 4. replace()

        StringBuffer str8 = new StringBuffer("Hello World");
        str8.replace(6,11,"Java");
        System.out.println(str8);

// 5. capacity()

        StringBuffer str9 = new StringBuffer();
        System.out.println(str9.capacity());

// 6. ensureCapacity()

        StringBuffer str4 = new StringBuffer("hello");
        str4.ensureCapacity(10); 

    }
    
}
