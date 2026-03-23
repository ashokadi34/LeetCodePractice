package leetCodeProblems;

import java.util.*;

public class GrayCode {

    static class Solution {
        public List<Integer> grayCode(int n) {
            List<Integer> result = new ArrayList<>();
            int total = 1 << n; // 2^n

            for (int i = 0; i < total; i++) {
                result.add(i ^ (i >> 1));
            }

            return result;
        }
    }

    // Utility to print list nicely
    public static void printList(List<Integer> list) {
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1: n = 2 → [0, 1, 3, 2]
        List<Integer> res1 = sol.grayCode(2);
        System.out.print("n = 2: ");
        printList(res1);

        // Example 2: n = 1 → [0, 1]
        List<Integer> res2 = sol.grayCode(1);
        System.out.print("n = 1: ");
        printList(res2);

        // n = 3 (optional, larger sequence)
        List<Integer> res3 = sol.grayCode(3);
        System.out.print("n = 3: ");
        printList(res3);
    }
}

