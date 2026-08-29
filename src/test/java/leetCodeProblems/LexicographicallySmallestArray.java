package leetCodeProblems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LexicographicallySmallestArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Input format like - n nums[0] nums[1] ... nums[n - 1] limit: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int limit = scanner.nextInt();

        int[] answer = lexicographicallySmallestArray(nums, limit);

        System.out.println(Arrays.toString(answer));

        scanner.close();
    }

    public static int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        /*
         * pairs[i][0] = value
         * pairs[i][1] = original index
         */
        int[][] pairs = new int[n][2];

        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }

        // Sort all values in increasing order.
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));

        int[] answer = new int[n];
        int groupStart = 0;

        /*
         * Consecutive values belong to the same swappable group
         * if their difference is at most limit.
         */
        for (int groupEnd = 1; groupEnd <= n; groupEnd++) {

            boolean isGroupEnd = groupEnd == n ||
                    (long) pairs[groupEnd][0] - pairs[groupEnd - 1][0] > limit;

            if (!isGroupEnd) {
                continue;
            }

            int groupSize = groupEnd - groupStart;
            int[] indices = new int[groupSize];

            // Get all original positions of elements in this group.
            for (int i = 0; i < groupSize; i++) {
                indices[i] = pairs[groupStart + i][1];
            }

            // Smaller values should go to smaller positions.
            Arrays.sort(indices);

            for (int i = 0; i < groupSize; i++) {
                answer[indices[i]] = pairs[groupStart + i][0];
            }

            groupStart = groupEnd;
        }

        return answer;
    }
}
