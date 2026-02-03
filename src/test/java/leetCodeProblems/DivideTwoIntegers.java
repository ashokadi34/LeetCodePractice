package leetCodeProblems;

public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        long absDividend = Math.abs((long)dividend);
        long absDivisor = Math.abs((long)divisor);
        long quotient = 0;
        
        while (absDividend >= absDivisor) {
            long temp = absDivisor, multiple = 1;
            while (absDividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            absDividend -= temp;
            quotient += multiple;
        }
        
        long result = sign * quotient;
        return (int) (result > Integer.MAX_VALUE ? Integer.MAX_VALUE : result);
    }

    //Testcases
    public static void main(String[] args) {
        // Example 1
        System.out.println("10 / 3 = " + divide(10, 3));     // 3

        // Example 2
        System.out.println("7 / -3 = " + divide(7, -3));    // -2

        // Edge cases
        System.out.println("(-2147483648) / (-1) = " + divide(Integer.MIN_VALUE, -1));  // 2147483647
        System.out.println("1 / 1 = " + divide(1, 1));       // 1
        System.out.println("0 / 1 = " + divide(0, 1));       // 0
        System.out.println("-1 / 1 = " + divide(-1, 1));     // -1
    }
}

