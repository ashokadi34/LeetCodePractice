package leetCodeProblems;

import java.util.*;

public class MinOperations {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        int[] arr = new int[total];
        int idx = 0;
        int rem = grid[0][0] % x;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                if (val % x != rem) {
                    return -1;
                }
                arr[idx++] = (val - rem) / x;
            }
        }
        
        Arrays.sort(arr);
        int median = arr[total / 2];
        int ops = 0;
        for (int v : arr) {
            ops += Math.abs(v - median);
        }
        return ops;
    }

    //Test cases
    public static void main(String[] args) {
        MinOperations sol = new MinOperations();

        // Example 1
        int[][] grid1 = {{2,4},{6,8}};
        System.out.println(sol.minOperations(grid1, 2)); // 4

        // Example 2
        int[][] grid2 = {{1,5},{2,3}};
        System.out.println(sol.minOperations(grid2, 1)); // 5

        // Example 3
        int[][] grid3 = {{1,2},{3,4}};
        System.out.println(sol.minOperations(grid3, 2)); // -1
    }
}