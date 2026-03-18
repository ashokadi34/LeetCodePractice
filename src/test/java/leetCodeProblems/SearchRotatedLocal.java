package leetCodeProblems;

public class SearchRotatedLocal {
    static class Solution {
        public boolean search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            
            while (left <= right) {
                int mid = left + (right - left) / 2;
                
                if (nums[mid] == target) {
                    return true;
                }
                
                // Left half sorted
                if (nums[mid] > nums[right]) {
                    if (nums[left] <= target && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                // Right half sorted
                else if (nums[mid] < nums[right]) {
                    if (nums[mid] < target && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                // Duplicates: nums[mid] == nums[right], shrink
                else {
                    right--;
                }
            }
            return false;
        }
    }

    //Test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test 1: [2,5,6,0,0,1,2], target=0 → true
        int[] nums1 = {2,5,6,0,0,1,2};
        System.out.println("Test1 target=0 → " + sol.search(nums1, 0));

        // Test 2: [2,5,6,0,0,1,2], target=3 → false
        System.out.println("Test2 target=3 → " + sol.search(nums1, 3));

        // Test 3: all duplicates [1,1,1,1], target=1 → true
        int[] nums3 = {1,1,1,1};
        System.out.println("Test3 all 1s, target=1 → " + sol.search(nums3, 1));

        // Test 4: all duplicates, not found [1,1,1,1], target=2 → false
        System.out.println("Test4 all 1s, target=2 → " + sol.search(nums3, 2));

        // Test 5: no rotation [1,2,3,4,5], target=3 → true
        int[] nums5 = {1,2,3,4,5};
        System.out.println("Test5 sorted, target=3 → " + sol.search(nums5, 3));

        // Test 6: single element [5], target=5 → true
        int[] nums6 = {5};
        System.out.println("Test6 single → " + sol.search(nums6, 5));
    }
}
