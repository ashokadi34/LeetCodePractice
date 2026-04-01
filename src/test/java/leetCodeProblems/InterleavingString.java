package leetCodeProblems;

public class InterleavingString {

	//isInterleave
    static class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            int m = s1.length(), n = s2.length();

            if (m + n != s3.length()) {
                return false;
            }

            // 1D dp: dp[j] = can we form s3[0..i+j) using s1[0..i) and s2[0..j)?
            boolean[] dp = new boolean[n + 1];

            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i == 0 && j == 0) {
                        dp[j] = true;
                    } else if (i == 0) {
                        dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
                    } else if (j == 0) {
                        dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i - 1);
                    } else {
                        int k = i + j - 1;
                        boolean useS1 = dp[j] && s1.charAt(i - 1) == s3.charAt(k);
                        boolean useS2 = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(k);
                        dp[j] = useS1 || useS2;
                    }
                }
            }

            return dp[n];
        }
    }

    //Test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        String s1_1 = "aabcc";
        String s2_1 = "dbbca";
        String s3_1 = "aadbbcbcac";
        System.out.println("s1 = \"" + s1_1 + "\", s2 = \"" + s2_1
            + "\", s3 = \"" + s3_1 + "\" → " + sol.isInterleave(s1_1, s2_1, s3_1));
        // Expected: true

        // Example 2
        String s1_2 = "aabcc";
        String s2_2 = "dbbca";
        String s3_2 = "aadbbbaccc";
        System.out.println("s1 = \"" + s1_2 + "\", s2 = \"" + s2_2
            + "\", s3 = \"" + s3_2 + "\" → " + sol.isInterleave(s1_2, s2_2, s3_2));
        // Expected: false

        // Example 3
        String s1_3 = "";
        String s2_3 = "";
        String s3_3 = "";
        System.out.println("s1 = \"" + s1_3 + "\", s2 = \"" + s2_3
            + "\", s3 = \"" + s3_3 + "\" → " + sol.isInterleave(s1_3, s2_3, s3_3));
        // Expected: true
    }
}
