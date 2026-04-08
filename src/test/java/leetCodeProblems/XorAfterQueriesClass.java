package leetCodeProblems;

/*
//TreeNode definition
class TreeNode {
 int val;
 TreeNode left;
 TreeNode right;
 TreeNode() {}
 TreeNode(int val) { this.val = val; }
 TreeNode(int val, TreeNode left, TreeNode right) {
     this.val = val;
     this.left = left;
     this.right = right;
 }
}
*/

public class XorAfterQueriesClass {
 private static final int MOD = 1_000_000_007;

 public int xorAfterQueries(int[] nums, int[][] queries) {
     for (int[] query : queries) {
         int left  = query[0];
         int right = query[1];
         int step  = query[2];
         int value = query[3];

         for (int idx = left; idx <= right; idx += step) {
             nums[idx] = (int) ((long) nums[idx] * value % MOD);
         }
     }

     int answer = 0;
     for (int num : nums) {
         answer ^= num;
     }
     return answer;
 }
 public static void main(String[] args) {
	 XorAfterQueriesClass sol = new XorAfterQueriesClass();

     // Example 1 → Expected: 4
     int[] nums1 = {1, 1, 1};
     int[][] queries1 = {{0, 2, 1, 4}};
     System.out.println("Example 1: " + sol.xorAfterQueries(nums1, queries1));

     // Example 2 → Expected: 31
     int[] nums2 = {2, 3, 1, 5, 4};
     int[][] queries2 = {{1, 4, 2, 3}, {0, 2, 1, 2}};
     System.out.println("Example 2: " + sol.xorAfterQueries(nums2, queries2));
 }
}


 
