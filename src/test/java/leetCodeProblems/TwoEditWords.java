package leetCodeProblems;

import java.util.ArrayList;
import java.util.List;

public class TwoEditWords {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        for (String query : queries) {
            for (String dictWord : dictionary) {
                int diff = 0;
                // Compare characters (all strings have same length)
                for (int i = 0; i < query.length(); i++) {
                    if (query.charAt(i) != dictWord.charAt(i)) {
                        diff++;
                        if (diff > 2) break; // early exit if more than 2 edits needed
                    }
                }
                if (diff <= 2) {
                    result.add(query);
                    break; // no need to check other dictionary words for this query
                }
            }
        }
        return result;
    }

    // Main method for local test cases
    public static void main(String[] args) {
        TwoEditWords sol = new TwoEditWords();

        // Example 1
        String[] queries1 = {"word", "note", "ants", "wood"};
        String[] dictionary1 = {"wood", "joke", "moat"};
        System.out.println("Example 1 Output: " + sol.twoEditWords(queries1, dictionary1));
        // Expected: [word, note, wood]

        // Example 2
        String[] queries2 = {"yes"};
        String[] dictionary2 = {"not"};
        System.out.println("Example 2 Output: " + sol.twoEditWords(queries2, dictionary2));
        // Expected: []

        // Additional test
        String[] queries3 = {"abc", "def", "ghi"};
        String[] dictionary3 = {"abc", "dec", "ghk"};
        System.out.println("Example 3 Output: " + sol.twoEditWords(queries3, dictionary3));
        // Expected: [abc, def] (abc matches with 0 edits, def matches with 1 edit (f->c), ghi needs 2 edits (i->k) but still matches)
    }
}
