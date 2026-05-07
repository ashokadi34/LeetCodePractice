package leetCodeProblems;

public class MaxValue {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        // prefix maximum
        int[] prefixMax = new int[n];
        prefixMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }
        // suffix minimum
        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
        }
        
        int[] ans = new int[n];
        int start = 0;
        int currentMax = nums[0];
        for (int i = 0; i < n; i++) {
            // update current maximum for this component
            currentMax = Math.max(currentMax, nums[i]);
            // check if this is the end of a component
            boolean isEnd = (i == n - 1) || (prefixMax[i] < suffixMin[i + 1]);
            if (isEnd) {
                // fill answer for current component
                for (int j = start; j <= i; j++) {
                    ans[j] = currentMax;
                }
                start = i + 1;
                if (start < n) {
                    currentMax = nums[start];
                }
            }
        }
        return ans;
    }

    // Local test cases
    public static void main(String[] args) {
        MaxValue sol = new MaxValue();
        int[] nums1 = {2, 1, 3};
        System.out.println(java.util.Arrays.toString(sol.maxValue(nums1))); // [2,2,3]
        int[] nums2 = {2, 3, 1};
        System.out.println(java.util.Arrays.toString(sol.maxValue(nums2))); // [3,3,3]
        int[] nums3 = {1};
        System.out.println(java.util.Arrays.toString(sol.maxValue(nums3))); // [1]
        int[] nums4 = {3, 2, 1, 4};
        System.out.println(java.util.Arrays.toString(sol.maxValue(nums4))); // [3,3,3,4]
    }
}
