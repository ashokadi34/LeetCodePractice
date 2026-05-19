package leetCodeProblems;

public class MinimumCommonValue {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        MinimumCommonValue sol = new MinimumCommonValue();
        System.out.println(sol.getCommon(new int[]{1,2,3}, new int[]{2,4}));          // 2
        System.out.println(sol.getCommon(new int[]{1,2,3,6}, new int[]{2,3,4,5}));    // 2
        System.out.println(sol.getCommon(new int[]{1,3,5}, new int[]{2,4,6}));        // -1
    }
}