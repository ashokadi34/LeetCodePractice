package leetCodeProblems;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        
        int m = board.length;
        int n = board[0].length;
        
        // Mark border-connected 'O's with a temporary marker 'T'
        // First, process first and last column
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][n-1] == 'O') dfs(board, i, n-1);
        }
        // Process first and last row (excluding corners already done)
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') dfs(board, 0, j);
            if (board[m-1][j] == 'O') dfs(board, m-1, j);
        }
        
        // Convert remaining 'O' to 'X', and 'T' back to 'O'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }
    
    private void dfs(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') return;
        
        board[i][j] = 'T'; // mark as safe
        
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
    }

    // Test cases
    public static void main(String[] args) {
        SurroundedRegions sol = new SurroundedRegions();
        
        char[][] board1 = {
            {'X','X','X','X'},
            {'X','O','O','X'},
            {'X','X','O','X'},
            {'X','O','X','X'}
        };
        sol.solve(board1);
        // Print result
        System.out.println("Output board1:");
        for (char[] row : board1) {
            System.out.println(java.util.Arrays.toString(row));
        }
        // Expected: [X,X,X,X], [X,X,X,X], [X,X,X,X], [X,O,X,X]
        
        char[][] board2 = {{'X'}};
        sol.solve(board2);
        System.out.println("\nOutput board2:");
        for (char[] row : board2) {
            System.out.println(java.util.Arrays.toString(row));
        }
        // Expected: [X]
    }
}
