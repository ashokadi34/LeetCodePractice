package leetCodeProblems;

import java.util.Arrays;

public class MinMoves2 {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int median = nums[nums.length / 2];
        long moves = 0;

        for (int num : nums) {
            moves += Math.abs((long) num - median);
        }

        return (int) moves;
    }

    public static void main(String[] args) {
        MinMoves2 solution = new MinMoves2();

        int[][] testCases = {
            {1, 2, 3},
            {1, 10, 2, 9},
            {1, 1, 1},
            {5},
            {-3, -2, -1},
            {1, 2, 3, 4}
        };

        int[] expected = {2, 16, 0, 0, 2, 4};

        for (int i = 0; i < testCases.length; i++) {
            // Pass a copy because minMoves2 sorts its input.
            int[] nums = testCases[i].clone();
            int result = solution.minMoves2(nums);

            System.out.println("Test case " + (i + 1));
            System.out.println(
                "Input:    " + Arrays.toString(testCases[i])
            );
            System.out.println("Output:   " + result);
            System.out.println("Expected: " + expected[i]);
            System.out.println(
                "Status:   " + (result == expected[i] ? "PASS" : "FAIL")
            );
            System.out.println();
        }
    }
}