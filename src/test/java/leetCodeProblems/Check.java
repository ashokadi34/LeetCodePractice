package leetCodeProblems;

public class Check {
    public boolean check(int[] nums) {
        int n = nums.length;
        int dropCount = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {  // wrap around at the end
                dropCount++;
            }
        }

        return dropCount <= 1;
    }

    public static void main(String[] args) {
        Check sol = new Check();

        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println(sol.check(nums1));  // true

        int[] nums2 = {2, 1, 3, 4};
        System.out.println(sol.check(nums2));  // false

        int[] nums3 = {1, 2, 3};
        System.out.println(sol.check(nums3));  // true
    }
}