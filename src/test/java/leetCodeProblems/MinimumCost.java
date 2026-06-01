package leetCodeProblems;

import java.util.Arrays;

public class MinimumCost {

    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        
        int totalCost = 0;
        int i = cost.length - 1;
        
        while (i >= 0) {
            totalCost += cost[i];
            i--;
            
            if (i >= 0) {
                totalCost += cost[i];
                i--;
            }
            
            i--; // Skip the free candy
        }
        
        return totalCost;
    }

    //Test cases
    public static void main(String[] args) {
        MinimumCost sol = new MinimumCost();

        // Example 1
        int[] cost1 = {1, 2, 3};
        System.out.println(sol.minimumCost(cost1)); // 5

        // Example 2
        int[] cost2 = {6, 5, 7, 9, 2, 2};
        System.out.println(sol.minimumCost(cost2)); // 23

        // Example 3
        int[] cost3 = {5, 5};
        System.out.println(sol.minimumCost(cost3)); // 10
    }
}