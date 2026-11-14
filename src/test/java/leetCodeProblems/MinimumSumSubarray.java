package leetCodeProblems;

import java.util.Arrays;
import java.util.List;

public class MinimumSumSubarray {

    public static int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int ans = Integer.MAX_VALUE;

        for (int size = l; size <= r; size++) {
            int sum = 0;

            // Create the first subarray of the current length
            for (int i = 0; i < size; i++) {
                sum += nums.get(i);
            }

            if (sum > 0) {
                ans = Math.min(ans, sum);
            }

            // Slide the window across the array
            for (int i = size; i < n; i++) {
                sum -= nums.get(i - size);
                sum += nums.get(i);

                if (sum > 0) {
                    ans = Math.min(ans, sum);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

	// Local test cases 
    public static void main(String[] args) {
        List<Integer> nums1 = Arrays.asList(3, -2, 1, 4);
        System.out.println(minimumSumSubarray(nums1, 2, 3)); // Output: 1

        List<Integer> nums2 = Arrays.asList(-2, 2, -3, 1);
        System.out.println(minimumSumSubarray(nums2, 2, 3)); // Output: -1

        List<Integer> nums3 = Arrays.asList(1, 2, 3, 4);
        System.out.println(minimumSumSubarray(nums3, 2, 4)); // Output: 3
    }
}