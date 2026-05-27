package leetCodeProblems;

public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        String doubled = s + s;
        // Remove first and last character to exclude the original s at boundaries
        String inner = doubled.substring(1, doubled.length() - 1);
        return inner.contains(s);
    }

    public static void main(String[] args) {
        RepeatedSubstringPattern sol = new RepeatedSubstringPattern();

        System.out.println(sol.repeatedSubstringPattern("abab"));           // true
        System.out.println(sol.repeatedSubstringPattern("aba"));            // false
        System.out.println(sol.repeatedSubstringPattern("abcabcabcabc"));   // true
    }
}