package leetCodeProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberOfWaysToReorderArrayToGetSameBST {

    private static final int MOD = 1_000_000_007;

    private long[][] combinations;

    public int numOfWays(int[] nums) {
        int n = nums.length;

        combinations = new long[n + 1][n + 1];
        buildPascalTriangle(n);

        List<Integer> values = new ArrayList<>();
        for (int num : nums) {
            values.add(num);
        }

        long totalWays = countWays(values);

        // Exclude the original ordering itself.
        return (int) ((totalWays - 1 + MOD) % MOD);
    }

    private long countWays(List<Integer> nums) {
        int size = nums.size();

        if (size <= 2) {
            return 1;
        }

        int root = nums.get(0);

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < size; i++) {
            int value = nums.get(i);

            if (value < root) {
                left.add(value);
            } else {
                right.add(value);
            }
        }

        long leftWays = countWays(left);
        long rightWays = countWays(right);

        long interleaveWays = combinations[size - 1][left.size()];

        return (interleaveWays * leftWays % MOD) * rightWays % MOD;
    }

    private void buildPascalTriangle(int n) {
        for (int i = 0; i <= n; i++) {
            combinations[i][0] = 1;

            for (int j = 1; j <= i; j++) {
                combinations[i][j] =
                        (combinations[i - 1][j - 1] + combinations[i - 1][j]) % MOD;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = scanner.nextInt();

        int[] nums = new int[size];

        System.out.print("Enter " + size + " distinct integers from 1 to " + size + ": ");
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }

        NumberOfWaysToReorderArrayToGetSameBST solution =
                new NumberOfWaysToReorderArrayToGetSameBST();

        int result = solution.numOfWays(nums);

        System.out.println("Output: " + result);

        scanner.close();
    }
}