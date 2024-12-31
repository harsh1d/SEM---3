class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[6][6];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 2);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                }
            }
            if (count % 2 != 0) {
                System.out.println("Row " + (i + 1) + " has an odd number of 1's");
            }
            count = 0;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[j][i] == 1) {
                    count++;
                }
            }
            if (count % 2 != 0) {
                System.out.println("Column " + (i + 1) + " has an odd number of 1's");
            }
            count = 0;
        }
    }
}