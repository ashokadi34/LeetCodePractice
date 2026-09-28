package leetCodeProblems;

import java.util.*;

public class ReverseParentheses {

    public static String reverseParentheses(String s) {
        int n = s.length();
        int[] match = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        // Precompute matching parentheses
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                int j = stack.pop();
                match[i] = j;
                match[j] = i;
            }
        }

        StringBuilder result = new StringBuilder();
        int i = 0;
        int dir = 1; // 1 for right, -1 for left

        while (i < n) {
            char c = s.charAt(i);
            if (c == '(' || c == ')') {
                i = match[i];
                dir = -dir;
                i += dir;
            } else {
                result.append(c);
                i += dir;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseParentheses("(abcd)"));          // dcba
        System.out.println(reverseParentheses("(u(love)i)"));      // iloveu
        System.out.println(reverseParentheses("(ed(et(oc))el)"));  // leetcode
    }
}
