package leetCodeProblems;

import java.util.*;

public class Permute {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;
    }
    
    private static void backtrack(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            backtrack(nums, start + 1, result);
            swap(nums, start, i);  // backtrack
        }
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        // Example 1: nums = [1,2,3]
        int[] nums1 = {1, 2, 3};
        System.out.println("Example 1: " + permute(nums1));

        // Example 2: nums = [0,1]
        int[] nums2 = {0, 1};
        System.out.println("Example 2: " + permute(nums2));

        // Example 3: nums = [1]
        int[] nums3 = {1};
        System.out.println("Example 3: " + permute(nums3));

        // Extra test: nums = []
        int[] nums4 = {};
        System.out.println("Empty: " + permute(nums4));
    }
}
