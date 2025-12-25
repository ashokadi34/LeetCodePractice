package leetCodeProblems;

import java.util.Scanner;

public class PowerOfFourLocal {

    // method - constant time bit manipulation || method logic 
    public static boolean isPowerOfFour(int n) {
        // must be positive
        if (n <= 0) return false;
        
        // must be power of two: only one bit set
        if ((n & (n - 1)) != 0) return false;
        
        // that single bit must be at even position
        // 0x55555555 = 01010101...0101 (bits 0,2,4,... set)
        return (n & 0x55555555) != 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Test examples
        System.out.println("=== LeetCode Examples ===");
        test(16, true);  // 4^2 = 16
        test(5, false);  
        test(1, true);   // 4^0 = 1
        
        // Test additional cases
        System.out.println("\n=== Additional Tests ===");
        test(4, true);   // 4^1
        test(64, true);  // 4^3
        test(2, false);  // power of 2 but not 4
        test(8, false);  // power of 2 but not 4
        test(0, false);
        test(-16, false);
        
        // Interactive mode
        System.out.println("\n=== Interactive Mode (type 'quit' to exit) ===");
        while (true) {
            System.out.print("Enter integer n: ");
            String input = sc.nextLine().trim();
            
            if (input.equalsIgnoreCase("quit")) break;
            
            try {
                int n = Integer.parseInt(input);
                boolean result = isPowerOfFour(n);
                System.out.printf("isPowerOfFour(%d) = %s\n\n", n, result);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer or 'quit'.");
            }
        }
        sc.close();
    }
    
    private static void test(int n, boolean expected) {
        boolean result = isPowerOfFour(n);
        System.out.printf("n=%d: %s (%s)\n", n, result, 
                         result == expected ? "✓ PASS" : "✗ FAIL");
    }
}
