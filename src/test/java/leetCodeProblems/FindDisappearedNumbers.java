package leetCodeProblems;

import java.util.*;

public class FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int num : nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindDisappearedNumbers sol = new FindDisappearedNumbers();

        int[] nums1 = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(sol.findDisappearedNumbers(nums1)); // [5, 6]

        int[] nums2 = {1, 1};
        System.out.println(sol.findDisappearedNumbers(nums2)); // [2]
    }
}
