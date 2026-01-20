package leetCodeProblems;

public class LongestPalindromicSubstring {
    private String longest = "";
    private int maxLen = 0;
    
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        
        for (int i = 0; i < s.length(); i++) {
            // Check odd length palindromes centered at i
            expandAroundCenter(s, i, i);
            // Check even length palindromes centered between i and i+1
            expandAroundCenter(s, i, i + 1);
        }
        
        return longest;
    }
    
    private void expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Revert last invalid expansion
        left++;
        right--;
        
        int currentLen = right - left + 1;
        if (currentLen > maxLen) {
            maxLen = currentLen;
            longest = s.substring(left, right + 1);
        }
    }
    
    //Few Test cases
    public static void main(String[] args) {
        LongestPalindromicSubstring sol = new LongestPalindromicSubstring();
        
        // Example 1
        System.out.println("Example 1: " + sol.longestPalindrome("babad"));  // "bab" or "aba"
        
        // Example 2
        System.out.println("Example 2: " + sol.longestPalindrome("cbbd"));   // "bb"
        
        // Edge cases
        System.out.println("Single char: " + sol.longestPalindrome("a"));     // "a"
        System.out.println("Empty: " + sol.longestPalindrome(""));            // ""
        System.out.println("All same: " + sol.longestPalindrome("aaa"));      // "aaa"
    }
}
