package leetCodeProblems;

import java.util.Arrays;
import java.util.Scanner;

public class CountNegativesLocal {

    // method - O(m+n) staircase from top-right
    public static int countNegatives(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;

        int i = 0;        // row
        int j = n - 1;    // column (top-right corner)
        int count = 0;

        while (i < m && j >= 0) {
            if (grid[i][j] < 0) {
                // all elements below in this column are negative
                count += (m - i);
                j--;     // move left
            } else {
                i++;     // move down
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Test examples
        System.out.println("=== LeetCode Examples ===");
        int[][] ex1 = {
            {4,3,2,-1},
            {3,2,1,-1},
            {1,1,-1,-2},
            {-1,-1,-2,-3}
        };
        test(ex1, 8);
        
        int[][] ex2 = {{3,2},{1,0}};
        test(ex2, 0);
        
        // Additional test cases
        System.out.println("\n=== Additional Tests ===");
        test(new int[][]{{1,0,-1}}, 1);
        test(new int[][]{{-1,-1,-1}}, 3);
        test(new int[][]{{5}}, 0);
        test(new int[][]{{-5}}, 1);
        test(new int[][]{}, 0);
        
        // Interactive mode
        System.out.println("\n=== Interactive Mode (type 'quit' to exit) ===");
        while (true) {
            System.out.print("Enter matrix (rows cols then values, e.g. '2 3 4 3 2 -1 3 2 1 -1' or 'quit'): ");
            String input = sc.nextLine().trim();
            
            if (input.equalsIgnoreCase("quit")) break;
            
            String[] parts = input.split("\\s+");
            if (parts.length < 2) {
                System.out.println("Invalid input. Need at least 'rows cols'\n");
                continue;
            }
            
            try {
                int m = Integer.parseInt(parts[0]);
                int n = Integer.parseInt(parts[1]);
                if (m * n != parts.length - 2) {
                    System.out.println("Matrix size mismatch!\n");
                    continue;
                }
                
                int[][] grid = new int[m][n];
                int idx = 2;
                for (int r = 0; r < m; r++) {
                    for (int c = 0; c < n; c++) {
                        grid[r][c] = Integer.parseInt(parts[idx++]);
                    }
                }
                
                int result = countNegatives(grid);
                System.out.printf("Matrix:\n%s\nNegatives: %d\n\n", Arrays.deepToString(grid), result);
                
            } catch (Exception e) {
                System.out.println("Invalid input format. Use integers only.\n");
            }
        }
        sc.close();
    }
    
    private static void test(int[][] grid, int expected) {
        int result = countNegatives(grid);
        System.out.printf("Matrix: %s → %d %s\n", 
            Arrays.deepToString(grid), result, 
            result == expected ? "✓ PASS" : "✗ FAIL");
    }
}
