package leetCodeProblems;

import java.util.Arrays;
import java.util.Scanner;

public class SubarraysDistinctElementSumOfSquaresII {

    private static final int MOD = 1_000_000_007;

    private int n;
    private long[] sum;      // sum of distinct counts over all left endpoints
    private long[] sumSq;    // sum of squares of distinct counts
    private long[] lazy;     // pending range addition

    public int sumCounts(int[] nums) {
        n = nums.length;

        sum = new long[4 * n];
        sumSq = new long[4 * n];
        lazy = new long[4 * n];

        build(1, 0, n - 1);

        int[] lastSeen = new int[100001];
        Arrays.fill(lastSeen, -1);

        long answer = 0;

        for (int right = 0; right < n; right++) {
            int value = nums[right];
            int previous = lastSeen[value];

            // Every subarray starting in (previous, right] gains one distinct value.
            update(1, 0, n - 1, previous + 1, right, 1);

            lastSeen[value] = right;

            // Add squares of distinct counts for all subarrays ending at `right`.
            answer = (answer + sumSq[1]) % MOD;
        }

        return (int) answer;
    }

    private void build(int node, int left, int right) {
        if (left == right) {
            sum[node] = 0;
            sumSq[node] = 0;
            return;
        }

        int mid = (left + right) >>> 1;
        build(node * 2, left, mid);
        build(node * 2 + 1, mid + 1, right);

        pull(node);
    }

    private void update(int node, int nodeLeft, int nodeRight,
                        int queryLeft, int queryRight, int value) {
        if (queryRight < nodeLeft || nodeRight < queryLeft) {
            return;
        }

        if (queryLeft <= nodeLeft && nodeRight <= queryRight) {
            apply(node, nodeRight - nodeLeft + 1, value);
            return;
        }

        pushDown(node, nodeLeft, nodeRight);

        int mid = (nodeLeft + nodeRight) >>> 1;
        update(node * 2, nodeLeft, mid, queryLeft, queryRight, value);
        update(node * 2 + 1, mid + 1, nodeRight, queryLeft, queryRight, value);

        pull(node);
    }

    private void apply(int node, int length, long value) {
        sumSq[node] = (sumSq[node] + 2 * value * sum[node] + value * value * length) % MOD;
        sum[node] = (sum[node] + value * length) % MOD;
        lazy[node] = (lazy[node] + value) % MOD;
    }

    private void pushDown(int node, int left, int right) {
        if (lazy[node] == 0) {
            return;
        }

        int mid = (left + right) >>> 1;

        apply(node * 2, mid - left + 1, lazy[node]);
        apply(node * 2 + 1, right - mid, lazy[node]);

        lazy[node] = 0;
    }

    private void pull(int node) {
        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        sumSq[node] = (sumSq[node * 2] + sumSq[node * 2 + 1]) % MOD;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = scanner.nextInt();

        int[] nums = new int[size];

        System.out.print("Enter " + size + " elements: ");
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }

        SubarraysDistinctElementSumOfSquaresII solution =
                new SubarraysDistinctElementSumOfSquaresII();

        int result = solution.sumCounts(nums);

        System.out.println("Output: " + result);

        scanner.close();
    }
}