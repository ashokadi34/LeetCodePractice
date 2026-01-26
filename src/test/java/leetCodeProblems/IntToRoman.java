package leetCodeProblems;

public class IntToRoman {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                result.append(symbols[i]);
                num -= values[i];
            }
        }
        return result.toString();
    }
    
    //test cases
    public static void main(String[] args) {
        IntToRoman sol = new IntToRoman();
        
        // Example 1: 3749 → MMMDCCXLIX
        System.out.println("3749");
        System.out.println(sol.intToRoman(3749));  // MMMDCCXLIX
        
        // Example 2: 58 → LVIII
        System.out.println("58");
        System.out.println(sol.intToRoman(58));  // LVIII
        
        // Example 3: 1994 → MCMXCIV
        System.out.println("1994");
        System.out.println(sol.intToRoman(1994));  // MCMXCIV
        
        // Additional tests
        System.out.println(sol.intToRoman(3));  // III
        System.out.println(sol.intToRoman(4));  // IV
    }
}
