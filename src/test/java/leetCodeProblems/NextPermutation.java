package leetCodeProblems;

import java.util.Arrays;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }
    
    
    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    private static void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
  //Test cases
    public static void main(String[] args) {
        // Example 1: [1,2,3] -> [1,3,2]
        int[] nums1 = {1,2,3};
        System.out.println("Input: [1,2,3]");
        nextPermutation(nums1);
        System.out.println("Output: " + Arrays.toString(nums1));  // [1,3,2]
        
        // Example 2: [3,2,1] -> [1,2,3]
        int[] nums2 = {3,2,1};
        System.out.println("\nInput: [3,2,1]");
        nextPermutation(nums2);
        System.out.println("Output: " + Arrays.toString(nums2));  // [1,2,3]
        
        // Example 3: [1,1,5] -> [1,5,1]
        int[] nums3 = {1,1,5};
        System.out.println("\nInput: [1,1,5]");
        nextPermutation(nums3);
        System.out.println("Output: " + Arrays.toString(nums3));  // [1,5,1]
        
        // Test: [1,3,2] -> [2,1,3]
        int[] nums4 = {1,3,2};
        System.out.println("\nInput: [1,3,2]");
        nextPermutation(nums4);
        System.out.println("Output: " + Arrays.toString(nums4));  // [2,1,3]
    }
}
