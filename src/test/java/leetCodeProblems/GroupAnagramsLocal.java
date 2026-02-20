package leetCodeProblems;

import java.util.*;

public class GroupAnagramsLocal {
    public static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String key = String.valueOf(chars);
                map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
            }
            return new ArrayList<>(map.values());
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        String[] strs1 = {"eat","tea","tan","ate","nat","bat"};
        System.out.println("Example 1: " + sol.groupAnagrams(strs1));
        // Expected: [[bat], [nat, tan], [ate, eat, tea]] (order may vary)

        // Example 2
        String[] strs2 = {""};
        System.out.println("Example 2: " + sol.groupAnagrams(strs2));
        // Expected: [[""]]

        // Example 3
        String[] strs3 = {"a"};
        System.out.println("Example 3: " + sol.groupAnagrams(strs3));
        // Expected: [["a"]]

        // Additional: All same
        String[] strs4 = {"cab","tin","pew","duh","cat","all","merc","accost","decal","reeled","eel","duh","cale","eat","cel","dele","sell","monk","duct","think","tina","thankful","duh","mi","hot","ba","hate","sac","lemon","pew","duh","act","seo","duh","dame","sag","rams","fame","nail","boil"};
        System.out.println("Additional: " + sol.groupAnagrams(strs4));
    }
}

