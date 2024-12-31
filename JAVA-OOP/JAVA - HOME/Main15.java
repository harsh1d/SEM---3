// OPERATORS


public class Main15 {
    public static void main(String[] args) {
        

// 1. ARITHMETIC OPERATOR

        int a = 10;
        int b = 5;
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
        System.out.println(a % b);

// USING EXPRESSION
        System.out.println(10*10/5+3-1*4/2);

// USING UNARY OPERATOR
        int x = 10;        System.out.println(x++);
        System.out.println(++x);
        System.out.println(x--);
        System.out.println(--x);
        System.out.println(x++ + ++x);
        System.out.println(x++ + x++);
        System.out.println(x++ + x++ + x++);
        System.out.println(x++ + x++ + x++ + x++);
        System.out.println(x++ + x++ + x++ + x++ + x++);
        System.out.println(x++ + x++ + x++ + x++ + x++ + x++);
        System.out.println(x++ + x++ + x++ + x++ + x++ + x++ + x++);
        System.out.println(x++ + x++ + x++ + x++ + x++ + x++ + x++ + x++);
        System.out.println(x++ + x++ + x++ + x++ + x++ + x++ + x++ + x++ + x++);
        System.out.println(x++ + x++ + x++ + x++ + x++ + x++ + x++ + x++ + x++ + x++);
        System.out.println(x++ + x++ + x++ + x++ + x++ + x++ + x++ + x++ + x++ + x++ + x++);




// 2. BITWISE OPERATOR

        int c = 5;
        int d = 7;
        System.out.println(c & d);
        System.out.println(c | d);
        System.out.println(c ^ d);
        System.out.println(~c);
        System.out.println(c << 2);
        System.out.println(c >> 2);
        System.out.println(c >>> 2);

// 3. lEFT SHIFT OPERATOR

        System.out.println(10 << 2); // 10*2^2 = 10*4 = 40
        System.out.println(10 << 3); // 10*2^3 = 10*8 = 80


// 4. RIGHT SHIFT OPERATOR

        System.out.println(20 >> 2); // 20/2^2 = 20/4 = 5

// 5. UNSIGNED RIGHT SHIFT OPERATOR

        System.out.println(20 >>> 2); // 20/2^2 = 20/4 = 5

// 6. BITWISE NOT OPERATOR

        System.out.println(~10); // -(10+1) = -11

// 7. BITWISE XOR OPERATOR

        System.out.println(15 ^ 27); // 15 XOR 27

// 8. RELATIONAL OPERATOR

    int x1 = 10;
    int y1 = 20;

    System.out.println(x1 == y1); // Equal to
    System.out.println(x1 != y1); // Not equal to
    System.out.println(x1 > y1); // Greater than
    System.out.println(x1 < y1); // Less than
    System.out.println(x1 >= y1); // Greater than or equal to
    System.out.println(x1 <= y1); // Less than or equal to
                    
// 9. LOGICAL OPERATOR

    boolean a1 = true;
    boolean b1 = false;

    System.out.println(a1 && b1); // Logical AND
    System.out.println(a1 || b1); // Logical OR
    System.out.println(!a1); // Logical NOT

// 10. LOGICAL BITWISE OPERATOR 

    System.out.println(a1 & b1); // Bitwise AND
    System.out.println(a1 | b1); // Bitwise OR
    System.out.println(a1 ^ b1); // Bitwise XOR
    // System.out.println(~a1); // Bitwise NOT is not applicable for boolean

    int p = 10;
    int q = 5;
    int r = 20;

    System.out.println(p < q && p < r);
    System.out.println(p < q & p < r);

// LOGICAL BITWISE USING AND OPERATOR

    System.out.println(p < q && p ++ < r);
    System.out.println(p);
    System.out.println(p < q & p ++ < r);
    System.out.println(p);


// LOGICAL BITWISE USING OR OPERATOR

    System.out.println(p < q || p ++ < r);
    System.out.println(p);
    System.out.println(p < q | p ++ < r);
    System.out.println(p);

// 11. TERNARY OPERATOR

    int num = 10;
    int result = (num > 10)? num : 0;
    System.out.println(result);

// 12. ASSIGNMENT OPERATOR

    int a2 = 10;  // Simple assignment
    int b2 = 20;
    a2 += b2;  // a2 = a2 + b2
    System.out.println(a2);

    a2 -= b2;  // a2 = a2 - b2
    System.out.println(a2);

    a2 *= b2;  // a2 = a2 * b2
    System.out.println(a2);

    a2 /= b2;  // a2 = a2 / b2
    System.out.println(a2);

    a2 %= b2;  // a2 = a2 % b2
    System.out.println(a2);

    a2 &= b2;  // a2 = a2 & b2
    System.out.println(a2);

    a2 |= b2;  // a2 = a2 | b2
    System.out.println(a2);

    a2 ^= b2;  // a2 = a2 ^ b2
    System.out.println(a2);

    a2 <<= 2; // a2 = a2 << 2
    System.out.println(a2);

    a2 >>= 2; // a2 = a2 >> 2
    System.out.println(a2);

    a2 >>>= 2; // a2 = a2 >>> 2
    System.out.println(a2);

    int x2 = 10;
    x2 += 5;
    System.out.println(x2);

    x2 -= 5;
    System.out.println(x2);


    

    }    
}
