package leetCodeProblems;

public class MoveZeroesLocal {
    
    public static void moveZeroes(int[] nums) {
        int k = 0;  // position for next non-zero element
        
        // Move all non-zeros to front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            }
        }
        
        // Fill remaining positions with zeros
        while (k < nums.length) {
            nums[k] = 0;
            k++;
        }
    }
    
    // Helper function to print array
    public static void printArray(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        // Test Example 1
        int[] nums1 = {0, 1, 0, 3, 12};
        System.out.println("Example 1:");
        System.out.print("Input:  ");
        printArray(nums1);
        moveZeroes(nums1);
        System.out.print("Output: ");
        printArray(nums1);
        
        // Test Example 2
        int[] nums2 = {0};
        System.out.println("\nExample 2:");
        System.out.print("Input:  ");
        printArray(nums2);
        moveZeroes(nums2);
        System.out.print("Output: ");
        printArray(nums2);
        
        // Additional test cases
        int[] nums3 = {1, 0, 1};
        System.out.println("\nTest case 3:");
        System.out.print("Input:  ");
        printArray(nums3);
        moveZeroes(nums3);
        System.out.print("Output: ");
        printArray(nums3);
        
        int[] nums4 = {0, 0, 1};
        System.out.println("\nTest case 4:");
        System.out.print("Input:  ");
        printArray(nums4);
        moveZeroes(nums4);
        System.out.print("Output: ");
        printArray(nums4);
        
        int[] nums5 = {1, 1, 1};
        System.out.println("\nTest case 5:");
        System.out.print("Input:  ");
        printArray(nums5);
        moveZeroes(nums5);
        System.out.print("Output: ");
        printArray(nums5);
    }
}

