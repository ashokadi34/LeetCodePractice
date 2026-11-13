package leetCodeProblems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class CountNonDecreasingSubarrays {

    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();

        int right = n - 1;
        long cost = 0;
        long answer = 0;

        for (int left = n - 1; left >= 0; left--) {
            // Merge smaller blocks into the new leftmost height.
            while (!deque.isEmpty()
                    && nums[deque.peekLast()] < nums[left]) {

                int index = deque.pollLast();

                int blockEnd = deque.isEmpty()
                    ? right
                    : deque.peekLast() - 1;

                cost += (long) (blockEnd - index + 1)
                      * (nums[left] - nums[index]);
            }

            deque.offerLast(left);

            // Shrink the window until its cost is at most k.
            while (cost > k) {
                cost -= (long) nums[deque.peekFirst()] - nums[right];

                if (deque.peekFirst() == right) {
                    deque.pollFirst();
                }

                right--;
            }

            answer += right - left + 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        CountNonDecreasingSubarrays solution = new CountNonDecreasingSubarrays();

        int[][] numsTests = {
            {6, 3, 1, 2, 4, 4},
            {6, 3, 1, 3, 6}
        };

        int[] kValues = {7, 4};
        long[] expected = {17L, 12L};

        for (int i = 0; i < numsTests.length; i++) {
            long result = solution.countNonDecreasingSubarrays(
                numsTests[i],
                kValues[i]
            );

            System.out.println("Test case " + (i + 1));
            System.out.println(
                "Nums:     " + Arrays.toString(numsTests[i])
            );
            System.out.println("k:        " + kValues[i]);
            System.out.println("Output:   " + result);
            System.out.println("Expected: " + expected[i]);
            System.out.println(
                "Status:   " + (result == expected[i] ? "PASS" : "FAIL")
            );
            System.out.println();
        }
    }
}