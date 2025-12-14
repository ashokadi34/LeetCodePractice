package leetCodeProblems;

import java.util.Scanner;

public class UglyNumberLocal {

    public static boolean isUgly(int n) {
        if (n <= 0) return false; // ugly numbers are positive only

        int[] primes = {2, 3, 5};
        for (int p : primes) {
            while (n % p == 0) {
                n /= p;
            }
        }
        return n == 1;
    }

    public static void main(String[] args) {
        // LeetCode examples
        System.out.println("Example 1: n = 6 -> " + isUgly(6));   // true
        System.out.println("Example 2: n = 1 -> " + isUgly(1));   // true
        System.out.println("Example 3: n = 14 -> " + isUgly(14)); // false

        // Extra tests
        int[] tests = {0, -1, 8, 10, 25, 30, 7, 11, 100};
        System.out.println("\nExtra tests:");
        for (int n : tests) {
            System.out.println("isUgly(" + n + ") = " + isUgly(n));
        }

        // Interactive mode
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter integers to test isUgly (type 'quit' to exit):");
        while (true) {
            String line = sc.nextLine().trim();
            if (line.equalsIgnoreCase("quit")) break;
            try {
                int n = Integer.parseInt(line);
                System.out.println("isUgly(" + n + ") = " + isUgly(n));
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer or 'quit'.");
            }
        }
        sc.close();
    }
}

