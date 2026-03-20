package leetCodeProblems;

import java.util.*;

public class MinAbsDiffLocal {
    static class Solution {
        public int[][] minAbsDiff(int[][] grid, int k) {
        	int m = grid.length;
            int n = grid[0].length;
            int[][] result = new int[m - k + 1][n - k + 1];
            
            for (int i = 0; i <= m - k; i++) {
                for (int j = 0; j <= n - k; j++) {
                    List<Integer> vals = new ArrayList<>();
                    // Collect all values in the k x k subgrid
                    for (int r = i; r < i + k; r++) {
                        for (int c = j; c < j + k; c++) {
                            vals.add(grid[r][c]);
                        }
                    }
                    Collections.sort(vals);
                    int minDiff = Integer.MAX_VALUE;
                    // Find minimum difference between consecutive distinct values
                    for (int p = 1; p < vals.size(); p++) {
                        int diff = vals.get(p) - vals.get(p - 1);
                        if (diff > 0) { // Skip zero (duplicate values)
                            minDiff = Math.min(minDiff, diff);
                        }
                    }
                    result[i][j] = (minDiff == Integer.MAX_VALUE) ? 0 : minDiff;
                }
            }
            return result;
        }
    }

    //Test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test 1: [[1,8],[3,-2]], k=2 → [[2]]
        int[][] grid1 = {{1,8},{3,-2}};
        int[][] ans1 = sol.minAbsDiff(grid1, 2);
        System.out.println("Test1: [[" + ans1[0][0] + "]]");

        // Test 2: [[3,-1]], k=1 → [[0,0]]
        int[][] grid2 = {{3,-1}};
        int[][] ans2 = sol.minAbsDiff(grid2, 1);
        System.out.print("Test2: [[");
        for (int x : ans2[0]) System.out.print(x + ",");
        System.out.println("]]");

        // Test 3: [[1,-2,3],[2,3,5]], k=2 → [[1,2]]
        int[][] grid3 = {{1,-2,3},{2,3,5}};
        int[][] ans3 = sol.minAbsDiff(grid3, 2);
        System.out.print("Test3: [[");
        for (int x : ans3[0]) System.out.print(x + ",");
        System.out.println("]]");
    }
}
