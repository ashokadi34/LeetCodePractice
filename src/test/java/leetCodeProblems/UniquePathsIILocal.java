package leetCodeProblems;

public class UniquePathsIILocal {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }
    
    // Helper to print grid
    public static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    //Test cases
    public static void main(String[] args) {
        // Example 1
        int[][] grid1 = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.print("Example 1:\n");
        printGrid(grid1);
        System.out.println("Paths: " + uniquePathsWithObstacles(grid1));  // 2
        
        // Example 2
        int[][] grid2 = {{0,1},{0,0}};
        System.out.print("Example 2:\n");
        printGrid(grid2);
        System.out.println("Paths: " + uniquePathsWithObstacles(grid2));  // 1
        
        // Additional tests
        int[][] grid3 = {{1}};  // Start obstacle
        System.out.print("Start obstacle:\n");
        printGrid(grid3);
        System.out.println("Paths: " + uniquePathsWithObstacles(grid3));  // 0
        
        int[][] grid4 = {{0,0},{1,0}};  // End accessible
        System.out.print("End via detour:\n");
        printGrid(grid4);
        System.out.println("Paths: " + uniquePathsWithObstacles(grid4));  // 1
        
        int[][] grid5 = {{0,1},{1,0}};  // Blocked
        System.out.print("Blocked:\n");
        printGrid(grid5);
        System.out.println("Paths: " + uniquePathsWithObstacles(grid5));  // 0
    }
}
