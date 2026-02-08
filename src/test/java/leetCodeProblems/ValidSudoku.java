package leetCodeProblems;

import java.util.*;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch == '.') continue;
                int boxIdx = (i / 3) * 3 + (j / 3);
                if (rows[i].contains(ch) || cols[j].contains(ch) || boxes[boxIdx].contains(ch)) {
                    return false;
                }
                rows[i].add(ch);
                cols[j].add(ch);
                boxes[boxIdx].add(ch);
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        // Example 1: Valid board
        char[][] board1 = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println("Example 1:");
        System.out.println("Output: " + isValidSudoku(board1));  // true
        
        // Example 2: Invalid (duplicate 8 in top-left box)
        char[][] board2 = {
            {'8','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println("\nExample 2:");
        System.out.println("Output: " + isValidSudoku(board2));  // false
        
        // Test: Single filled cell
        char[][] board3 = new char[9][9];
        board3[0][0] = '1';
        System.out.println("\nTest: Single '1'");
        System.out.println("Output: " + isValidSudoku(board3));  // true
        
        // Test: Row duplicate
        board3[0][1] = '1';
        System.out.println("\nTest: Row duplicate '1'");
        System.out.println("Output: " + isValidSudoku(board3));  // false
    }
}

