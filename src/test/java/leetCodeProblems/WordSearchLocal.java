package leetCodeProblems;

public class WordSearchLocal {
    static class Solution {
        public boolean exist(char[][] board, String word) {
            if (board == null || board.length == 0 || board[0].length == 0) return false;
            
            int m = board.length;
            int n = board[0].length;

            // Pruning: check char frequency
            int[] freqBoard = new int[128];
            int[] freqWord = new int[128];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    freqBoard[board[i][j]]++;
                }
            }
            for (int k = 0; k < word.length(); k++) {
                char c = word.charAt(k);
                freqWord[c]++;
                if (freqWord[c] > freqBoard[c]) {
                    return false;
                }
            }

            boolean[][] visited = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfs(board, word, 0, i, j, visited)) {
                        return true;
                    }
                }
            }
            return false;
        }
        //dfs
        private boolean dfs(char[][] board, String word, int idx,
                            int row, int col, boolean[][] visited) {
            if (idx == word.length()) {
                return true;
            }

            int m = board.length;
            int n = board[0].length;

            if (row < 0 || row >= m || col < 0 || col >= n ||
                visited[row][col] || board[row][col] != word.charAt(idx)) {
                return false;
            }

            visited[row][col] = true;

            boolean found =
                dfs(board, word, idx + 1, row + 1, col, visited) ||
                dfs(board, word, idx + 1, row - 1, col, visited) ||
                dfs(board, word, idx + 1, row, col + 1, visited) ||
                dfs(board, word, idx + 1, row, col - 1, visited);

            visited[row][col] = false;

            return found;
        }
    }

    //Test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test 1: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
        char[][] board1 = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println("Test1 ABCCED → " + sol.exist(board1, "ABCCED"));  // true

        // Test 2: word = "SEE"
        System.out.println("Test2 SEE → " + sol.exist(board1, "SEE"));  // true

        // Test 3: word = "ABCB"
        System.out.println("Test3 ABCB → " + sol.exist(board1, "ABCB"));  // false

        // Test 4: empty board
        System.out.println("Test4 empty board → " + sol.exist(new char[][]{}, "A"));  // false

        // Test 5: single cell match
        char[][] board5 = {{'A'}};
        System.out.println("Test5 single A → " + sol.exist(board5, "A"));  // true

        // Test 6: single cell no match
        System.out.println("Test6 single B → " + sol.exist(board5, "B"));  // false
    }
}

