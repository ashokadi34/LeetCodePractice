package leetCodeProblems;

public class MaxDistance {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int ans = 0;
        
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                i++;
            } else {
                ans = Math.max(ans, j - i);
                j++;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        MaxDistance sol = new MaxDistance();
        
        int[] nums1_1 = {55,30,5,4,2};
        int[] nums2_1 = {100,20,10,10,5};
        System.out.println("Ex1: " + sol.maxDistance(nums1_1, nums2_1)); // 2
        
        int[] nums1_2 = {2,2,2};
        int[] nums2_2 = {10,10,1};
        System.out.println("Ex2: " + sol.maxDistance(nums1_2, nums2_2)); // 1
        
        int[] nums1_3 = {30,29,19,5};
        int[] nums2_3 = {25,25,25,25,25};
        System.out.println("Ex3: " + sol.maxDistance(nums1_3, nums2_3)); // 2
    }
}
