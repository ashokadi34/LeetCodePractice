package leetCodeProblems;

import java.util.*;

public class CombinationSum2 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), candidates, target, 0);
        return ans;
    }
    
    //backtracking
    private static void backtrack(List<List<Integer>> ans, List<Integer> comb, int[] cand, int tar, int start) {
        if (tar == 0) {
            ans.add(new ArrayList<>(comb));
            return;
        }
        if (tar < 0) return;
        
        for (int i = start; i < cand.length; ++i) {
            if (i > start && cand[i] == cand[i - 1]) continue;
            comb.add(cand[i]);
            backtrack(ans, comb, cand, tar - cand[i], i + 1);
            comb.remove(comb.size() - 1);
        }
    }

    // Helper to print
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

    //Test cases
    public static void main(String[] args) {
        // Example 1
        int[] cand1 = {10,1,2,7,6,1,5};
        int target1 = 8;
        System.out.print("candidates=[10,1,2,7,6,1,5], target=8: ");
        printResult(combinationSum2(cand1, target1));

        // Example 2
        int[] cand2 = {2,5,2,1,2};
        int target2 = 5;
        System.out.print("candidates=[2,5,2,1,2], target=5: ");
        printResult(combinationSum2(cand2, target2));
    }
}

