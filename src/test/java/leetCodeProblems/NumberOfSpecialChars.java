package leetCodeProblems;

public class NumberOfSpecialChars {
    public int numberOfSpecialChars(String word) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];

        for (char c : word.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lower[c - 'a'] = true;
            } else {
                upper[c - 'A'] = true;
            }
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (lower[i] && upper[i]) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        NumberOfSpecialChars sol = new NumberOfSpecialChars();

        System.out.println(sol.numberOfSpecialChars("aaAbcBC")); // 3
        System.out.println(sol.numberOfSpecialChars("abc"));     // 0
        System.out.println(sol.numberOfSpecialChars("abBCab"));  // 1
    }
}
