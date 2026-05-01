package leetCodeProblems;

public class MaxRotateFunction {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        long totalSum = 0;
        long f0 = 0;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
            f0 += (long) i * nums[i];
        }

        long max = f0;
        long prev = f0;
        // F(k) = F(k-1) + totalSum - n * nums[n-k]
        for (int k = 1; k < n; k++) {
            long curr = prev + totalSum - (long) n * nums[n - k];
            if (curr > max) max = curr;
            prev = curr;
        }
        return (int) max;
    }

    // Main method for local testing
    public static void main(String[] args) {
        MaxRotateFunction sol = new MaxRotateFunction();

        // Example 1
        int[] nums1 = {4, 3, 2, 6};
        System.out.println(sol.maxRotateFunction(nums1)); // Expected output: 26

        // Example 2
        int[] nums2 = {100};
        System.out.println(sol.maxRotateFunction(nums2)); // Expected output: 0

        // Additional test
        int[] nums3 = {1, 2, 3, 4, 5};
        System.out.println(sol.maxRotateFunction(nums3)); // Compute manually if needed
    }
}
