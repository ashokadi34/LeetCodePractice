package leetCodeProblems;

public class FirstUniqChar {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        
        // 1st pass: count frequency
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq[c - 'a']++;
        }
        
        // 2nd pass: find first index with freq 1
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (freq[c - 'a'] == 1) {
                return i;
            }
        }
        
        return -1;
    }
    
    // Local testing
    public static void main(String[] args) {
        FirstUniqChar sol = new FirstUniqChar();
        System.out.println(sol.firstUniqChar("leetcode"));      // 0
        System.out.println(sol.firstUniqChar("loveleetcode"));  // 2
        System.out.println(sol.firstUniqChar("aabb"));          // -1
    }
}

