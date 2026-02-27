package leetCodeProblems;

import java.util.*;

public class MergeIntervalsLocal {
    public static class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length <= 1) return intervals;
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            List<int[]> result = new ArrayList<>();
            result.add(intervals[0]);
            
            for (int i = 1; i < intervals.length; i++) {
                int[] prev = result.get(result.size() - 1);
                if (intervals[i][0] <= prev[1]) {
                    prev[1] = Math.max(prev[1], intervals[i][1]);
                } else {
                    result.add(intervals[i]);
                }
            }
            return result.toArray(new int[result.size()][]);
        }
    }

    public static void printIntervals(int[][] intervals) {
        System.out.print("[");
        for (int i = 0; i < intervals.length; i++) {
            System.out.print("[" + intervals[i][0] + "," + intervals[i][1] + "]");
            if (i < intervals.length - 1) System.out.print(",");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[][] intervals1 = {{1,3},{2,6},{8,10},{15,18}};
        System.out.print("Input: ");
        printIntervals(intervals1);
        printIntervals(sol.merge(intervals1));  // [[1,6],[8,10],[15,18]]

        System.out.println("\nExample 2:");
        int[][] intervals2 = {{1,4},{4,5}};
        printIntervals(intervals2);
        printIntervals(sol.merge(intervals2));  // [[1,5]]

        System.out.println("\nExample 3:");
        int[][] intervals3 = {{4,7},{1,4}};
        printIntervals(intervals3);
        printIntervals(sol.merge(intervals3));  // [[1,7]]

        // Edge: No overlap
        System.out.println("\nNo overlap:");
        int[][] noOverlap = {{1,2},{3,4}};
        printIntervals(noOverlap);
        printIntervals(sol.merge(noOverlap));  // [[1,2],[3,4]]

        // Edge: Single
        System.out.println("\nSingle:");
        int[][] single = {{5,10}};
        printIntervals(single);
        printIntervals(sol.merge(single));  // [[5,10]]
    }
}
