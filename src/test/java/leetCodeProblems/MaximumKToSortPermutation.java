package leetCodeProblems;
 
import java.util.Scanner;

public class MaximumKToSortPermutation {

    public int sortPermutation(int[] nums) {
        int answer = -1; // all bits set initially

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                answer &= nums[i];
            }
        }

        return Math.max(answer, 0);
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

        MaximumKToSortPermutation solution = new MaximumKToSortPermutation();
        int result = solution.sortPermutation(nums);

        System.out.println("Output: " + result);

        scanner.close();
    }
}