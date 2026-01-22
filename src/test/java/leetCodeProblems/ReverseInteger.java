package leetCodeProblems;

public class ReverseInteger {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            
            rev = rev * 10 + pop;
        }
        return rev;
    }
    
    public static void main(String[] args) {
        ReverseInteger sol = new ReverseInteger();
        
        // Example 1: x = 123 → 321
        System.out.println(sol.reverse(123));  // Output: 321
        
        // Example 2: x = -123 → -321
        System.out.println(sol.reverse(-123));  // Output: -321
        
        // Example 3: x = 120 → 21
        System.out.println(sol.reverse(120));  // Output: 21
        
        // Overflow test: x = 2147483647 → 0
        System.out.println(sol.reverse(2147483647));  // Output: 0
        
        // Overflow test: x = -2147483648 → 0
        System.out.println(sol.reverse(-2147483648));  // Output: 0
    }
}

