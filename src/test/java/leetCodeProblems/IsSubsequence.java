package leetCodeProblems;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        for (char c : t.toCharArray()) {
            if (i < s.length() && s.charAt(i) == c) {
                i++;
            }
        }
        return i == s.length();
    }

    // Local testing in Eclipse
    public static void main(String[] args) {
        IsSubsequence sol = new IsSubsequence();

        // Example 1
        System.out.println(sol.isSubsequence("abc", "ahbgdc"));  // true

        // Example 2
        System.out.println(sol.isSubsequence("axc", "ahbgdc"));  // false

        // Edge cases
        System.out.println(sol.isSubsequence("", "abc"));        // true
        System.out.println(sol.isSubsequence("abc", ""));        // false
        System.out.println(sol.isSubsequence("a", "a"));         // true
        System.out.println(sol.isSubsequence("ab", "ahbgdc"));   // true
    }
}

