package leetCodeProblems;

import java.util.*;

public class SpiralMatrixLocal {
    public static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();
            if (matrix.length == 0) return result;
            
            int top = 0, bottom = matrix.length - 1;
            int left = 0, right = matrix[0].length - 1;
            
            while (top <= bottom && left <= right) {
                for (int col = left; col <= right; col++) result.add(matrix[top][col]);
                top++;
                for (int row = top; row <= bottom; row++) result.add(matrix[row][right]);
                right--;
                if (top <= bottom) {
                    for (int col = right; col >= left; col--) result.add(matrix[bottom][col]);
                    bottom--;
                }
                if (left <= right) {
                    for (int row = bottom; row >= top; row--) result.add(matrix[row][left]);
                    left++;
                }
            }
            return result;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.print("[");
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i]);
                if (i < row.length - 1) System.out.print(",");
            }
            System.out.println("]");
        }
    }

    public static void printList(List<Integer> list) {
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) System.out.print(",");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Example 1:");
        printMatrix(matrix1);
        printList(sol.spiralOrder(matrix1));  // [1,2,3,6,9,8,7,4,5]

        System.out.println("\nExample 2:");
        int[][] matrix2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        printMatrix(matrix2);
        printList(sol.spiralOrder(matrix2));  // [1,2,3,4,8,12,11,10,9,5,6,7]

        // Edge: Single row
        System.out.println("\nSingle row:");
        int[][] singleRow = {{1,2,3}};
        printMatrix(singleRow);
        printList(sol.spiralOrder(singleRow));  // [1,2,3]

        // Edge: Single column
        System.out.println("\nSingle column:");
        int[][] singleCol = {{1},{2},{3}};
        printMatrix(singleCol);
        printList(sol.spiralOrder(singleCol));  // [1,2,3]

        // Edge: 1x1
        System.out.println("\n1x1:");
        int[][] one = {{5}};
        printMatrix(one);
        printList(sol.spiralOrder(one));  // [5]
    }
}

