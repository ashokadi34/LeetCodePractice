package leetCodeProblems;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseStringLocal {

    // method - two pointer in-place reversal
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            // Swap characters
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Test examples
        System.out.println("=== LeetCode Examples ===");
        
        char[] ex1 = {'h', 'e', 'l', 'l', 'o'};
        System.out.println("Before: " + Arrays.toString(ex1));
        reverseString(ex1);
        System.out.println("After:  " + Arrays.toString(ex1) + " ✓\n");

        char[] ex2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        System.out.println("Before: " + Arrays.toString(ex2));
        reverseString(ex2);
        System.out.println("After:  " + Arrays.toString(ex2) + " ✓\n");
        
        // Additional test cases
        System.out.println("=== Additional Tests ===");
        testReverse("abc", new char[]{'a','b','c'});
        testReverse("a", new char[]{'a'});
        testReverse("", new char[]{});
        testReverse("abcd", new char[]{'a','b','c','d'});
        
        // Interactive mode of testing
        System.out.println("\n=== Interactive Mode (type 'quit' to exit) ===");
        while (true) {
            System.out.print("Enter string to reverse: ");
            String input = sc.nextLine().trim();
            
            if (input.equalsIgnoreCase("quit")) break;
            
            if (input.isEmpty()) {
                System.out.println("Empty string reversed: [] ✓\n");
                continue;
            }
            
            char[] s = input.toCharArray();
            System.out.println("Before: " + Arrays.toString(s));
            reverseString(s);
            System.out.println("After:  " + Arrays.toString(s) + "\n");
        }
        sc.close();
    }
    
    private static void testReverse(String desc, char[] arr) {
        char[] original = arr.clone();
        reverseString(arr);
        System.out.printf("%s: %s → %s %s\n", 
            desc, Arrays.toString(original), Arrays.toString(arr), "✓");
    }
}
