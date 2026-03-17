package leetCodeProblems;

public class RemoveDuplicatesLocal {
    static class Solution {
        public int removeDuplicates(int[] nums) {
            int n = nums.length;
            if (n <= 2) return n;
            
            int k = 2;  // First two elements always valid
            
            for (int i = 2; i < n; i++) {
                // If current != the one two positions back, it's new or third duplicate
                if (nums[i] != nums[k - 2]) {
                    nums[k++] = nums[i];
                }
            }
            return k;
        }
    }

    //Test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test 1: [1,1,1,2,2,3] → 5, [1,1,2,2,3,_]
        int[] nums1 = {1,1,1,2,2,3};
        int k1 = sol.removeDuplicates(nums1);
        System.out.print("Test1: k=" + k1 + ", nums=[");
        for (int i = 0; i < k1; i++) System.out.print(nums1[i] + (i < k1-1 ? "," : ""));
        System.out.println("]");

        // Test 2: [0,0,1,1,1,1,2,3,3] → 7, [0,0,1,1,2,3,3,_,_]
        int[] nums2 = {0,0,1,1,1,1,2,3,3};
        int k2 = sol.removeDuplicates(nums2);
        System.out.print("Test2: k=" + k2 + ", nums=[");
        for (int i = 0; i < k2; i++) System.out.print(nums2[i] + (i < k2-1 ? "," : ""));
        System.out.println("]");

        // Test 3: length <=2 [1,1] → 2
        int[] nums3 = {1,1};
        int k3 = sol.removeDuplicates(nums3);
        System.out.println("Test3: k=" + k3 + ", nums=[1,1]");

        // Test 4: no duplicates [1,2,3] → 3
        int[] nums4 = {1,2,3};
        int k4 = sol.removeDuplicates(nums4);
        System.out.println("Test4: k=" + k4 + ", nums=[1,2,3]");

        // Test 5: all same [5,5,5] → 2, [5,5]
        int[] nums5 = {5,5,5};
        int k5 = sol.removeDuplicates(nums5);
        System.out.println("Test5: k=" + k5 + ", nums=[5,5]");
    }
}
