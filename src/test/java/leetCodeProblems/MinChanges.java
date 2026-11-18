package leetCodeProblems;

public class MinChanges {

    public static int minChanges(String s) {
        int changes = 0;

        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                changes++;
            }
        }

        return changes;
    }

    public static void main(String[] args) {
        String s1 = "1001";
        System.out.println(minChanges(s1)); // Output: 2

        String s2 = "10";
        System.out.println(minChanges(s2)); // Output: 1

        String s3 = "0000";
        System.out.println(minChanges(s3)); // Output: 0
    }
}