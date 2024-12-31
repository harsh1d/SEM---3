// LOOP FLOW CONTROL 

public class Main17 {
    public static void main(String[] args) {
        
// 1. The While Statement

        int i = 0;
        while (i < 5) 
        {
            System.out.println("Value of i is = "+ i);
            i ++;    
        }

// 2. Do...While Loops

        int j = 0;
        do 
        {
            System.out.println("Value of j is = "+ j);
            j ++;
        } while (j < 5);

// 3. For Loop Construct

        for (int k = 0; k < 5; k++)
        {
            System.out.println("Value of k is = "+ k);
        }

// 4. Exiting Loop [BREAK]

        for (int l = 0; l < 5; l++)
        {
            if (l == 2)
            {
                break;
            }
            System.out.println("Value of l is = "+ l);
        }

// 5. Continue Statement

        int[] numbers = {10,20,30,40,50};
        for (int m : numbers)
        {
            if (m == 30 ) 
            {
                continue;    
            }
            System.out.println(m);
            System.out.println("\n");
        }
    }
}
