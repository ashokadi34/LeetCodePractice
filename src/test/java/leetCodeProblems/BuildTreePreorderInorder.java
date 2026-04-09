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

import leetCodePractice.BalancedBinaryTree.TreeNode;

public class BuildTreePreorderInorder {
 private int[] preorder;
 private Map<Integer, Integer> inorderIndexMap = new HashMap<>();

 public TreeNode buildTree(int[] preorder, int[] inorder) {
     int n = preorder.length;
     this.preorder = preorder;
     
     // Build O(1) lookup map for inorder indices
     for (int i = 0; i < n; i++) {
         inorderIndexMap.put(inorder[i], i);
     }
     
     // Build entire tree from indices 0,0 with n nodes
     return dfs(0, 0, n);
 }
 
 private TreeNode dfs(int preStart, int inStart, int subtreeSize) {
     // Base case: empty subtree
     if (subtreeSize <= 0) {
         return null;
     }
     
     // Root is always first in preorder segment
     int rootVal = preorder[preStart];
     int rootInorderIdx = inorderIndexMap.get(rootVal);
     
     // Left subtree size = nodes before root in inorder
     int leftSize = rootInorderIdx - inStart;
     
     // Build left: preorder[preStart+1...], inorder[inStart...], leftSize nodes
     TreeNode leftChild = dfs(preStart + 1, inStart, leftSize);
     
     // Build right: preorder[after root+left], inorder[after root], remaining nodes
     TreeNode rightChild = dfs(preStart + 1 + leftSize, rootInorderIdx + 1, 
                              subtreeSize - leftSize - 1);
     
     return new TreeNode(rootVal, leftChild, rightChild);
 }



 public static void main(String[] args) {
	 BuildTreePreorderInorder sol = new BuildTreePreorderInorder();
     
     // Example 1 → [3,9,20,null,null,15,7]
     int[] pre1 = {3,9,20,15,7};
     int[] in1 = {9,3,15,20,7};
     TreeNode root1 = sol.buildTree(pre1, in1);
     printTree(root1);
     
     // Example 2 → [-1]
     int[] pre2 = {-1};
     int[] in2 = {-1};
     TreeNode root2 = sol.buildTree(pre2, in2);
     printTree(root2);
 }
 
 // Helper to print tree (preorder for verification)
 private static void printTree(TreeNode root) {
     if (root == null) {
         System.out.println("[]");
         return;
     }
     System.out.print("[" + root.val);
     printTree(root.left);
     printTree(root.right);
     System.out.print("]");
 }
}
