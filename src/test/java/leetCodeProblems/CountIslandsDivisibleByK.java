package leetCodeProblems;

import java.util.Scanner;

public class CountIslandsDivisibleByK {

    private static final int[] ROW_DIRECTIONS = {-1, 0, 1, 0};
    private static final int[] COL_DIRECTIONS = {0, 1, 0, -1};

    private int[][] grid;
    private int rows;
    private int cols;
    private int k;

    public int countIslands(int[][] grid, int k) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.k = k;

        int divisibleIslands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] > 0) {
                    long islandSum = dfs(i, j);

                    if (islandSum % k == 0) {
                        divisibleIslands++;
                    }
                }
            }
        }

        return divisibleIslands;
    }

    private long dfs(int row, int col) {
        long sum = grid[row][col];
        grid[row][col] = 0; // mark visited

        for (int direction = 0; direction < 4; direction++) {
            int nextRow = row + ROW_DIRECTIONS[direction];
            int nextCol = col + COL_DIRECTIONS[direction];

            if (nextRow >= 0 && nextRow < rows
                    && nextCol >= 0 && nextCol < cols
                    && grid[nextRow][nextCol] > 0) {
                sum += dfs(nextRow, nextCol);
            }
        }

        return sum;
    }
	
	/*
	Enter number of rows: 2
	Enter number of columns: 4
	Enter 8 grid values row by row:
	3 0 3 0
	0 3 0 3
	Enter k: 3
	Output: 6
	*/

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

        System.out.print("Enter k: ");
        int k = scanner.nextInt();

        CountIslandsDivisibleByK solution = new CountIslandsDivisibleByK();
        int result = solution.countIslands(grid, k);

        System.out.println("Output: " + result);

        scanner.close();
    }
}