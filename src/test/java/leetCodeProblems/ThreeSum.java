package leetCodeProblems;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];
            
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicates for left
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicates for right
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        ThreeSum sol = new ThreeSum();
        
        // Example 1: [-1,0,1,2,-1,-4] → [[-1,-1,2],[-1,0,1]]
        int[] nums1 = {-1,0,1,2,-1,-4};
        System.out.println(sol.threeSum(nums1));
        
        // Example 2: [0,1,1] → []
        int[] nums2 = {0,1,1};
        System.out.println(sol.threeSum(nums2));
        
        // Example 3: [0,0,0] → [[0,0,0]]
        int[] nums3 = {0,0,0};
        System.out.println(sol.threeSum(nums3));
    }
}

