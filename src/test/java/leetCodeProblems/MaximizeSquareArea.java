package leetCodeProblems;

import java.util.*;

public class MaximizeSquareArea {
    private static final int MOD = 1_000_000_007;

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int[] hs = withBorders(hFences, m);
        int[] vs = withBorders(vFences, n);

        Set<Integer> hDiffs = allDiffs(hs); // all possible heights
        int best = -1;

        // Iterate vertical diffs and check if that side exists in horizontal diffs
        for (int i = 0; i < vs.length; i++) {
            for (int j = i + 1; j < vs.length; j++) {
                int d = vs[j] - vs[i];
                if (hDiffs.contains(d)) best = Math.max(best, d);
            }
        }

        if (best == -1) return -1;
        long area = (long) best * best;
        return (int) (area % MOD);
    }

    private static int[] withBorders(int[] fences, int limit) {
        int[] arr = new int[fences.length + 2];
        System.arraycopy(fences, 0, arr, 0, fences.length);
        arr[fences.length] = 1;
        arr[fences.length + 1] = limit;
        Arrays.sort(arr);
        return arr;
    }

    private static Set<Integer> allDiffs(int[] arr) {
        Set<Integer> diffs = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                diffs.add(arr[j] - arr[i]);
            }
        }
        return diffs;
    }

    // Local testing in same single file/class
    public static void main(String[] args) {
        MaximizeSquareArea sol = new MaximizeSquareArea();

        // Example 1
        System.out.println(sol.maximizeSquareArea(4, 3, new int[]{2, 3}, new int[]{2})); // 4

        // Example 2
        System.out.println(sol.maximizeSquareArea(6, 7, new int[]{2}, new int[]{4}));   // -1
    }
}

