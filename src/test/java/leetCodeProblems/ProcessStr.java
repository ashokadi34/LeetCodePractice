package leetCodeProblems;

public class ProcessStr {

    public String processStr(String s) {
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                result.append(c);
            } else if (c == '*') {
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                }
            } else if (c == '#') {
                result.append(result.toString());
            } else if (c == '%') {
                result.reverse();
            }
        }

        return result.toString();
    }

    //test cases
    public static void main(String[] args) {
        ProcessStr sol = new ProcessStr();

        String s1 = "a#b%*";
        System.out.println(sol.processStr(s1)); // ba

        String s2 = "z*#";
        System.out.println(sol.processStr(s2)); // ""

        String s3 = "abc";
        System.out.println(sol.processStr(s3)); // abc
    }
}