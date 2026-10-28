package leetCodeProblems;

import java.util.Scanner;

public class MinimumXorPathInGrid {

    public int minCost(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int xorStates = 1024; // grid values are in [0, 1023]

        boolean[][][] reachable = new boolean[rows][cols][xorStates];

        reachable[0][0][grid[0][0]] = true;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int value = grid[i][j];

                if (i > 0) {
                    for (int xor = 0; xor < xorStates; xor++) {
                        if (reachable[i - 1][j][xor]) {
                            reachable[i][j][xor ^ value] = true;
                        }
                    }
                }

                if (j > 0) {
                    for (int xor = 0; xor < xorStates; xor++) {
                        if (reachable[i][j - 1][xor]) {
                            reachable[i][j][xor ^ value] = true;
                        }
                    }
                }
            }
        }

        for (int xor = 0; xor < xorStates; xor++) {
            if (reachable[rows - 1][cols - 1][xor]) {
                return xor;
            }
        }

        return -1; // unreachable in valid inputs
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int m = scanner.nextInt();

        System.out.print("Enter number of columns: ");
        int n = scanner.nextInt();

        int[][] grid = new int[m][n];

        System.out.println("Enter " + (m * n) + " grid values row by row:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        MinimumXorPathInGrid solution = new MinimumXorPathInGrid();
        int result = solution.minCost(grid);

        System.out.println("Output: " + result);

        scanner.close();
    }
}