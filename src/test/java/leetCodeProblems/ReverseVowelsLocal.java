package leetCodeProblems;

import java.util.Scanner;

public class ReverseVowelsLocal {

    // method - two pointer vowel reversal
    public static String reverseVowels(String s) {
        if (s == null || s.length() <= 1) return s;

        String vowels = "aeiouAEIOU";
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;

        while (i < j) {
            // Skip non-vowels from left
            while (i < j && vowels.indexOf(arr[i]) == -1) i++;
            // Skip non-vowels from right  
            while (i < j && vowels.indexOf(arr[j]) == -1) j--;

            // Swap vowels
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Test examples
        System.out.println("=== LeetCode Examples ===");
        test("IceCreAm", "AceCreIm");
        test("leetcode", "leotcede");
        
        // Additional test cases
        System.out.println("\n=== Additional Tests ===");
        test("hello", "holle");
        test("coding", "codign");
        test("aA", "Aa");
        test("bcd", "bcd");
        test("rhythm", "rhythm");
        test("", "");
        test("a", "a");
        
        // Interactive mode
        System.out.println("\n=== Interactive Mode (type 'quit' to exit) ===");
        while (true) {
            System.out.print("Enter string: ");
            String input = sc.nextLine().trim();
            
            if (input.equalsIgnoreCase("quit")) break;
            
            String result = reverseVowels(input);
            System.out.printf("Input:  \"%s\"\nOutput: \"%s\"\n\n", input, result);
        }
        sc.close();
    }
    
    private static void test(String input, String expected) {
        String result = reverseVowels(input);
        System.out.printf("\"%s\" → \"%s\" %s\n", 
            input, result, result.equals(expected) ? "✓ PASS" : "✗ FAIL");
    }
}
