package leetCodeProblems;

import java.util.*;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(n, k, 1, current, result);
        return result;
    }
    
    private void backtrack(int n, int k, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i <= n; i++) {
            current.add(i);
            backtrack(n, k, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
    
    // Local testing
    public static void main(String[] args) {
    	Combinations sol = new Combinations();
        
        // Test 1: n=4, k=2
        System.out.println("n=4, k=2:");
        printCombinations(sol.combine(4, 2));
        
        // Test 2: n=1, k=1
        System.out.println("n=1, k=1:");
        printCombinations(sol.combine(1, 1));
        
        // Test 3: n=3, k=2
        System.out.println("n=3, k=2:");
        printCombinations(sol.combine(3, 2));
    }
    
    //printCombinations
    static void printCombinations(List<List<Integer>> combos) {
        for (List<Integer> combo : combos) {
            System.out.print("[");
            for (int i = 0; i < combo.size(); i++) {
                System.out.print(combo.get(i));
                if (i < combo.size() - 1) System.out.print(",");
            }
            System.out.println("]");
        }
        System.out.println();
    }
}

