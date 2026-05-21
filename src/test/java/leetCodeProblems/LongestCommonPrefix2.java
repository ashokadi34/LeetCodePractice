package leetCodeProblems;

import java.util.*;

public class LongestCommonPrefix2 {

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr1) {
            while (num > 0) {
                set.add(num);
                num /= 10;
            }
        }

        int ans = 0;

        for (int num : arr2) {
            while (num > 0) {
                if (set.contains(num)) {
                    ans = Math.max(ans, String.valueOf(num).length());
                    break;
                }
                num /= 10;
            }
        }

        return ans;
    }

    // Test cases
    public static void main(String[] args) {
        LongestCommonPrefix2 sol = new LongestCommonPrefix2();

        int[] arr1 = {1, 10, 100};
        int[] arr2 = {1000};
        System.out.println(sol.longestCommonPrefix(arr1, arr2)); // 3

        int[] arr3 = {1, 2, 3};
        int[] arr4 = {4, 4, 4};
        System.out.println(sol.longestCommonPrefix(arr3, arr4)); // 0
    }
}
