package leetCodeProblems;

import java.util.Scanner;

public class PowerOfThreeLocal {

    // method - constant time O(1)
    public static boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
    
    // Alternative: iterative division (also educational)
    public static boolean isPowerOfThreeIterative(int n) {
        if (n <= 0) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        // examples
        System.out.println("Examples:");
        System.out.println("27  -> " + isPowerOfThree(27));     // true
        System.out.println("0   -> " + isPowerOfThree(0));      // false
        System.out.println("-1  -> " + isPowerOfThree(-1));     // false
        
        // More test cases
        System.out.println("\nAdditional tests:");
        System.out.println("1   -> " + isPowerOfThree(1));      // true (3^0)
        System.out.println("3   -> " + isPowerOfThree(3));      // true
        System.out.println("9   -> " + isPowerOfThree(9));      // true
        System.out.println("81  -> " + isPowerOfThree(81));     // true
        System.out.println("243 -> " + isPowerOfThree(243));    // true
        
        System.out.println("\nNegative tests:");
        System.out.println("2   -> " + isPowerOfThree(2));      // false
        System.out.println("4   -> " + isPowerOfThree(4));      // false
        System.out.println("10  -> " + isPowerOfThree(10));     // false
        
        // Interactive mode
        Scanner sc = new Scanner(System.in);
        System.out.println("\nInteractive mode (type 'q' to quit):");
        while (true) {
            System.out.print("Enter n: ");
            if (!sc.hasNextInt()) break;
            int n = sc.nextInt();
            boolean res1 = isPowerOfThree(n);
            boolean res2 = isPowerOfThreeIterative(n);
            System.out.println("isPowerOfThree(" + n + ") = " + res1 + 
                             " (iterative: " + res2 + ")");
        }
        sc.close();
    }
}

