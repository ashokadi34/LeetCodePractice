package leetCodeProblems;

import java.util.Arrays;

public class MinimumRemovalsToBalanceArray {
    public static int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int maxLen = 1;  // At least 1
        for (int right = 0; right < n; ++right) {
            while (nums[right] > (long) k * nums[left]) {
                ++left;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return n - maxLen;
    }
    
    //Test Cases
    public static void main(String[] args) {
        // Example 1: [2,1,5], k=2 → remove 1
        int[] nums1 = {2,1,5};
        System.out.println("Input: [2,1,5], k=2");
        System.out.println("Output: " + minRemoval(nums1, 2));  // 1
        
        // Example 2: [1,6,2,9], k=3 → remove 2
        int[] nums2 = {1,6,2,9};
        System.out.println("\nInput: [1,6,2,9], k=3");
        System.out.println("Output: " + minRemoval(nums2, 3));  // 2
        
        // Example 3: [4,6], k=2 → remove 0
        int[] nums3 = {4,6};
        System.out.println("\nInput: [4,6], k=2");
        System.out.println("Output: " + minRemoval(nums3, 2));  // 0
        
        // Test: k=1, must all equal → [1,1,2] → 1
        int[] nums4 = {1,1,2};
        System.out.println("\nInput: [1,1,2], k=1");
        System.out.println("Output: " + minRemoval(nums4, 1));  // 1
        
        // Test: single element
        int[] nums5 = {7};
        System.out.println("\nInput: [7], k=5");
        System.out.println("Output: " + minRemoval(nums5, 5));  // 0
    }
}

