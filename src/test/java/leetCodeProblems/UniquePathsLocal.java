package leetCodeProblems;

import java.util.Arrays;

public class UniquePathsLocal {
    public static int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
    
    public static void main(String[] args) {
        // Example 1
        System.out.println("m=3, n=7: " + uniquePaths(3, 7));  // 28
        
        // Example 2
        System.out.println("m=3, n=2: " + uniquePaths(3, 2));  // 3
        
        // Additional tests
        System.out.println("m=1, n=1: " + uniquePaths(1, 1));  // 1
        System.out.println("m=1, n=5: " + uniquePaths(1, 5));  // 1
        System.out.println("m=5, n=1: " + uniquePaths(5, 1));  // 1
        System.out.println("m=7, n=3: " + uniquePaths(7, 3));  // 28
        System.out.println("m=10, n=10: " + uniquePaths(10, 10));  // 48620
    }
}
