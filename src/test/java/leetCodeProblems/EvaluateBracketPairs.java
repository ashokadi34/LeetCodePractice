package leetCodeProblems;

import java.util.*;

public class EvaluateBracketPairs {

    public static String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder result = new StringBuilder();
        int i = 0;
        int n = s.length();

        while (i < n) {
            char c = s.charAt(i);
            if (c != '(') {
                result.append(c);
                i++;
            } else {
                int j = i + 1;
                while (j < n && s.charAt(j) != ')') {
                    j++;
                }
                String key = s.substring(i + 1, j);
                String value = map.getOrDefault(key, "?");
                result.append(value);
                i = j + 1;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Example 1
        String s1 = "(name)is(age)yearsold";
        List<List<String>> k1 = List.of(
            List.of("name", "bob"),
            List.of("age", "two")
        );
        System.out.println(evaluate(s1, k1)); // bobistwoyearsold

        // Example 2
        String s2 = "hi(name)";
        List<List<String>> k2 = List.of(
            List.of("a", "b")
        );
        System.out.println(evaluate(s2, k2)); // hi?

        // Example 3
        String s3 = "(a)(a)(a)aaa";
        List<List<String>> k3 = List.of(
            List.of("a", "yes")
        );
        System.out.println(evaluate(s3, k3)); // yesyesyesaaa
    }
}
