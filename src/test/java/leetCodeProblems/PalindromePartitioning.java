package leetCodeProblems;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(String s, int start, List<String> current, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            String substring = s.substring(start, end + 1);
            if (isPalindrome(substring)) {
                current.add(substring);
                backtrack(s, end + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    // Main method for local testing
    public static void main(String[] args) {
        PalindromePartitioning sol = new PalindromePartitioning();
        System.out.println(sol.partition("aab")); // [[a, a, b], [aa, b]]
        System.out.println(sol.partition("a"));   // [[a]]
    }
}
