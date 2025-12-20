package leetCodeProblems;

import java.util.Scanner;

public class DeleteColumnsToMakeSortedLocal {

    //  method
    public static int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        int deletions = 0;

        // For each column
        for (int col = 0; col < m; col++) {
            // Check if this column is sorted from top to bottom
            for (int row = 1; row < n; row++) {
                if (strs[row].charAt(col) < strs[row - 1].charAt(col)) {
                    deletions++;       // column not sorted, must delete
                    break;            // no need to check further rows in this column
                }
            }
        }
        return deletions;
    }

    public static void main(String[] args) {
        // Fixed tests (examples)
        String[] ex1 = {"cba", "daf", "ghi"};
        String[] ex2 = {"a", "b"};
        String[] ex3 = {"zyx", "wvu", "tsr"};

        System.out.println("Fixed tests:");
        System.out.println("Example 1: " + minDeletionSize(ex1)); // 1
        System.out.println("Example 2: " + minDeletionSize(ex2)); // 0
        System.out.println("Example 3: " + minDeletionSize(ex3)); // 3

        // Interactive mode
        Scanner sc = new Scanner(System.in);
        System.out.println("\nInteractive mode (type 'quit' to exit).");
        while (true) {
            System.out.print("Enter n (number of strings), or 'quit': ");
            if (!sc.hasNextInt()) break;
            int n = sc.nextInt();
            sc.nextLine(); // consume newline

            String[] strs = new String[n];
            System.out.println("Enter " + n + " strings (same length):");
            for (int i = 0; i < n; i++) {
                strs[i] = sc.nextLine();
            }

            int res = minDeletionSize(strs);
            System.out.println("minDeletionSize = " + res);
        }
        sc.close();
    }
}

