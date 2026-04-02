package leetCodeProblems;

public class MaximumAmountOfMoneyRobotCanEarn {

    static class Solution {
        public int maximumAmount(int[][] coins) {
            int m = coins.length;
            int n = coins[0].length;

            // dp[i][j][k] = max coins at (i, j) with k neutralizations remaining (0, 1, 2)
            int[][][] dp = new int[m][n][3];

            // start at (0,0): just the coin value
            for (int k = 0; k <= 2; k++) {
                dp[0][0][k] = coins[0][0];
            }

            // first row
            for (int j = 1; j < n; j++) {
                int gain = coins[0][j];
                for (int k = 0; k <= 2; k++) {
                    if (gain >= 0) {
                        dp[0][j][k] = dp[0][j - 1][k] + gain;
                    } else {
                        dp[0][j][k] = dp[0][j - 1][k] + gain; // without neutralizing
                        if (k > 0) {
                            dp[0][j][k] = Math.max(dp[0][j][k], dp[0][j - 1][k - 1]);
                        }
                    }
                }
            }

            // first column
            for (int i = 1; i < m; i++) {
                int gain = coins[i][0];
                for (int k = 0; k <= 2; k++) {
                    if (gain >= 0) {
                        dp[i][0][k] = dp[i - 1][0][k] + gain;
                    } else {
                        dp[i][0][k] = dp[i - 1][0][k] + gain;
                        if (k > 0) {
                            dp[i][0][k] = Math.max(dp[i][0][k], dp[i - 1][0][k - 1]);
                        }
                    }
                }
            }

            // inner grid
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    int gain = coins[i][j];
                    if (gain >= 0) {
                        for (int k = 0; k <= 2; k++) {
                            dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i][j - 1][k]) + gain;
                        }
                    } else {
                        for (int k = 0; k <= 2; k++) {
                            int fromTop = dp[i - 1][j][k] + gain;
                            int fromLeft = dp[i][j - 1][k] + gain;

                            if (k > 0) {
                                fromTop = Math.max(fromTop, dp[i - 1][j][k - 1]);
                                fromLeft = Math.max(fromLeft, dp[i][j - 1][k - 1]);
                            }

                            dp[i][j][k] = Math.max(fromTop, fromLeft);
                        }
                    }
                }
            }

            // answer = max over 0, 1, 2 neutralizations at bottom-right
            int ans = Integer.MIN_VALUE;
            for (int k = 0; k <= 2; k++) {
                ans = Math.max(ans, dp[m - 1][n - 1][k]);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[][] coins1 = {
            {0, 1, -1},
            {1, -2, 3},
            {2, -3, 4}
        };
        System.out.println("Example 1 → " + sol.maximumAmount(coins1)); // Expected: 8

        // Example 2
        int[][] coins2 = {
            {10, 10, 10},
            {10, 10, 10}
        };
        System.out.println("Example 2 → " + sol.maximumAmount(coins2)); // Expected: 40
    }
}
