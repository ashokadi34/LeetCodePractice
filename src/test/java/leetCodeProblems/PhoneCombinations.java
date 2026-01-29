package leetCodeProblems;

import java.util.*;

public class PhoneCombinations {
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(result, digits, 0, new StringBuilder(), mapping);
        return result;
    }
    
    private static void backtrack(List<String> result, String digits, int index, StringBuilder sb, String[] mapping) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        
        String letters = mapping[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            sb.append(c);
            backtrack(result, digits, index + 1, sb, mapping);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));  // [ad, ae, af, bd, be, bf, cd, ce, cf]
        System.out.println(letterCombinations("2"));   // [a, b, c]
        System.out.println(letterCombinations(""));    // []
    }
}

