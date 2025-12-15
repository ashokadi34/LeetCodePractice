package leetCodeProblems;

import java.util.Scanner;

public class MissingNumberLocal {

    // solution using XOR
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int missing = n; // start with n
        for (int i = 0; i < n; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    // Helper function: parse space-separated ints from a line
    private static int[] parseArray(String line) {
        if (line.trim().isEmpty()) return new int[0];
        String[] parts = line.trim().split("\\s+");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        // LeetCode examples
        int[] a1 = {3, 0, 1};
        int[] a2 = {0, 1};
        int[] a3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};

        System.out.println("Example 1: [3,0,1] -> " + missingNumber(a1)); // 2
        System.out.println("Example 2: [0,1] -> " + missingNumber(a2));   // 2
        System.out.println("Example 3: [9,6,4,2,3,5,7,0,1] -> " + missingNumber(a3)); // 8

        // Interactive mode
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter array elements (0..n) separated by spaces, or 'quit' to exit:");
        while (true) {
            String line = sc.nextLine().trim();
            if (line.equalsIgnoreCase("quit")) break;
            try {
                int[] arr = parseArray(line);
                System.out.println("Missing number = " + missingNumber(arr));
            } catch (NumberFormatException e) {
                System.out.println("Please enter integers separated by spaces or 'quit'.");
            }
        }
        sc.close();
    }
}

