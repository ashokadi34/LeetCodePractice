package leetCodeProblems;

import java.util.*;

public class InsertIntervalLocal {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        
        // Add intervals before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        
        // Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        
        // Add merged newInterval
        result.add(newInterval);
        
        // Add remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }
        
        return result.toArray(new int[result.size()][]);
    }
    
    // Helper to print 2D array
    public static void printIntervals(int[][] intervals) {
        System.out.print("[");
        for (int i = 0; i < intervals.length; i++) {
            System.out.print("[" + intervals[i][0] + "," + intervals[i][1] + "]");
            if (i < intervals.length - 1) System.out.print(",");
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        // Example 1
        int[][] intervals1 = {{1,3},{6,9}};
        int[] newInterval1 = {2,5};
        int[][] result1 = insert(intervals1, newInterval1);
        System.out.print("Example 1: ");
        printIntervals(result1);  // Expected: [[1,5],[6,9]]
        
        // Example 2
        int[][] intervals2 = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval2 = {4,8};
        int[][] result2 = insert(intervals2, newInterval2);
        System.out.print("Example 2: ");
        printIntervals(result2);  // Expected: [[1,2],[3,10],[12,16]]
        
        // Edge case: Empty intervals
        int[][] intervals3 = {};
        int[] newInterval3 = {1,5};
        int[][] result3 = insert(intervals3, newInterval3);
        System.out.print("Empty intervals: ");
        printIntervals(result3);  // Expected: [[1,5]]
        
        // Edge case: No overlap
        int[][] intervals4 = {{1,2},{5,6}};
        int[] newInterval4 = {3,4};
        int[][] result4 = insert(intervals4, newInterval4);
        System.out.print("No overlap: ");
        printIntervals(result4);  // Expected: [[1,2],[3,4],[5,6]]
    }
}
