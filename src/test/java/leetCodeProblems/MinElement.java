package leetCodeProblems;

public class MinElement {

	// Function to find the minimum digit sum in the array
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            int sum = digitSum(num);
            min = Math.min(min, sum);
        }

        return min;
    }
    // Helper function to calculate the digit sum of a number
    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    //Test cases
    public static void main(String[] args) {
        MinElement sol = new MinElement();

        int[] nums1 = {10, 12, 13, 14};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {999, 19, 199};

        System.out.println(sol.minElement(nums1)); // 1
        System.out.println(sol.minElement(nums2)); // 1
        System.out.println(sol.minElement(nums3)); // 10
    }
}
