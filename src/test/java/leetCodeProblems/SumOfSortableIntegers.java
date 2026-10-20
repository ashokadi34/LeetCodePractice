package leetCodeProblems;

import java.util.Scanner;

public class SumOfSortableIntegers {

    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int answer = 0;

        int[] prefixMax = new int[n + 1];
        prefixMax[0] = 0;

        for (int i = 0; i < n; i++) {
            prefixMax[i + 1] = Math.max(prefixMax[i], nums[i]);
        }

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            if (canSortWithBlockSize(nums, k, prefixMax)) {
                answer += k;
            }
        }

        return answer;
    }

    private boolean canSortWithBlockSize(int[] nums, int k, int[] prefixMax) {
        int n = nums.length;

        for (int start = 0; start < n; start += k) {
            int end = start + k;

            // A block can be cyclically rotated into non-decreasing order
            // only if it has at most one strict descent circularly.
            int descents = 0;

            for (int i = start; i < end; i++) {
                int next = (i + 1 == end) ? start : i + 1;

                if (nums[i] > nums[next]) {
                    descents++;
                }
            }

            if (descents > 1) {
                return false;
            }

            // After rotating this block into sorted order, its minimum must
            // not be smaller than any value in the already-sorted prefix.
            int blockMin = Integer.MAX_VALUE;

            for (int i = start; i < end; i++) {
                blockMin = Math.min(blockMin, nums[i]);
            }

            if (prefixMax[start] > blockMin) {
                return false;
            }
        }

        return true;
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

        SumOfSortableIntegers solution = new SumOfSortableIntegers();
        int result = solution.sortableIntegers(nums);

        System.out.println("Output: " + result);

        scanner.close();
    }
}