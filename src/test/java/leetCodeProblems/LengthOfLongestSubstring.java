package leetCodeProblems;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, maxLen = 0;
        boolean[] seen = new boolean[256];  // ASCII characters
        
        while (right < s.length()) {
            while (seen[(int)s.charAt(right)] && left <= right) {
                seen[(int)s.charAt(left)] = false;
                left++;
            }
            seen[(int)s.charAt(right)] = true;
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
    
    //Tests in main method
    public static void main(String[] args) {
        LengthOfLongestSubstring sol = new LengthOfLongestSubstring();
        
        // Example 1
        System.out.println(sol.lengthOfLongestSubstring("abcabcbb"));  // 3
        
        // Example 2  
        System.out.println(sol.lengthOfLongestSubstring("bbbbb"));     // 1
        
        // Example 3
        System.out.println(sol.lengthOfLongestSubstring("pwwkew"));    // 3
        
        // Extra tests
        System.out.println(sol.lengthOfLongestSubstring(""));          // 0 (empty)
        System.out.println(sol.lengthOfLongestSubstring("dvdf"));      // 3 ("vdf")
        System.out.println(sol.lengthOfLongestSubstring("tmmzuxt"));   // 2 ("mm")
    }
}

