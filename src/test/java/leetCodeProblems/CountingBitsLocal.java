package leetCodeProblems;

import java.util.Arrays;
import java.util.Scanner;

public class CountingBitsLocal {

    // method - DP with bit manipulation
    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;

        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

    // Helper to print binary representation
    public static String toBinary(int n) {
        return Integer.toBinaryString(n);
    }

    public static void main(String[] args) {
        // LeetCode examples
        System.out.println("LeetCode Example 1 (n=2):");
        int[] res1 = countBits(2);
        System.out.println("Result: " + Arrays.toString(res1));
        System.out.println("Binary: 0=0, 1=1, 2=10");

        System.out.println("\nLeetCode Example 2 (n=5):");
        int[] res2 = countBits(5);
        System.out.println("Result: " + Arrays.toString(res2));
        for (int i = 0; i <= 5; i++) {
            System.out.printf("%d (%s) -> %d\n", i, toBinary(i), res2[i]);
        }

        // Interactive mode
        Scanner sc = new Scanner(System.in);
        System.out.println("\nInteractive mode (type 'q' to quit):");
        while (true) {
            System.out.print("Enter n: ");
            if (!sc.hasNextInt()) break;
            
            int n = sc.nextInt();
            int[] result = countBits(n);
            System.out.println("countBits(" + n + ") = " + Arrays.toString(result));
            
            // Show first 10 with binary
            System.out.print("First 10 with binary: ");
            for (int i = 0; i <= Math.min(9, n); i++) {
                System.out.printf("(%s:%d) ", toBinary(i), result[i]);
            }
            System.out.println();
        }
        sc.close();
    }
}

