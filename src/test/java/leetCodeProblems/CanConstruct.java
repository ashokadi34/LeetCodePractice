package leetCodeProblems;

public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        
        int[] freq = new int[26];
        for (char c : magazine.toCharArray()) {
            freq[c - 'a']++;
        }
        
        for (char c : ransomNote.toCharArray()) {
            freq[c - 'a']--;
            if (freq[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
    
    // ==================== LOCAL TESTS ====================
    // main method
    public static void main(String[] args) {
        CanConstruct sol = new CanConstruct();
        
        // Example 1
        System.out.println(sol.canConstruct("a", "b"));     // false
        
        // Example 2
        System.out.println(sol.canConstruct("aa", "ab"));   // false
        
        // Example 3
        System.out.println(sol.canConstruct("aa", "aab"));  // true
        
        // Edge cases
        System.out.println(sol.canConstruct("", "abc"));    // true (empty note)
        System.out.println(sol.canConstruct("abc", "a"));   // false (longer note)
    }
}
