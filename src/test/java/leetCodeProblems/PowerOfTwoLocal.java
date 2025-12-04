package leetCodeProblems;

import java.util.Scanner;

public class PowerOfTwoLocal {

    public static boolean isPowerOfTwo(int n) {
        // must be positive and have exactly one set bit
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Quick demo with some sample values
        int[] samples = {1, 2, 3, 4, 16, 18, 0, -2};
        System.out.println("Demo:");
        for (int n : samples) {
            System.out.println(n + " -> " + isPowerOfTwo(n));
        }

        // Interactive testing scan
        System.out.println("\nEnter integers to test (type 'quit' to exit):");
        while (true) {
            String line = sc.nextLine().trim();
            if (line.equalsIgnoreCase("quit")) break;

            try {
                int n = Integer.parseInt(line);
                System.out.println("isPowerOfTwo(" + n + ") = " + isPowerOfTwo(n));
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer or 'quit'.");
            }
        }
        sc.close();
    }
}

