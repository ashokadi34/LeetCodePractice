package leetCodeProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SummaryRangesLocal {
    
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int n = nums.length;
        if (n == 0) return res;

        int start = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    res.add(String.valueOf(start));
                } else {
                    res.add(start + "->" + nums[i - 1]);
                }
                start = nums[i];
            }
        }

        if (start == nums[n - 1]) {
            res.add(String.valueOf(start));
        } else {
            res.add(start + "->" + nums[n - 1]);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Test Example 1: [0,1,2,4,5,7]
        int[] nums1 = {0,1,2,4,5,7};
        System.out.println("Example 1: " + nums1[0]);
        for (int i : nums1) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Output: " + summaryRanges(nums1));
        System.out.println();

        // Test Example 2: [0,2,3,4,6,8,9]
        int[] nums2 = {0,2,3,4,6,8,9};
        System.out.println("Example 2: " + nums2[0]);
        for (int i : nums2) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Output: " + summaryRanges(nums2));
        System.out.println();

        // Interactive testing
        System.out.println("Enter numbers (space separated) or 'quit':");
        while (true) {
            String input = sc.nextLine();
            if (input.equals("quit")) break;
            
            String[] parts = input.split(" ");
            if (parts.length == 0) continue;
            
            int[] customNums = new int[parts.length];
            try {
                for (int i = 0; i < parts.length; i++) {
                    customNums[i] = Integer.parseInt(parts[i]);
                }
                System.out.println("Output: " + summaryRanges(customNums));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, use integers only.");
            }
        }
        //close
        sc.close();
    }
}

