package leetCodeProblems;

import java.util.Scanner;

public class LexPalindromicPermutation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.next();
        String target = scanner.next();

        String answer = lexPalindromicPermutation(s, target);

        System.out.println(answer);

        scanner.close();
    }

    public static String lexPalindromicPermutation(String s, String target) {
        int n = s.length();

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // A string has a palindromic permutation only if at most one
        // character has an odd frequency.
        int oddCount = 0;
        char middle = '\0';

        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1) {
                oddCount++;
                middle = (char) ('a' + i);
            }
        }

        if (oddCount > 1) {
            return "";
        }

        // Every palindrome is determined by its left half.
        int[] halfFreq = new int[26];

        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }

        int halfLength = n / 2;
        String targetHalf = target.substring(0, halfLength);

        /*
         * If targetHalf is exactly a valid half permutation, construct
         * its palindrome and check if it is already strictly greater.
         */
        if (isExactHalfPermutation(targetHalf, halfFreq)) {
            String palindrome = buildPalindrome(targetHalf, middle);

            if (palindrome.compareTo(target) > 0) {
                return palindrome;
            }
        }

        /*
         * Otherwise, find the lexicographically smallest valid half
         * permutation strictly greater than targetHalf.
         */
        String nextHalf = smallestPermutationGreaterThan(targetHalf, halfFreq);

        if (nextHalf == null) {
            return "";
        }

        return buildPalindrome(nextHalf, middle);
    }

    private static boolean isExactHalfPermutation(String half, int[] halfFreq) {
        int[] count = new int[26];

        for (char ch : half.toCharArray()) {
            count[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != halfFreq[i]) {
                return false;
            }
        }

        return true;
    }

    /*
     * Returns the smallest string that:
     * - uses exactly the characters in supply
     * - is lexicographically greater than bound
     *
     * Returns null if it does not exist.
     */
    private static String smallestPermutationGreaterThan(String bound, int[] supply) {
        int m = bound.length();

        /*
         * prefix[i][c] = count of character c in bound[0...i-1].
         */
        int[][] prefix = new int[m + 1][26];

        for (int i = 0; i < m; i++) {
            System.arraycopy(prefix[i], 0, prefix[i + 1], 0, 26);
            prefix[i + 1][bound.charAt(i) - 'a']++;
        }

        /*
         * Work from right to left.
         *
         * Keep bound[0...i-1] unchanged, replace bound[i] with the
         * smallest available character greater than it, then append
         * all remaining characters in sorted order.
         */
        for (int i = m - 1; i >= 0; i--) {
            int[] remaining = new int[26];
            boolean validPrefix = true;

            for (int c = 0; c < 26; c++) {
                if (prefix[i][c] > supply[c]) {
                    validPrefix = false;
                    break;
                }

                remaining[c] = supply[c] - prefix[i][c];
            }

            if (!validPrefix) {
                continue;
            }

            int currentChar = bound.charAt(i) - 'a';

            for (int nextChar = currentChar + 1; nextChar < 26; nextChar++) {
                if (remaining[nextChar] == 0) {
                    continue;
                }

                StringBuilder result = new StringBuilder(m);

                // Preserve the equal prefix.
                result.append(bound, 0, i);

                // First differing character: must be greater.
                result.append((char) ('a' + nextChar));
                remaining[nextChar]--;

                // Append the smallest possible suffix.
                for (int c = 0; c < 26; c++) {
                    while (remaining[c] > 0) {
                        result.append((char) ('a' + c));
                        remaining[c]--;
                    }
                }

                return result.toString();
            }
        }

        return null;
    }

    private static String buildPalindrome(String half, char middle) {
        StringBuilder result = new StringBuilder();

        result.append(half);

        if (middle != '\0') {
            result.append(middle);
        }

        for (int i = half.length() - 1; i >= 0; i--) {
            result.append(half.charAt(i));
        }

        return result.toString();
    }
}
