package leetCodeProblems;

import java.util.Arrays;

public class SpiralMatrixIILocal {
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int rStart = 0, rEnd = n - 1;
        int cStart = 0, cEnd = n - 1;
        
        while (rStart <= rEnd && cStart <= cEnd) {
            // Right
            for (int k = cStart; k <= cEnd; k++) {
                matrix[rStart][k] = num++;
            }
            rStart++;
            
            // Down
            for (int k = rStart; k <= rEnd; k++) {
                matrix[k][cEnd] = num++;
            }
            cEnd--;
            
            if (rStart <= rEnd) {
                // Left
                for (int k = cEnd; k >= cStart; k--) {
                    matrix[rEnd][k] = num++;
                }
                rEnd--;
            }
            
            if (cStart <= cEnd) {
                // Up
                for (int k = rEnd; k >= rStart; k--) {
                    matrix[k][cStart] = num++;
                }
                cStart++;
            }
        }
        return matrix;
    }
    
    // Helper to print matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
    
    //Test cases
    public static void main(String[] args) {
        // Example 1: n=3
        int[][] result1 = generateMatrix(3);
        System.out.println("Example 1 (n=3):");
        printMatrix(result1);
        // Expected: [[1,2,3],[8,9,4],[7,6,5]]
        
        // Example 2: n=1
        int[][] result2 = generateMatrix(1);
        System.out.println("Example 2 (n=1):");
        printMatrix(result2);
        // Expected: [[1]]
        
        // Additional: n=4
        int[][] result3 = generateMatrix(4);
        System.out.println("n=4:");
        printMatrix(result3);
        // Expected spiral 1-16
    }
}

