package leetCodeProblems;

import java.util.Scanner;

public class AddDigitsLocal {

    // solution using digital root
    public static int addDigits(int num) {
        if (num == 0) return 0;
        return (num - 1) % 9 + 1;
    }

    public static void main(String[] args) {
        // Sample tests 
        System.out.println("Example 1: num = 38");
        System.out.println("Output: " + addDigits(38)); // Expected 2

        System.out.println("Example 2: num = 0");
        System.out.println("Output: " + addDigits(0));  // Expected 0

        // Extra tests
        int[] tests = {1, 5, 9, 10, 11, 99, 9999, 123456};
        System.out.println("\nExtra tests:");
        for (int n : tests) {
            System.out.println("addDigits(" + n + ") = " + addDigits(n));
        }

        // Interactive mode
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter numbers to test addDigits (type 'quit' to exit):");
        while (true) {
            String line = sc.nextLine().trim();
            if (line.equalsIgnoreCase("quit")) break;
            try {
                int n = Integer.parseInt(line);
                System.out.println("addDigits(" + n + ") = " + addDigits(n));
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer or 'quit'.");
            }
        }
        sc.close();
    }
}

