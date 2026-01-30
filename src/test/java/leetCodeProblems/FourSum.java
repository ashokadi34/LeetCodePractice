package leetCodeProblems;

import java.util.*;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if ((long) nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) continue;
            
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                if ((long) nums[j] + nums[j + 1] + nums[j + 2] > target - nums[i]) break;
                if ((long) nums[j] + nums[n - 2] + nums[n - 1] < target - nums[i]) continue;
                
                int low = j + 1, high = n - 1;
                int tempTarget = target - nums[i] - nums[j];
                while (low < high) {
                    int curSum = nums[low] + nums[high];
                    if (curSum == tempTarget) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        low++;
                        high--;
                        while (low < high && nums[low] == nums[low - 1]) low++;
                        while (low < high && nums[high] == nums[high + 1]) high--;
                    } else if (curSum < tempTarget) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return result;
    }

    //Test cases
    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int target1 = 0;
        System.out.println("Input: [1,0,-1,0,-2,2], target=0");
        for (List<Integer> quad : fourSum(nums1, target1)) {
            System.out.print(quad + " ");
        }
        System.out.println();

        // Example 2
        int[] nums2 = {2, 2, 2, 2, 2};
        int target2 = 8;
        System.out.println("Input: [2,2,2,2,2], target=8");
        for (List<Integer> quad : fourSum(nums2, target2)) {
            System.out.print(quad + " ");
        }
        System.out.println();
    }
}

