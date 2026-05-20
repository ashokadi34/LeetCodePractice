package leetCodeProblems;

import java.util.Arrays;

public class PrefixCommonArray {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        int[] freq = new int[n + 1];
        int common = 0;

        for (int i = 0; i < n; i++) {
            freq[A[i]]++;
            if (freq[A[i]] == 2) common++;

            freq[B[i]]++;
            if (freq[B[i]] == 2) common++;

            ans[i] = common;
        }

        return ans;
    }

    public static void main(String[] args) {
        PrefixCommonArray sol = new PrefixCommonArray();
        System.out.println(Arrays.toString(sol.findThePrefixCommonArray(
                new int[]{1, 3, 2, 4},
                new int[]{3, 1, 2, 4}
        ))); // [0, 2, 3, 4]

        System.out.println(Arrays.toString(sol.findThePrefixCommonArray(
                new int[]{2, 3, 1},
                new int[]{3, 1, 2}
        ))); // [0, 1, 3]
    }
}
