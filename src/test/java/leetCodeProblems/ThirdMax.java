package leetCodeProblems;

public class ThirdMax {
    public int thirdMax(int[] nums) {
        Long first = null, second = null, third = null;

        for (int num : nums) {
            long x = num;

            if (first != null && x == first) continue;
            if (second != null && x == second) continue;
            if (third != null && x == third) continue;

            if (first == null || x > first) {
                third = second;
                second = first;
                first = x;
            } else if (second == null || x > second) {
                third = second;
                second = x;
            } else if (third == null || x > third) {
                third = x;
            }
        }

        return third == null ? first.intValue() : third.intValue();
    }

    public static void main(String[] args) {
        ThirdMax sol = new ThirdMax();

        int[] nums1 = {3, 2, 1};
        System.out.println(sol.thirdMax(nums1)); // 1

        int[] nums2 = {1, 2};
        System.out.println(sol.thirdMax(nums2)); // 2

        int[] nums3 = {2, 2, 3, 1};
        System.out.println(sol.thirdMax(nums3)); // 1
    }
}
