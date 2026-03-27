package leetCodeProblems;

public class DecodeWays {

    static class Solution {
        public int numDecodings(String s) {
            int n = s.length();
            if (n == 0 || s.charAt(0) == '0') return 0;

            // dp[i] = number of ways to decode s[0...i-1]
            int prev2 = 1;   // dp[0] (empty prefix)
            int prev1 = 1;   // dp[1] (prefix of length 1)

            for (int i = 1; i < n; i++) {
                int curr = 0;

                // Single‑digit decode: s[i]
                if (s.charAt(i) != '0') {
                    curr = prev1;
                }

                // Two‑digit decode: s[i-1] + s[i]
                int two = Integer.parseInt(s.substring(i - 1, i + 1));
                if (i >= 1 && s.charAt(i - 1) != '0' && two >= 10 && two <= 26) {
                    curr += prev2;
                }

                if (curr == 0) return 0; // invalid at this point

                prev2 = prev1;
                prev1 = curr;
            }

            return prev1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1: s = "12" → 2
        String s1 = "12";
        int res1 = sol.numDecodings(s1);
        System.out.println("Input: \"" + s1 + "\" → Output: " + res1);

        // Example 2: s = "226" → 3
        String s2 = "226";
        int res2 = sol.numDecodings(s2);
        System.out.println("Input: \"" + s2 + "\" → Output: " + res2);

        // Example 3: s = "06" → 0
        String s3 = "06";
        int res3 = sol.numDecodings(s3);
        System.out.println("Input: \"" + s3 + "\" → Output: " + res3);

        // Edge: invalid in the middle (e.g., "30")
        String s4 = "30";
        int res4 = sol.numDecodings(s4);
        System.out.println("Input: \"" + s4 + "\" → Output: " + res4);
    }
}