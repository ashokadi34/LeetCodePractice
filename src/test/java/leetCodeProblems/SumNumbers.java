package leetCodeProblems;

/*
//Definition for a binary tree node.
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

public class SumNumbers {
 public int sumNumbers(TreeNode root) {
     return dfs(root, 0);
 }
 
 private int dfs(TreeNode node, int currentSum) {
     if (node == null) return 0;
     currentSum = currentSum * 10 + node.val;
     if (node.left == null && node.right == null) {
         return currentSum;
     }
     return dfs(node.left, currentSum) + dfs(node.right, currentSum);
 }

 // Main method for local testing
 public static void main(String[] args) {
     SumNumbers sol = new SumNumbers();
     
     // Example 1: root = [1,2,3]
     TreeNode root1 = new TreeNode(1);
     root1.left = new TreeNode(2);
     root1.right = new TreeNode(3);
     System.out.println(sol.sumNumbers(root1)); // Output: 25
     
     // Example 2: root = [4,9,0,5,1]
     TreeNode root2 = new TreeNode(4);
     root2.left = new TreeNode(9);
     root2.right = new TreeNode(0);
     root2.left.left = new TreeNode(5);
     root2.left.right = new TreeNode(1);
     System.out.println(sol.sumNumbers(root2)); // Output: 1026
 }
}