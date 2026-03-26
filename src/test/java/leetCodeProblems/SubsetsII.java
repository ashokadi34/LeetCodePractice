package leetCodeProblems;

import java.util.*;

public class SubsetsII {

    static class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums); // group duplicates
            List<List<Integer>> result = new ArrayList<>();
            backtrack(nums, 0, new ArrayList<>(), result);
            return result;
        }

        //backtrack
        private void backtrack(int[] nums, int index, List<Integer> path, List<List<Integer>> result) {
            result.add(new ArrayList<>(path));

            for (int i = index; i < nums.length; i++) {
                // Skip duplicates: only take first of each equal group
                if (i > index && nums[i] == nums[i - 1]) continue;

                path.add(nums[i]);
                backtrack(nums, i + 1, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    // Utility to print list of lists
    public static void printSubsets(List<List<Integer>> subsets) {
        System.out.print("[");
        for (int i = 0; i < subsets.size(); i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(subsets.get(i));
        }
        System.out.println("]");
    }

    //Test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1: nums = [1, 2, 2]
        int[] nums1 = {1, 2, 2};
        List<List<Integer>> res1 = sol.subsetsWithDup(nums1);
        System.out.print("Input: [1,2,2]\n");
        System.out.print("Output: ");
        printSubsets(res1);

        // Example 2: nums = [0]
        int[] nums2 = {0};
        List<List<Integer>> res2 = sol.subsetsWithDup(nums2);
        System.out.print("\nInput: [0]\n");
        System.out.print("Output: ");
        printSubsets(res2);
    }
}
