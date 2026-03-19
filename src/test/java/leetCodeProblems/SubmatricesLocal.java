package leetCodeProblems;

public class SubmatricesLocal {
    static class Solution {
        public int numberOfSubmatrices(char[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;
            
            // prefixX[i+1][j+1] = count of 'X' from (0,0) to (i,j)
            // prefixY[i+1][j+1] = count of 'Y' from (0,0) to (i,j)
            int[][] prefixX = new int[rows + 1][cols + 1];
            int[][] prefixY = new int[rows + 1][cols + 1];
            
            int result = 0;
            
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= cols; j++) {
                    // Inclusion-exclusion for prefix sums
                    prefixX[i][j] = prefixX[i - 1][j] + prefixX[i][j - 1] 
                                  - prefixX[i - 1][j - 1] 
                                  + (grid[i - 1][j - 1] == 'X' ? 1 : 0);
                    
                    prefixY[i][j] = prefixY[i - 1][j] + prefixY[i][j - 1] 
                                  - prefixY[i - 1][j - 1] 
                                  + (grid[i - 1][j - 1] == 'Y' ? 1 : 0);
                    
                    // Check submatrix (0,0) to (i-1,j-1): >=1 X and X==Y
                    if (prefixX[i][j] > 0 && prefixX[i][j] == prefixY[i][j]) {
                        result++;
                    }
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test 1: [["X","Y","."],["Y",".","."]] → 3
        char[][] grid1 = {{'X','Y','.'},{'Y','.','.'}};
        System.out.println("Test1 → " + sol.numberOfSubmatrices(grid1));

        // Test 2: [["X","X"],["X","Y"]] → 0
        char[][] grid2 = {{'X','X'},{'X','Y'}};
        System.out.println("Test2 → " + sol.numberOfSubmatrices(grid2));

        // Test 3: [[".","."],[".","."]] → 0
        char[][] grid3 = {{'.','.'},{' ','.','.'}};
        System.out.println("Test3 → " + sol.numberOfSubmatrices(grid3));

        // Test 4: single "X" → 0 (no Y)
        char[][] grid4 = {{'X'}};
        System.out.println("Test4 single X → " + sol.numberOfSubmatrices(grid4));

        // Test 5: ["X","Y"] → 1
        char[][] grid5 = {{'X','Y'}};
        System.out.println("Test5 X Y → " + sol.numberOfSubmatrices(grid5));
    }
}
