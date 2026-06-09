package leetCodeProblems;

public class MaxTotalValue {

    public long maxTotalValue(int[] nums, int k) {
        int maxVal = nums[0];
        int minVal = nums[0];
        
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
            minVal = Math.min(minVal, num);
        }
        
        return (long)(maxVal - minVal) * k;
    }

    public static void main(String[] args) {
        MaxTotalValue sol = new MaxTotalValue();

        // Example 1
        int[] nums1 = {1, 3, 2};
        int k1 = 2;
        System.out.println(sol.maxTotalValue(nums1, k1)); // 4

        // Example 2
        int[] nums2 = {4, 2, 5, 1};
        int k2 = 3;
        System.out.println(sol.maxTotalValue(nums2, k2)); // 12
    }
}