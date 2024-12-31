// ARRAY 

// 1-D ARRAY

// public class Main11 {
//     public static void main(String[] args) {
//         double marks[] = {90,40,50,60,80};
//         double sum = 0;
//         for (int i=0;i<5;i++)
//         {
//             sum = sum + marks[i];
//         }
//         System.out.println("Total marks : "+ sum);
//         System.out.println("Percentage :" + sum/5);
//     }
// }


// 2-D ARRAY

// public class Main11 {
//     public static void main(String[] args) 
//     {
//         int two [][] = new int [2][3];
//         two[0][0] = 1;
//         two[0][1] = 2;
//         two[0][2] = 3;
//         two[1][0] = 4;
//         two[1][1] = 5;
//         two[1][2] = 6;
//         System.out.println(two[0][0]+" "+two[0][1]+" "+two[0][2]);
//         System.out.println(two[1][0]+" "+two[1][1]+" "+two[1][2]);
//     }
// }

// Non - rectangular array 
/**
 * Main11
 */
public class Main11 {

    public static void main(String[] args) {
        int arr[][] = new int[5][];
        arr[0]=new int[1];
        arr[1]=new int[2];
        arr[2]=new int[3];
        arr[3]=new int[4];
        arr[4]=new int[5];
        for (int i=0;i<=4;i++)
        {
            for (int j = 0; j< i+1; j++ )
            {
                arr[i][j]= j+1;
                System.out.println(arr[i][j]);
            }
            System.out.println(" ");
        }
    }
}