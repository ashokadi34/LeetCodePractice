package leetCodeProblems;

import java.util.*;

public class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller one to use less space
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> freq = new HashMap<>();

        // Count frequencies of elements in nums1
        for (int num : nums1) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        // For each element in nums2, if it exists in map with count > 0, add to result
        for (int num : nums2) {
            Integer count = freq.get(num);
            if (count != null && count > 0) {
                result.add(num);
                freq.put(num, count - 1);
            }
        }

        // Convert List<Integer> to int[]
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    // Test method - run this in Eclipse
    public static void main(String[] args) {
        IntersectionOfTwoArrays sol = new IntersectionOfTwoArrays();
        
        // Example 1
        int[] nums1_1 = {1,2,2,1};
        int[] nums2_1 = {2,2};
        System.out.print("Test 1: ");
        printArray(sol.intersect(nums1_1, nums2_1));  // Expected: [2,2]
        
        // Example 2  
        int[] nums1_2 = {4,9,5};
        int[] nums2_2 = {9,4,9,8,4};
        System.out.print("Test 2: ");
        printArray(sol.intersect(nums1_2, nums2_2));  // Expected: [4,9] or [9,4]
        
        // Edge case: empty intersection
        int[] nums1_3 = {1,2,3};
        int[] nums2_3 = {4,5,6};
        System.out.print("Test 3: ");
        printArray(sol.intersect(nums1_3, nums2_3));  // Expected: []
        
        // Edge case: duplicate heavy
        int[] nums1_4 = {1,1,1};
        int[] nums2_4 = {1,1};
        System.out.print("Test 4: ");
        printArray(sol.intersect(nums1_4, nums2_4));  // Expected: [1,1]
    }
    
    	// Writing printArray method
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(",");
        }
        System.out.println("]");
    }
}


