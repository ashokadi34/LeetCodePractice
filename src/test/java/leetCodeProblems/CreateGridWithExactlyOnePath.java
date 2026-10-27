package leetCodeProblems;


import java.util.Arrays;
import java.util.Scanner;

public class CreateGridWithExactlyOnePath {

    public String[] createGrid(int m, int n) {
        char[][] grid = new char[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(grid[i], '#');
        }

        Arrays.fill(grid[0], '.');

        for (int i = 0; i < m; i++) {
            grid[i][n - 1] = '.';
        }

        String[] result = new String[m];

        for (int i = 0; i < m; i++) {
            result[i] = new String(grid[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows (m): ");
        int m = scanner.nextInt();

        System.out.print("Enter number of columns (n): ");
        int n = scanner.nextInt();

        CreateGridWithExactlyOnePath solution = new CreateGridWithExactlyOnePath();
        String[] grid = solution.createGrid(m, n);

        System.out.println("Output:");
        for (String row : grid) {
            System.out.println(row);
        }

        scanner.close();
    }
}