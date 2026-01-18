package leetCodeProblems;

public class LargestMagicSquare {
    private int[][] rowPrefix;
    private int[][] colPrefix;
    
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Build prefix sums (1-indexed)
        rowPrefix = new int[m + 1][n + 1];
        colPrefix = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                rowPrefix[i][j] = rowPrefix[i][j - 1] + grid[i - 1][j - 1];
                colPrefix[i][j] = colPrefix[i - 1][j] + grid[i - 1][j - 1];
            }
        }
        
        // Try from largest size down
        for (int k = Math.min(m, n); k > 1; k--) {
            for (int i = 0; i <= m - k; i++) {
                for (int j = 0; j <= n - k; j++) {
                    int i2 = i + k - 1;
                    int j2 = j + k - 1;
                    if (isMagic(grid, i, j, i2, j2)) {
                        return k;
                    }
                }
            }
        }
        return 1;
    }
    
    private boolean isMagic(int[][] grid, int top, int left, int bottom, int right) {
        // Target sum from first row
        int target = rowPrefix[top + 1][right + 1] - rowPrefix[top + 1][left];
        
        // Check rows
        for (int r = top + 1; r <= bottom; r++) {
            int sum = rowPrefix[r + 1][right + 1] - rowPrefix[r + 1][left];
            if (sum != target) return false;
        }
        
        // Check columns
        for (int c = left; c <= right; c++) {
            int sum = colPrefix[bottom + 1][c + 1] - colPrefix[top][c + 1];
            if (sum != target) return false;
        }
        
        // Main diagonal
        int diag1 = 0;
        for (int k = 0; k <= right - left; k++) {
            diag1 += grid[top + k][left + k];
        }
        if (diag1 != target) return false;
        
        // Anti-diagonal
        int diag2 = 0;
        for (int k = 0; k <= right - left; k++) {
            diag2 += grid[top + k][right - k];
        }
        if (diag2 != target) return false;
        
        return true;
    }
    
    //Test cases
    public static void main(String[] args) {
        LargestMagicSquare sol = new LargestMagicSquare();
        
        // Example 1
        int[][] grid1 = {{7,1,4,5,6},{2,5,1,6,4},{1,5,4,3,2},{1,2,7,3,4}};
        System.out.println("Example 1: " + sol.largestMagicSquare(grid1));  // 3
        
        // Example 2
        int[][] grid2 = {{5,1,3,1},{9,3,3,1},{1,3,3,8}};
        System.out.println("Example 2: " + sol.largestMagicSquare(grid2));  // 2
    }
}

