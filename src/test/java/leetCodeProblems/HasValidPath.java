package leetCodeProblems;

import java.util.*;

public class HasValidPath {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            if (x == m-1 && y == n-1) return true;
            
            int type = grid[x][y];
            // Up
            if (x > 0 && canMoveUp(type) && canMoveDown(grid[x-1][y]) && !visited[x-1][y]) {
                visited[x-1][y] = true;
                queue.offer(new int[]{x-1, y});
            }
            // Down
            if (x+1 < m && canMoveDown(type) && canMoveUp(grid[x+1][y]) && !visited[x+1][y]) {
                visited[x+1][y] = true;
                queue.offer(new int[]{x+1, y});
            }
            // Left
            if (y > 0 && canMoveLeft(type) && canMoveRight(grid[x][y-1]) && !visited[x][y-1]) {
                visited[x][y-1] = true;
                queue.offer(new int[]{x, y-1});
            }
            // Right
            if (y+1 < n && canMoveRight(type) && canMoveLeft(grid[x][y+1]) && !visited[x][y+1]) {
                visited[x][y+1] = true;
                queue.offer(new int[]{x, y+1});
            }
        }
        return false;
    }
    
    private boolean canMoveUp(int t) {
        return t == 2 || t == 5 || t == 6;
    }
    
    private boolean canMoveDown(int t) {
        return t == 2 || t == 3 || t == 4;
    }
    
    private boolean canMoveLeft(int t) {
        return t == 1 || t == 3 || t == 5;
    }
    
    private boolean canMoveRight(int t) {
        return t == 1 || t == 4 || t == 6;
    }
    
    // Test cases
    public static void main(String[] args) {
        HasValidPath sol = new HasValidPath();
        
        // Example 1
        int[][] grid1 = {{2,4,3},{6,5,2}};
        System.out.println(sol.hasValidPath(grid1)); // true
        
        // Example 2
        int[][] grid2 = {{1,2,1},{1,2,1}};
        System.out.println(sol.hasValidPath(grid2)); // false
        
        // Example 3
        int[][] grid3 = {{1,1,2}};
        System.out.println(sol.hasValidPath(grid3)); // false
    }
}
