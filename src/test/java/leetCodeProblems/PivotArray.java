package leetCodeProblems;

import java.util.*;

public class PivotArray {

    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        
        for (int num : nums) {
            if (num < pivot) {
                less.add(num);
            } else if (num == pivot) {
                equal.add(num);
            } else {
                greater.add(num);
            }
        }
        
        int[] result = new int[nums.length];
        int idx = 0;
        
        for (int num : less) {
            result[idx++] = num;
        }
        
        for (int num : equal) {
            result[idx++] = num;
        }
        
        for (int num : greater) {
            result[idx++] = num;
        }
        
        return result;
    }

    public static void main(String[] args) {
        PivotArray sol = new PivotArray();

        // Example 1
        int[] nums1 = {9, 12, 5, 10, 14, 3, 10};
        int[] result1 = sol.pivotArray(nums1, 10);
        System.out.println(java.util.Arrays.toString(result1)); // [9, 5, 3, 10, 10, 12, 14]

        // Example 2
        int[] nums2 = {-3, 4, 3, 2};
        int[] result2 = sol.pivotArray(nums2, 2);
        System.out.println(java.util.Arrays.toString(result2)); // [-3, 2, 4, 3]
    }
}
