package leetCodeProblems;

import java.util.*;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), candidates, target, 0);
        return ans;
    }
    
    private static void backtrack(List<List<Integer>> ans, List<Integer> comb, int[] cand, int tar, int i) {
        if (tar == 0) {
            ans.add(new ArrayList<>(comb));
            return;
        }
        if (tar < 0 || i == cand.length) return;
        
        // Skip current candidate
        backtrack(ans, comb, cand, tar, i + 1);
        // Include (unlimited reuse)
        comb.add(cand[i]);
        backtrack(ans, comb, cand, tar - cand[i], i);
        comb.remove(comb.size() - 1);
    }

    // Helper to print list of lists
    private static void printResult(List<List<Integer>> res) {
        if (res.isEmpty()) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        for (int k = 0; k < res.size(); k++) {
            System.out.print(Arrays.toString(res.get(k).toArray()));
            if (k < res.size() - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        // Example 1
        int[] cand1 = {2,3,6,7};
        int target1 = 7;
        System.out.print("candidates=[2,3,6,7], target=7: ");
        printResult(combinationSum(cand1, target1));

        // Example 2
        int[] cand2 = {2,3,5};
        int target2 = 8;
        System.out.print("candidates=[2,3,5], target=8: ");
        printResult(combinationSum(cand2, target2));

        // Example 3
        int[] cand3 = {2};
        int target3 = 1;
        System.out.print("candidates=[2], target=1: ");
        printResult(combinationSum(cand3, target3));
    }
}

