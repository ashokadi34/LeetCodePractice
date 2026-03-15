package leetCodeProblems;

import java.util.*;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, new ArrayList<>(), nums, result);
        return result;
    }
    
    private void backtrack(int index, List<Integer> current, int[] nums, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(i + 1, current, nums, result);
            current.remove(current.size() - 1);
        }
    }
    
    // ========== LOCAL TESTING ==========
    public static void main(String[] args) {
    	Subsets sol = new Subsets();
        
        // Test Case 1: [1,2,3]
        System.out.println("TEST 1: nums = [1,2,3]");
        printSubsets(sol.subsets(new int[]{1,2,3}));
        
        // Test Case 2: [0]
        System.out.println("TEST 2: nums = [0]");
        printSubsets(sol.subsets(new int[]{0}));
        
        // Test Case 3: [1,2]
        System.out.println("TEST 3: nums = [1,2]");
        printSubsets(sol.subsets(new int[]{1,2}));
    }
    
    static void printSubsets(List<List<Integer>> subsets) {
        System.out.print("Output: ");
        for (int i = 0; i < subsets.size(); i++) {
            List<Integer> subset = subsets.get(i);
            System.out.print("[");
            for (int j = 0; j < subset.size(); j++) {
                System.out.print(subset.get(j));
                if (j < subset.size() - 1) System.out.print(",");
            }
            System.out.print("]");
            if (i < subsets.size() - 1) System.out.print(", ");
        }
        System.out.println();
        System.out.println("Total: " + subsets.size() + " subsets ✓");
        System.out.println();
    }
}
