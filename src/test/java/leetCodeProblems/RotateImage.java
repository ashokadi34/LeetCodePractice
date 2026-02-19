package leetCodeProblems;

public class RotateImage {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        // Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    // Helper to print matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //Test cases
    public static void main(String[] args) {
        // Example 1
        int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Example 1 Before:");
        printMatrix(matrix1);
        rotate(matrix1);
        System.out.println("After:");
        printMatrix(matrix1);

        // Example 2
        int[][] matrix2 = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        System.out.println("Example 2 Before:");
        printMatrix(matrix2);
        rotate(matrix2);
        System.out.println("After:");
        printMatrix(matrix2);

        // Single cell
        int[][] matrix3 = {{1}};
        rotate(matrix3);
        System.out.println("Single: ");
        printMatrix(matrix3);
    }
}
