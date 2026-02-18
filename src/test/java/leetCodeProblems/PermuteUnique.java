package leetCodeProblems;

import java.util.*;

public class PermuteUnique {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }
    
    //Backtrace
    private static void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                current.add(nums[i]);
                backtrack(nums, used, current, result);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }

    //Test cases
    public static void main(String[] args) {
        // Example 1: nums = [1,1,2]
        int[] nums1 = {1, 1, 2};
        System.out.println("Example 1: " + permuteUnique(nums1));

        // Example 2: nums = [1,2,3]
        int[] nums2 = {1, 2, 3};
        System.out.println("Example 2: " + permuteUnique(nums2));

        // Extra test: all duplicates
        int[] nums3 = {1, 1, 1};
        System.out.println("All dups: " + permuteUnique(nums3));

        // Single element
        int[] nums4 = {5};
        System.out.println("Single: " + permuteUnique(nums4));
    }
}
