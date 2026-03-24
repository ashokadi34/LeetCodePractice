package leetCodeProblems;

public class ConstructProductMatrix {

    static class Solution {
        public int[][] constructProductMatrix(int[][] grid) {
            final int MOD = 12345;
            int rows = grid.length;
            int cols = grid[0].length;

            int[][] result = new int[rows][cols];

            // First pass: suffix product (bottom-right → top-left)
            long suffix = 1;
            for (int i = rows - 1; i >= 0; i--) {
                for (int j = cols - 1; j >= 0; j--) {
                    result[i][j] = (int) suffix;
                    suffix = (suffix * grid[i][j]) % MOD;
                }
            }

            // Second pass: prefix product (top-left → bottom-right)
            long prefix = 1;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    result[i][j] = (int) ((prefix * result[i][j]) % MOD);
                    prefix = (prefix * grid[i][j]) % MOD;
                }
            }

            return result;
        }
    }

    // Utility to print a 2D matrix
    public static void printMatrix(int[][] mat) {
        System.out.print("[");
        for (int i = 0; i < mat.length; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print("[");
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j]);
                if (j < mat[i].length - 1) System.out.print(", ");
            }
            System.out.print("]");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1: grid = [[1,2],[3,4]]
        int[][] grid1 = {{1, 2}, {3, 4}};
        int[][] result1 = sol.constructProductMatrix(grid1);
        System.out.print("Example 1 input:  [[1,2],[3,4]]\n");
        System.out.print("Output:           ");
        printMatrix(result1);
        // Expected: [[24,12],[8,6]]

        // Example 2: grid = [[12345],[2],[1]]
        int[][] grid2 = {{12345}, {2}, {1}};
        int[][] result2 = sol.constructProductMatrix(grid2);
        System.out.print("\nExample 2 input:  [[12345],[2],[1]]\n");
        System.out.print("Output:           ");
        printMatrix(result2);
        // Expected: [[2],[0],[0]]
    }
}
