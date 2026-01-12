package leetCodeProblems;

public class MinTimeToVisitAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        for (int i = 1; i < points.length; i++) {
            int dx = Math.abs(points[i][0] - points[i-1][0]);
            int dy = Math.abs(points[i][1] - points[i-1][1]);
            time += Math.max(dx, dy);  // Chebyshev distance
        }
        return time;
    }

    // test cases
    public static void main(String[] args) {
        MinTimeToVisitAllPoints sol = new MinTimeToVisitAllPoints();
        
        // Example 1
        int[][] points1 = {{1,1},{3,4},{-1,0}};
        System.out.println(sol.minTimeToVisitAllPoints(points1));  // 7
        
        // Example 2
        int[][] points2 = {{3,2},{-2,2}};
        System.out.println(sol.minTimeToVisitAllPoints(points2));  // 5
        
        // Additional
        System.out.println(sol.minTimeToVisitAllPoints(new int[][]{{1,1}}));  // 0
    }
}
