package leetCodeProblems;

public class JumpGameLocal {
    public static class Solution {
        public boolean canJump(int[] nums) {
            int maxReach = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i > maxReach) return false;
                maxReach = Math.max(maxReach, i + nums[i]);
                if (maxReach >= nums.length - 1) return true;
            }
            return true;
        }
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(",");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[] nums1 = {2,3,1,1,4};
        System.out.print("Input: ");
        printArray(nums1);
        System.out.println("Output: " + sol.canJump(nums1));  // true

        // Example 2
        int[] nums2 = {3,2,1,0,4};
        System.out.print("Input: ");
        printArray(nums2);
        System.out.println("Output: " + sol.canJump(nums2));  // false

        // Edge: Already at end
        int[] nums3 = {0};
        System.out.print("Input: ");
        printArray(nums3);
        System.out.println("Output: " + sol.canJump(nums3));  // true

        // Edge: Can jump directly
        int[] nums4 = {2,0,0};
        System.out.print("Input: ");
        printArray(nums4);
        System.out.println("Output: " + sol.canJump(nums4));  // true

        // Edge: Stuck early
        int[] nums5 = {1,0,0};
        System.out.print("Input: ");
        printArray(nums5);
        System.out.println("Output: " + sol.canJump(nums5));  // false
    }
}

