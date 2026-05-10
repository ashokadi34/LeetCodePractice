package leetCodeProblems;

import java.util.Arrays;

public class MaximumJumps {

    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] != -1 && Math.abs((long) nums[i] - nums[j]) <= target) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        MaximumJumps sol = new MaximumJumps();

        int[] nums1 = {1, 3, 6, 4, 1, 2};
        int target1 = 2;
        System.out.println("Output 1: " + sol.maximumJumps(nums1, target1)); // 3

        int[] nums2 = {1, 3, 6, 4, 1, 2};
        int target2 = 3;
        System.out.println("Output 2: " + sol.maximumJumps(nums2, target2)); // 5

        int[] nums3 = {1, 3, 6, 4, 1, 2};
        int target3 = 0;
        System.out.println("Output 3: " + sol.maximumJumps(nums3, target3)); // -1
    }
}
