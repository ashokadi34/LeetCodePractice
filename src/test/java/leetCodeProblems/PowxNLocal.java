package leetCodeProblems;

public class PowxNLocal {
    public static class Solution {
        public double myPow(double x, int n) {
            if (n == 0) return 1.0;
            long exp = n;
            if (exp < 0) {
                exp = -exp;
                x = 1 / x;
            }
            double res = 1.0;
            double base = x;
            while (exp > 0) {
                if (exp % 2 == 1) {
                    res *= base;
                }
                base *= base;
                exp /= 2;
            }
            return res;
        }
    }

    //Test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1: x = 2.0, n = 10 → 1024.0
        System.out.printf("Example 1 (2^10): %.5f%n", sol.myPow(2.0, 10));

        // Example 2: x = 2.1, n = 3 → 9.261
        System.out.printf("Example 2 (2.1^3): %.5f%n", sol.myPow(2.1, 3));

        // Example 3: x = 2.0, n = -2 → 0.25000
        System.out.printf("Example 3 (2^-2): %.5f%n", sol.myPow(2.0, -2));

        // Additional: Edge cases
        System.out.printf("n=0: %.5f%n", sol.myPow(5.0, 0));      // 1.0
        System.out.printf("x=0, n>0: %.5f%n", sol.myPow(0.0, 5));  // 0.0
        System.out.printf("INT_MIN: %.5f%n", sol.myPow(2.0, Integer.MIN_VALUE));  // Handles overflow
        System.out.printf("-INT_MIN: %.5f%n", sol.myPow(2.0, Integer.MIN_VALUE / -2));  // Negative even
    }
}

