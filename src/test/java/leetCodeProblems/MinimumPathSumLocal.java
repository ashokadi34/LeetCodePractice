package leetCodeProblems;

public class MinimumPathSumLocal {
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Init first row
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        
        // Init first col
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        
        // Fill rest
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        
        return grid[m - 1][n - 1];
    }
    
    // Helper to print grid before/after
    public static void printGrid(String label, int[][] grid) {
        System.out.println(label + ":");
        for (int[] row : grid) {
            for (int cell : row) {
                System.out.printf("%2d ", cell);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    //Test cases
    public static void main(String[] args) {
        // Example 1
        int[][] grid1 = {{1,3,1},{1,5,1},{4,2,1}};
        printGrid("Input 1", grid1);
        int res1 = minPathSum(grid1);
        printGrid("DP Table 1", grid1);
        System.out.println("Min Path Sum: " + res1 + "\n");  // 7
        
        // Example 2
        int[][] grid2 = {{1,2,3},{4,5,6}};
        printGrid("Input 2", grid2);
        int res2 = minPathSum(grid2);
        printGrid("DP Table 2", grid2);
        System.out.println("Min Path Sum: " + res2 + "\n");  // 12
        
        // Edge cases
        int[][] grid3 = {{1}};
        printGrid("1x1", grid3);
        System.out.println("Min Path Sum: " + minPathSum(grid3) + "\n");  // 1
        
        int[][] grid4 = {{1,2},{3,4}};
        printGrid("2x2", grid4);
        System.out.println("Min Path Sum: " + minPathSum(grid4));  // 7
    }
}

