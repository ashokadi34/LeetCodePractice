package leetCodeProblems;

import java.util.*;

public class RemoveInvalidParentheses {

    public static List<String> removeInvalidParentheses(String s) {
        Set<String> result = new HashSet<>();

        int leftRemove = 0, rightRemove = 0;
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                if (balance > 0) {
                    balance--;
                } else {
                    rightRemove++;
                }
            }
        }
        leftRemove = balance;

        backtrack(s, 0, 0, leftRemove, rightRemove, new StringBuilder(), result);
        return new ArrayList<>(result);
    }

    private static void backtrack(String s, int index, int balance,
                                  int leftRemove, int rightRemove,
                                  StringBuilder current, Set<String> result) {
        if (index == s.length()) {
            if (balance == 0 && leftRemove == 0 && rightRemove == 0) {
                result.add(current.toString());
            }
            return;
        }

        char c = s.charAt(index);

        if (c != '(' && c != ')') {
            current.append(c);
            backtrack(s, index + 1, balance, leftRemove, rightRemove, current, result);
            current.deleteCharAt(current.length() - 1);
            return;
        }

        // Remove if allowed
        if (c == '(' && leftRemove > 0) {
            backtrack(s, index + 1, balance, leftRemove - 1, rightRemove, current, result);
        }
        if (c == ')' && rightRemove > 0) {
            backtrack(s, index + 1, balance, leftRemove, rightRemove - 1, current, result);
        }

        // Keep if valid so far
        if (c == '(') {
            current.append('(');
            backtrack(s, index + 1, balance + 1, leftRemove, rightRemove, current, result);
            current.deleteCharAt(current.length() - 1);
        } else if (c == ')' && balance > 0) {
            current.append(')');
            backtrack(s, index + 1, balance - 1, leftRemove, rightRemove, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(removeInvalidParentheses("()())()"));  // ["(())()","()()()"]
        System.out.println(removeInvalidParentheses("(a)())()")); // ["(a())()","(a)()()"]
        System.out.println(removeInvalidParentheses(")("));       // [""]
    }
}
