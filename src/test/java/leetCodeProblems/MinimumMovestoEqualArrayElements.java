package leetCodeProblems;
import java.util.Arrays;

public class MinimumMovestoEqualArrayElements {

    public int minMoves(int[] nums) {
        int min = nums[0];

        for (int num : nums) {
            min = Math.min(min, num);
        }

        long moves = 0;

        for (int num : nums) {
            moves += (long) num - min;
        }

        return (int) moves;
    }

    public static void main(String[] args) {
        MinimumMovestoEqualArrayElements solution = new MinimumMovestoEqualArrayElements();

        int[][] testCases = {
            {1, 2, 3},
            {1, 1, 1},
            {5},
            {-3, -2, -1},
            {1, 2, 3, 4}
        };

        int[] expected = {3, 0, 0, 3, 6};

        for (int i = 0; i < testCases.length; i++) {
            int result = solution.minMoves(testCases[i]);

            System.out.println("Test case " + (i + 1));
            System.out.println("Input:    " + Arrays.toString(testCases[i]));
            System.out.println("Output:   " + result);
            System.out.println("Expected: " + expected[i]);
            System.out.println(
                "Status:   " + (result == expected[i] ? "PASS" : "FAIL")
            );
            System.out.println();
        }
    }
}