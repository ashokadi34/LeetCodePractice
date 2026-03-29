package leetCodeProblems;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

    public static class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> result = new ArrayList<>();
            List<String> segments = new ArrayList<>();

            // Pruning: length too small or too big for 4 segments of 1–3 digits
            if (s.length() < 4 || s.length() > 12) {
                return result;
            }

            backtrack(s, 0, segments, result);
            return result;
        }

        private void backtrack(
            String s,
            int start,
            List<String> segments,
            List<String> result
        ) {
            if (start == s.length() && segments.size() == 4) {
                result.add(String.join(".", segments));
                return;
            }

            if (start >= s.length() || segments.size() >= 4) {
                return;
            }

            int num = 0;
            for (int end = start; end < Math.min(start + 3, s.length()); end++) {
                num = num * 10 + (s.charAt(end) - '0');

                if (num > 255) break;
                if (s.charAt(start) == '0' && start != end) break; // invalid leading zero

                segments.add(s.substring(start, end + 1));
                backtrack(s, end + 1, segments, result);
                segments.remove(segments.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        System.out.println("Example 1:");
        System.out.println(sol.restoreIpAddresses("25525511135"));
        // Expected: ["255.255.11.135", "255.255.111.35"]

        // Example 2
        System.out.println("Example 2:");
        System.out.println(sol.restoreIpAddresses("0000"));
        // Expected: ["0.0.0.0"]

        // Example 3
        System.out.println("Example 3:");
        System.out.println(sol.restoreIpAddresses("101023"));
        // Expected: ["1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3"]
    }
}