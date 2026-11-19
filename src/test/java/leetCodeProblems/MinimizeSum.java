package leetCodeProblems;

import java.util.Arrays;

public class Main {

    public static int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int removeTwoSmallest = nums[n - 1] - nums[2];
        int removeTwoLargest = nums[n - 3] - nums[0];
        int removeOneFromEachEnd = nums[n - 2] - nums[1];

        return Math.min(
            removeTwoSmallest,
            Math.min(removeTwoLargest, removeOneFromEachEnd)
        );
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 4, 7, 8, 5};
        System.out.println(minimizeSum(nums1)); // Output: 3

        int[] nums2 = {1, 4, 3};
        System.out.println(minimizeSum(nums2)); // Output: 0
    }
}