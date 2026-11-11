package leetCodeProblems;

import java.util.Arrays;

public class ClimbStairs {

    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];

        for (int step = 1; step <= n; step++) {
            // Jump from step - 1.
            dp[step] = dp[step - 1] + costs[step - 1] + 1;

            // Jump from step - 2.
            if (step >= 2) {
                dp[step] = Math.min(
                    dp[step],
                    dp[step - 2] + costs[step - 1] + 4
                );
            }

            // Jump from step - 3.
            if (step >= 3) {
                dp[step] = Math.min(
                    dp[step],
                    dp[step - 3] + costs[step - 1] + 9
                );
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        ClimbStairs solution = new ClimbStairs();

        int[][] costTests = {
            {1, 2, 3, 4},
            {5, 1, 6, 2},
            {9, 8, 3}
        };

        int[] expected = {13, 11, 12};

        for (int i = 0; i < costTests.length; i++) {
            int n = costTests[i].length;
            int result = solution.climbStairs(n, costTests[i]);

            System.out.println("Test case " + (i + 1));
            System.out.println("n:        " + n);
            System.out.println(
                "Costs:    " + Arrays.toString(costTests[i])
            );
            System.out.println("Output:   " + result);
            System.out.println("Expected: " + expected[i]);
            System.out.println(
                "Status:   " + (result == expected[i] ? "PASS" : "FAIL")
            );
            System.out.println();
        }
    }
}