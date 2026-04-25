package leetCodeProblems;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }

    // Main method for local testing
    public static void main(String[] args) {
        MaxProfit sol = new MaxProfit();

        // Example 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println(sol.maxProfit(prices1)); // Expected: 7

        // Example 2
        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println(sol.maxProfit(prices2)); // Expected: 4

        // Example 3
        int[] prices3 = {7, 6, 4, 3, 1};
        System.out.println(sol.maxProfit(prices3)); // Expected: 0
    }
}