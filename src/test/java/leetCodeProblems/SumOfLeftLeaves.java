package leetCodeProblems;

import java.util.Arrays;

public class SumOfLeftLeaves {
	
  public static class TreeNode {
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
 
  	//functionality
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        
        int ans = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                ans += root.left.val;
            } else {
                ans += sumOfLeftLeaves(root.left);
            }
        }
        ans += sumOfLeftLeaves(root.right);
        return ans;
    }
    
    // Local testing - Eclipse/IntelliJ
    public static void main(String[] args) {
        SumOfLeftLeaves sol = new SumOfLeftLeaves();
        
        // Example 1: [3,9,20,null,null,15,7] → 24
        TreeNode n9 = new TreeNode(9);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);
        TreeNode n20 = new TreeNode(20, n15, n7);
        TreeNode root1 = new TreeNode(3, n9, n20);
        System.out.println("Example 1: " + sol.sumOfLeftLeaves(root1));  // 24
        
        // Example 2: [1] → 0
        TreeNode root2 = new TreeNode(1);
        System.out.println("Example 2: " + sol.sumOfLeftLeaves(root2));  // 0
        
        // Additional tests
        TreeNode leafLeft = new TreeNode(5);  // left leaf
        TreeNode root3 = new TreeNode(10, leafLeft, null);
        System.out.println("Left leaf only: " + sol.sumOfLeftLeaves(root3));  // 5
        
        TreeNode rightLeaf = new TreeNode(3);
        TreeNode root4 = new TreeNode(2, null, rightLeaf);
        System.out.println("Right leaf only: " + sol.sumOfLeftLeaves(root4));  // 0
    }
}

