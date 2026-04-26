package leetCodeProblems;

public class ContainsCycle {
    private int m, n;
    private char[][] grid;
    private boolean[][] visited;

    public boolean containsCycle(char[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(i, j, -1, -1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int pi, int pj) {
        visited[i][j] = true;

        // Four possible directions: up, down, left, right
        int[] dirs = {-1, 0, 1, 0, -1};
        for (int d = 0; d < 4; d++) {
            int ni = i + dirs[d];
            int nj = j + dirs[d + 1];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] == grid[i][j]) {
                if (!visited[ni][nj]) {
                    if (dfs(ni, nj, i, j)) {
                        return true;
                    }
                } else if (!(ni == pi && nj == pj)) {
                    // visited neighbor that is not the parent -> cycle found
                    return true;
                }
            }
        }
        return false;
    }

    // Test cases
    public static void main(String[] args) {
        ContainsCycle sol = new ContainsCycle();

        // Example 1
        char[][] grid1 = {
            {'a','a','a','a'},
            {'a','b','b','a'},
            {'a','b','b','a'},
            {'a','a','a','a'}
        };
        System.out.println(sol.containsCycle(grid1)); // true

        // Example 2
        char[][] grid2 = {
            {'c','c','c','a'},
            {'c','d','c','c'},
            {'c','c','e','c'},
            {'f','c','c','c'}
        };
        System.out.println(sol.containsCycle(grid2)); // true

        // Example 3
        char[][] grid3 = {
            {'a','b','b'},
            {'b','z','b'},
            {'b','b','a'}
        };
        System.out.println(sol.containsCycle(grid3)); // false

        // Additional test: single row
        char[][] grid4 = {{'a','a','a','a'}};
        System.out.println(sol.containsCycle(grid4)); // false
    }
}
