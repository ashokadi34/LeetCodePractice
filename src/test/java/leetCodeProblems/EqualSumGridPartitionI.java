package leetCodeProblems;

public class EqualSumGridPartitionI {

    static class Solution {
        public boolean canPartitionGrid(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            // Step 1: compute total sum
            long totalSum = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    totalSum += grid[i][j];
                }
            }
            if (totalSum % 2 != 0) return false;

            long target = totalSum / 2;

            // Step 2: check horizontal cuts (partition between rows)
            long prefixRowSum = 0;
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n; j++) {
                    prefixRowSum += grid[i][j];
                }
                if (prefixRowSum == target) return true;
            }

            // Step 3: check vertical cuts (partition between columns)
            for (int j = 0; j < n - 1; j++) {
                long prefixColSum = 0;
                for (int i = 0; i < m; i++) {
                    prefixColSum += grid[i][j];
                }
                if (prefixColSum == target) return true;
            }

            return false;
        }
    }

    // Utility to build and print 2D matrix (optional, for debugging)
    public static void printGrid(int[][] grid) {
        System.out.print("[");
        for (int i = 0; i < grid.length; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print("[");
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]);
                if (j < grid[i].length - 1) System.out.print(", ");
            }
            System.out.print("]");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1: [[1,4],[2,3]] → true
        int[][] grid1 = {{1, 4}, {2, 3}};
        boolean res1 = sol.canPartitionGrid(grid1);
        System.out.print("Example 1: ");
        printGrid(grid1);
        System.out.println("Result: " + res1); // expected: true

        // Example 2: [[1,3],[2,4]] → false
        int[][] grid2 = {{1, 3}, {2, 4}};
        boolean res2 = sol.canPartitionGrid(grid2);
        System.out.print("Example 2: ");
        printGrid(grid2);
        System.out.println("Result: " + res2); // expected: false
    }
}

