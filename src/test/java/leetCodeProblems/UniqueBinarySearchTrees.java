package leetCodeProblems;

public class UniqueBinarySearchTrees {

    static class Solution {
        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;  // empty tree
            dp[1] = 1;  // single node

            for (int i = 2; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    // j nodes on left, i-j-1 on right
                    dp[i] += dp[j] * dp[i - j - 1];
                }
            }

            return dp[n];
        }
    }

    //Test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1: n = 3 → 5
        int n1 = 3;
        int res1 = sol.numTrees(n1);
        System.out.println("n = " + n1 + " → " + res1);  // Expected: 5

        // Example 2: n = 1 → 1
        int n2 = 1;
        int res2 = sol.numTrees(n2);
        System.out.println("n = " + n2 + " → " + res2);  // Expected: 1

        // Example 3: n = 4 → 14 (Catalan(4))
        int n3 = 4;
        int res3 = sol.numTrees(n3);
        System.out.println("n = " + n3 + " → " + res3);  // Expected: 14
    }
}
