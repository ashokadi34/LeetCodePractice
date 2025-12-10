package leetCodeProblems;

public class ValidAnagramLocal {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int num : count) {
            if (num != 0) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        // Example 1
        System.out.println(isAnagram("anagram", "nagaram")); // true
        
        // Example 2  
        System.out.println(isAnagram("rat", "car")); // false
        
        // Few of edge cases
        System.out.println(isAnagram("", "")); // true
        System.out.println(isAnagram("a", "a")); // true
        System.out.println(isAnagram("ab", "ba")); // true [memory:21]
    }
}

