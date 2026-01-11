package leetCodeProblems;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] count = new int[52];  // 26 lowercase + 26 uppercase
        
        for (char c : s.toCharArray()) {
            if (c >= 'a') {
                count[c - 'a']++;
            } else {
                count[26 + c - 'A']++;
            }
        }
        
        int ans = 0;
        for (int freq : count) {
            ans += freq / 2 * 2;  // even counts
        }
        return ans == s.length() ? ans : ans + 1;  // at most one odd
    }

    // Test methods
    public static void main(String[] args) {
        LongestPalindrome sol = new LongestPalindrome();
        
        System.out.println(sol.longestPalindrome("abccccdd"));  // 7
        System.out.println(sol.longestPalindrome("a"));         // 1
        System.out.println(sol.longestPalindrome("Aa"));        // 1 (case sensitive)
        System.out.println(sol.longestPalindrome("bb"));        // 2
        System.out.println(sol.longestPalindrome("abc"));       // 1
    }
}

