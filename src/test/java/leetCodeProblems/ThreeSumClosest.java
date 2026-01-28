package leetCodeProblems;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }
                
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return sum;  // Exact match
                }
            }
        }
        return closestSum;
    }
    
    //Test cases
    public static void main(String[] args) {
        ThreeSumClosest sol = new ThreeSumClosest();
        
        // Example 1: [-1,2,1,-4], target=1 → 2
        int[] nums1 = {-1,2,1,-4};
        System.out.println(sol.threeSumClosest(nums1, 1));  // 2
        
        // Example 2: [0,0,0], target=1 → 0
        int[] nums2 = {0,0,0};
        System.out.println(sol.threeSumClosest(nums2, 1));  // 0
        
        // Additional test: [1,1,1,1], target=3 → 3
        int[] nums3 = {1,1,1,1};
        System.out.println(sol.threeSumClosest(nums3, 3));  // 3
    }
}

