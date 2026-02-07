package leetCodeProblems;

import java.util.Arrays;

public class FindFirstLastPositionSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        int left = findFirst(nums, target);
        if (left == -1) return new int[]{-1, -1};
        int right = findLast(nums, target);
        return new int[]{left, right};
    }
    
    private static int findFirst(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (low < nums.length && nums[low] == target) ? low : -1;
    }
    
    private static int findLast(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (high >= 0 && nums[high] == target) ? high : -1;
    }
    
    public static void main(String[] args) {
        // Example 1: [5,7,7,8,8,10], target=8 → [3,4]
        int[] nums1 = {5,7,7,8,8,10};
        int[] res1 = searchRange(nums1, 8);
        System.out.println("Input: [5,7,7,8,8,10], target=8");
        System.out.println("Output: " + Arrays.toString(res1));  // [3, 4]
        
        // Example 2: target=6 → [-1,-1]
        int[] res2 = searchRange(nums1, 6);
        System.out.println("\nInput: [5,7,7,8,8,10], target=6");
        System.out.println("Output: " + Arrays.toString(res2));  // [-1, -1]
        
        // Example 3: empty array
        int[] nums3 = {};
        int[] res3 = searchRange(nums3, 0);
        System.out.println("\nInput: [], target=0");
        System.out.println("Output: " + Arrays.toString(res3));  // [-1, -1]
        
        // Test: single occurrence
        int[] nums4 = {1};
        int[] res4 = searchRange(nums4, 1);
        System.out.println("\nInput: [1], target=1");
        System.out.println("Output: " + Arrays.toString(res4));  // [0, 0]
        
        // Test: all duplicates
        int[] nums5 = {2,2,2,2,2};
        int[] res5 = searchRange(nums5, 2);
        System.out.println("\nInput: [2,2,2,2,2], target=2");
        System.out.println("Output: " + Arrays.toString(res5));  // [0, 4]
    }
}

