// CONTROL STATEMENTS

public class Main16 {
    public static void main(String[] args) {
        
        int x = 10;
        int y = 20;
 
// 1. IF STATEMENT

        if(x < 20 )
        {
            System.out.println("This is IF Statement");
        }
// 2. IF..ELSE STATEMENT

    if (x < 20) 
    {
        System.out.println("This is IF Statement");
    }
    else
    {
        System.out.println("This is ELSE Statement ");
    }    

// 3. IF... ELSE IF... ELSE STATEMENT 

    int z = 30;
    if ( z == 10 )
    {
        System.out.println("Value of Z is 10 ");
    }
    else if (z == 20 ) 
    {
        System.out.println("Value of Z is 20");   
    }
    else if (z == 30 ) 
    {
        System.out.println("Value of Z is 30");   
    }
    else 
    {
        System.out.println("This is ELSE Statement ");
    }

        
        
        

        if (x < y) {
            System.out.println("x is less than y");
        } else if (x > y) {
            System.out.println("x is greater than y");
        } else {
            System.out.println("x is equal to y");
        }



// 4. NESTED IF...ELSE STATEMENT

        int a = 30;
        int b = 10;

        if (a == 30) 
        {
            if (b == 10)
            {
            System.out.println("A = 30 and B = 10");
        }
    }



// 5. SWITCH STATEMENT
    
    int day = 3;
    String dayName;
    
    switch (day) {
        case 1:
            dayName = "Sunday";
            break;
        case 2:
            dayName = "Monday";
            break;
        case 3:
            dayName = "Tuesday";
            break;
        case 4:
            dayName = "Wednesday";
            break;
        case 5:
            dayName = "Thursday";
            break;
        case 6:
            dayName = "Friday";
            break;
        case 7:
            dayName = "Saturday";
            break;
        default:
            dayName = "Invalid day";
            break;
    }
    
    System.out.println("Day: " + dayName);



    }
}
