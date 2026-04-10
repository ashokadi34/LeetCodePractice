package leetCodeProblems;

import java.util.*;
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

class BuildTreeInorderPostorder {
 private int[] postorder;
 private Map<Integer, Integer> inorderIndexMap = new HashMap<>();

 public TreeNode buildTree(int[] inorder, int[] postorder) {
     int n = inorder.length;
     this.postorder = postorder;
     
     // Build O(1) lookup map for inorder indices
     for (int i = 0; i < n; i++) {
         inorderIndexMap.put(inorder[i], i);
     }
     
     // Build entire tree from indices 0,0 with n nodes
     return dfs(0, 0, n);
 }
 
 private TreeNode dfs(int inStart, int postStart, int subtreeSize) {
     // Base case: empty subtree
     if (subtreeSize <= 0) {
         return null;
     }
     
     // Root is always last in postorder segment
     int rootVal = postorder[postStart + subtreeSize - 1];
     int rootInorderIdx = inorderIndexMap.get(rootVal);
     
     // Left subtree size = nodes before root in inorder
     int leftSize = rootInorderIdx - inStart;
     
     // Build left: postorder[postStart...], inorder[inStart...], leftSize nodes
     TreeNode leftChild = dfs(inStart, postStart, leftSize);
     
     // Build right: postorder[after left], inorder[after root], remaining nodes
     TreeNode rightChild = dfs(rootInorderIdx + 1, postStart + leftSize, 
                              subtreeSize - leftSize - 1);
     
     return new TreeNode(rootVal, leftChild, rightChild);
 }

 public static void main(String[] args) {
	 BuildTreeInorderPostorder sol = new BuildTreeInorderPostorder();
     
     // Example 1 → [3,9,20,null,null,15,7]
     int[] in1 = {9,3,15,20,7};
     int[] post1 = {9,15,7,20,3};
     TreeNode root1 = sol.buildTree(in1, post1);
     printTree(root1);
     
     // Example 2 → [-1]
     int[] in2 = {-1};
     int[] post2 = {-1};
     TreeNode root2 = sol.buildTree(in2, post2);
     printTree(root2);
 }
 
 // Helper to print tree (inorder for verification)
 private static void printTree(TreeNode root) {
     if (root == null) {
         System.out.println("[]");
         return;
     }
     printTree(root.left);
     System.out.print(root.val + " ");
     printTree(root.right);
     if (root.left == null && root.right == null) {
         System.out.println();
     }
 }
}
