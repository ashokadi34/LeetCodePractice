package leetCodeProblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class IntersectionOfTwoArraysLocal {

    // method - HashSet based unique intersection
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int x : nums1) {
            set1.add(x);
        }

        Set<Integer> inter = new HashSet<>();
        for (int y : nums2) {
            if (set1.contains(y)) {
                inter.add(y);
            }
        }

        int[] ans = new int[inter.size()];
        int i = 0;
        for (int val : inter) {
            ans[i++] = val;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // examples
        System.out.println("=== Examples ===");
        test(new int[]{1,2,2,1}, new int[]{2,2});
        test(new int[]{4,9,5}, new int[]{9,4,9,8,4});

        // Additional tests
        System.out.println("\n=== Additional Tests ===");
        test(new int[]{1,2,3}, new int[]{4,5,6});
        test(new int[]{1,1,1}, new int[]{1,1});
        test(new int[]{}, new int[]{1,2});
        test(new int[]{0,1,2}, new int[]{0,2,4,2});

        // Interactive mode
        System.out.println("\n=== Interactive Mode (type 'quit' to exit) ===");
        while (true) {
            System.out.print("Enter nums1 (space-separated ints or 'quit'): ");
            String line1 = sc.nextLine().trim();
            if (line1.equalsIgnoreCase("quit")) break;

            System.out.print("Enter nums2 (space-separated ints): ");
            String line2 = sc.nextLine().trim();

            int[] nums1 = parseArray(line1);
            int[] nums2 = parseArray(line2);

            int[] res = intersection(nums1, nums2);
            System.out.println("nums1: " + Arrays.toString(nums1));
            System.out.println("nums2: " + Arrays.toString(nums2));
            System.out.println("intersection: " + Arrays.toString(res) + "\n");
        }
        sc.close();
    }

    private static void test(int[] nums1, int[] nums2) {
        int[] res = intersection(nums1, nums2);
        System.out.printf("nums1=%s, nums2=%s → intersection=%s\n",
                Arrays.toString(nums1),
                Arrays.toString(nums2),
                Arrays.toString(res));
    }

    private static int[] parseArray(String line) {
        if (line.isEmpty()) return new int[0];
        String[] parts = line.split("\\s+");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
        return arr;
    }
}
