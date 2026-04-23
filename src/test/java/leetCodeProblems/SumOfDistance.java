package leetCodeProblems;

import java.util.*;

public class SumOfDistance {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        // Map each value to list of indices where it occurs
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        // Process each group of equal values
        for (List<Integer> indices : map.values()) {
            int m = indices.size();
            if (m == 1) continue; // no other indices -> distance 0
            // Build prefix sum of indices
            long[] prefix = new long[m + 1];
            for (int i = 0; i < m; i++) {
                prefix[i + 1] = prefix[i] + indices.get(i);
            }
            long total = prefix[m];
            // Compute distance for each index in this group
            for (int k = 0; k < m; k++) {
                int idx = indices.get(k);
                long leftCount = k;               // number of indices to the left
                long rightCount = m - k - 1;      // number of indices to the right
                long leftSum = prefix[k];         // sum of indices to the left
                long rightSum = total - prefix[k + 1]; // sum of indices to the right
                long dist = (leftCount * idx - leftSum) + (rightSum - rightCount * idx);
                ans[idx] = dist;
            }
        }
        return ans;
    }

    // Main method for local testing
    public static void main(String[] args) {
        SumOfDistance sol = new SumOfDistance();

        // Example 1
        int[] nums1 = {1, 3, 1, 1, 2};
        long[] result1 = sol.distance(nums1);
        System.out.println(Arrays.toString(result1)); // Expected: [5, 0, 3, 4, 0]

        // Example 2
        int[] nums2 = {0, 5, 3};
        long[] result2 = sol.distance(nums2);
        System.out.println(Arrays.toString(result2)); // Expected: [0, 0, 0]

        // Additional test
        int[] nums3 = {2, 2, 2};
        long[] result3 = sol.distance(nums3);
        System.out.println(Arrays.toString(result3)); // Expected: [2, 0, 2]
    }
}
