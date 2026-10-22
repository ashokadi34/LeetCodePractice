package leetCodeProblems;


import java.util.Scanner;

public class MinimumOperationsToSortPermutation {

    public int minOperations(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return 0;
        }

        // Case 1: nums is a cyclic rotation of [0, 1, ..., n - 1]
        int rotationOffset = nums[0];
        boolean isRotation = true;

        for (int i = 0; i < n; i++) {
            if (nums[i] != (i + rotationOffset) % n) {
                isRotation = false;
                break;
            }
        }

        if (isRotation) {
            int directRotations = (n - rotationOffset) % n;

            // Alternative: reverse -> rotate left `rotationOffset` times -> reverse
            int reverseBased = rotationOffset == 0 ? 0 : rotationOffset + 2;

            return Math.min(directRotations, reverseBased);
        }

        // Case 2: nums is a reflection: nums[i] = (c - i) mod n
        int reflectionConstant = nums[0];
        boolean isReflection = true;

        for (int i = 0; i < n; i++) {
            int expected = ((reflectionConstant - i) % n + n) % n;

            if (nums[i] != expected) {
                isReflection = false;
                break;
            }
        }

        if (isReflection) {
            int rotateThenReverse = (reflectionConstant + 1) % n;
            int reverseThenRotate = n - 1 - reflectionConstant;

            return 1 + Math.min(rotateThenReverse, reverseThenRotate);
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = scanner.nextInt();

        int[] nums = new int[size];

        System.out.print("Enter " + size + " distinct integers from 0 to " + (size - 1) + ": ");
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }

        MinimumOperationsToSortPermutation solution =
                new MinimumOperationsToSortPermutation();

        int result = solution.minOperations(nums);

        System.out.println("Output: " + result);

        scanner.close();
    }
}