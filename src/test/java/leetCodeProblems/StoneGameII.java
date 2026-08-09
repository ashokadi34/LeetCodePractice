package leetCodeProblems;

import java.util.Arrays;
import java.util.Scanner;

public class StoneGameII {

    static class Solution {
        private int n;
        private int[] suffix;
        private int[][] memo;

        public int stoneGameII(int[] piles) {
            n = piles.length;
            suffix = new int[n + 1];
            memo = new int[n][n + 1];

            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }

            // suffix[i] = sum of piles from i to n - 1
            for (int i = n - 1; i >= 0; i--) {
                suffix[i] = suffix[i + 1] + piles[i];
            }

            return dfs(0, 1);
        }

        private int dfs(int index, int m) {
            if (index >= n) {
                return 0;
            }

            // The current player can take all remaining piles.
            if (index + 2 * m >= n) {
                return suffix[index];
            }

            if (memo[index][m] != -1) {
                return memo[index][m];
            }

            int best = 0;

            for (int x = 1; x <= 2 * m; x++) {
                int nextIndex = index + x;
                int nextM = Math.max(m, x);

                int currentPlayerStones =
                        suffix[index] - dfs(nextIndex, nextM);

                best = Math.max(best, currentPlayerStones);
            }

            return memo[index][m] = best;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*
         * Input format:
         * n
         * pile1 pile2 ... pilen
         *
         * Sample input text
			5
			2 7 9 4 4
			output:
			10
			
			Sample input text
			6
			1 2 3 4 5 100
			Output:
			104
         * 
         */

        int n = scanner.nextInt();
        int[] piles = new int[n];

        for (int i = 0; i < n; i++) {
            piles[i] = scanner.nextInt();
        }

        Solution solution = new Solution();
        int result = solution.stoneGameII(piles);

        System.out.println(result);

        scanner.close();
    }
}