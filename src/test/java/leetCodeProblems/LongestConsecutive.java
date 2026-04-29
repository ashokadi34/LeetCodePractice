package leetCodeProblems;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int maxLen = 0;
        for (int num : nums) {
            // Only start counting if it's the beginning of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int count = 1;
                
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }
                maxLen = Math.max(maxLen, count);
            }
        }
        return maxLen;
    }

    // Main method for local testing
    public static void main(String[] args) {
        LongestConsecutive sol = new LongestConsecutive();
        
        // Example 1
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println(sol.longestConsecutive(nums1)); // 4
        
        // Example 2
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(sol.longestConsecutive(nums2)); // 9
        
        // Example 3
        int[] nums3 = {1, 0, 1, 2};
        System.out.println(sol.longestConsecutive(nums3)); // 3
    }
}
