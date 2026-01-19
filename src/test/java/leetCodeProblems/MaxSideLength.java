package leetCodeProblems;

public class MaxSideLength {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        
        // Build 2D prefix sum array (1-indexed)
        int[][] prefix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        
        // Binary search on side length
        int left = 0, right = Math.min(m, n);
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (canFit(prefix, m, n, mid, threshold)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        
        // Verify if left works, else 0
        return canFit(prefix, m, n, left, threshold) ? left : 0;
    }
    
    private boolean canFit(int[][] prefix, int m, int n, int k, int threshold) {
        if (k == 0) return true;
        for (int i = 1; i <= m - k + 1; i++) {
            for (int j = 1; j <= n - k + 1; j++) {
                int sum = prefix[i + k - 1][j + k - 1] - prefix[i - 1][j + k - 1] 
                        - prefix[i + k - 1][j - 1] + prefix[i - 1][j - 1];
                if (sum <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        MaxSideLength sol = new MaxSideLength();
        
        // Example 1
        int[][] mat1 = {{1,1,3,2,4,3,2},{1,1,3,2,4,3,2},{1,1,3,2,4,3,2}};
        System.out.println("Example 1: " + sol.maxSideLength(mat1, 4));  // 2
        
        // Example 2
        int[][] mat2 = {{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2}};
        System.out.println("Example 2: " + sol.maxSideLength(mat2, 1));  // 0
    }
}
