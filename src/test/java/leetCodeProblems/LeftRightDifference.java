package leetCodeProblems;

public class LeftRightDifference {

    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        
        int rightSum = 0;
        for (int num : nums) {
            rightSum += num;
        }
        
        int leftSum = 0;
        
        for (int i = 0; i < n; i++) {
            rightSum -= nums[i];
            answer[i] = Math.abs(leftSum - rightSum);
            leftSum += nums[i];
        }
        
        return answer;
    }

    public static void main(String[] args) {
        LeftRightDifference sol = new LeftRightDifference();

        // Example 1
        int[] nums1 = {10, 4, 8, 3};
        int[] result1 = sol.leftRightDifference(nums1);
        System.out.println(java.util.Arrays.toString(result1)); // [15, 1, 11, 22]

        // Example 2
        int[] nums2 = {1};
        int[] result2 = sol.leftRightDifference(nums2);
        System.out.println(java.util.Arrays.toString(result2)); // [0]
    }
}