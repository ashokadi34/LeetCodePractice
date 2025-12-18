package leetCodeProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordPatternLocal {

    // method
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];

            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(w)) return false;
            } else {
                charToWord.put(c, w);
            }

            if (wordToChar.containsKey(w)) {
                if (wordToChar.get(w) != c) return false;
            } else {
                wordToChar.put(w, c);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Fixed tests (examples)
        System.out.println("Fixed tests:");
        System.out.println(wordPattern("abba", "dog cat cat dog"));   // true
        System.out.println(wordPattern("abba", "dog cat cat fish"));  // false
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));   // false

        // Interactive testing method using scanner class
        Scanner sc = new Scanner(System.in);
        System.out.println("\nInteractive mode (type 'quit' to exit):");
        while (true) {
            System.out.print("Enter pattern (or 'quit'): ");
            String pattern = sc.nextLine();
            if (pattern.equalsIgnoreCase("quit")) break;

            System.out.print("Enter string s: ");
            String s = sc.nextLine();

            boolean result = wordPattern(pattern, s);
            System.out.println("Result: " + result);
        }
        sc.close();
    }
}

