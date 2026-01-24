package leetCodeProblems;

import java.util.Arrays;

public class MinPairSum {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int minMaxSum = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            minMaxSum = Math.max(minMaxSum, nums[left] + nums[right]);
            left++;
            right--;
        }
        return minMaxSum;
    }
    
    
    public static void main(String[] args) {
        MinPairSum sol = new MinPairSum();
        
        // Example 1: [3,5,2,3] → 7
        int[] nums1 = {3,5,2,3};
        System.out.println(Arrays.toString(nums1));
        System.out.println(sol.minPairSum(nums1));  // 7
        
        // Example 2: [3,5,4,2,4,6] → 8
        int[] nums2 = {3,5,4,2,4,6};
        System.out.println(Arrays.toString(nums2));
        System.out.println(sol.minPairSum(nums2));  // 8
        
        // Additional test: [1,2,3,4] → 5 (1+4, 2+3)
        int[] nums3 = {1,2,3,4};
        System.out.println(Arrays.toString(nums3));
        System.out.println(sol.minPairSum(nums3));  // 5
    }
}

