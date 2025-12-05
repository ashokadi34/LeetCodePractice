package leetCodeProblems;

import java.util.Scanner;

public class CountPartitionsLocal {
    
    public static int countPartitions(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        return total % 2 == 0 ? nums.length - 1 : 0;
    }
    
    // Verify by brute force checking all partitions
    public static int verifyBruteForce(int[] nums) {
        int count = 0;
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        
        for (int i = 0; i < n - 1; i++) {
            int leftSum = 0;
            for (int j = 0; j <= i; j++) {
                leftSum += nums[j];
            }
            int rightSum = totalSum - leftSum;
            if (Math.abs(leftSum - rightSum) % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Test Example 1: [10,10,3,7,6]
        int[] nums1 = {10,10,3,7,6};
        System.out.println("Example 1: " + java.util.Arrays.toString(nums1));
        int result1 = countPartitions(nums1);
        int verify1 = verifyBruteForce(nums1);
        System.out.println("Result: " + result1 + " (verified: " + verify1 + ")");
        System.out.println();
        
        // Test Example 2: [1,2,2]
        int[] nums2 = {1,2,2};
        System.out.println("Example 2: " + java.util.Arrays.toString(nums2));
        int result2 = countPartitions(nums2);
        int verify2 = verifyBruteForce(nums2);
        System.out.println("Result: " + result2 + " (verified: " + verify2 + ")");
        System.out.println();
        
        // Test Example 3: [2,4,6,8]
        int[] nums3 = {2,4,6,8};
        System.out.println("Example 3: " + java.util.Arrays.toString(nums3));
        int result3 = countPartitions(nums3);
        int verify3 = verifyBruteForce(nums3);
        System.out.println("Result: " + result3 + " (verified: " + verify3 + ")");
        System.out.println();
        
        // Interactive testing
        System.out.println("Enter numbers (space separated) or 'quit':");
        while (true) {
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("quit")) break;
            
            String[] parts = input.split("\\s+");
            if (parts.length < 2) {
                System.out.println("Need at least 2 numbers.");
                continue;
            }
            
            try {
                int[] customNums = new int[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    customNums[i] = Integer.parseInt(parts[i]);
                }
                int result = countPartitions(customNums);
                int verify = verifyBruteForce(customNums);
                System.out.println("Result: " + result + " (verified: " + verify + ")");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, use integers only.");
            }
        }
        //close the scan
        sc.close();
    }
}

