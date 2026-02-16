package leetCodeProblems;

public class JumpGame2 {
    public static int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0, farthest = 0, end = 0;
        for (int i = 0; i < n - 1; ++i) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == end) {
                ++jumps;
                end = farthest;
            }
        }
        return jumps;
    }

    //Test cases
    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {2,3,1,1,4};
        System.out.println("nums=[2,3,1,1,4]: " + jump(nums1));  // 2

        // Example 2
        int[] nums2 = {2,3,0,1,4};
        System.out.println("nums=[2,3,0,1,4]: " + jump(nums2));  // 2

        // Additional tests
        int[] nums3 = {2,3,1};
        System.out.println("nums=[2,3,1]: " + jump(nums3));  // 1

        int[] nums4 = {1,1,1,1};
        System.out.println("nums=[1,1,1,1]: " + jump(nums4));  // 3

        int[] nums5 = {5};
        System.out.println("nums=[5]: " + jump(nums5));  // 0 (already at end)
    }
}

