package leetCodeProblems;

public class ToHex {
    public String toHex(int num) {
        if (num == 0) return "0";
        
        char[] digits = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuilder sb = new StringBuilder();
        
        while (num != 0) {
            sb.append(digits[num & 0xf]);
            num >>>= 4;
        }
        return sb.reverse().toString();
    }

    // test methods
    public static void main(String[] args) {
        ToHex sol = new ToHex();
        
        // Example 1
        System.out.println(sol.toHex(26));     // "1a"
        
        // Example 2
        System.out.println(sol.toHex(-1));     // "ffffffff"
        
        // Additional tests
        System.out.println(sol.toHex(0));      // "0"
        System.out.println(sol.toHex(15));     // "f"
        System.out.println(sol.toHex(-2147483648));  // "80000000" (min int)
    }
}
