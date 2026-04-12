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

public class LevelOrderBottom {
 public List<List<Integer>> levelOrderBottom(TreeNode root) {
     List<List<Integer>> result = new LinkedList<>();  // Deque for O(1) addFirst
     
     if (root == null) {
         return result;
     }
     
     Queue<TreeNode> queue = new LinkedList<>();
     queue.offer(root);
     
     while (!queue.isEmpty()) {
         int levelSize = queue.size();
         List<Integer> currentLevel = new ArrayList<>();
         
         for (int i = 0; i < levelSize; i++) {
             TreeNode node = queue.poll();
             currentLevel.add(node.val);
             
             if (node.left != null) {
                 queue.offer(node.left);
             }
             if (node.right != null) {
                 queue.offer(node.right);
             }
         }
         
         // Add to front for bottom-up order
         result.add(0, currentLevel);
     }
     
     return result;
 }
 
 public static void main(String[] args) {
	 LevelOrderBottom sol = new LevelOrderBottom();
     
     // Example 1 → [[15,7],[9,20],[3]]
     TreeNode root1 = new TreeNode(3);
     root1.left = new TreeNode(9);
     root1.right = new TreeNode(20);
     root1.right.left = new TreeNode(15);
     root1.right.right = new TreeNode(7);
     System.out.println(sol.levelOrderBottom(root1));
     
     // Example 2 → [[1]]
     TreeNode root2 = new TreeNode(1);
     System.out.println(sol.levelOrderBottom(root2));
     
     // Example 3 → []
     System.out.println(sol.levelOrderBottom(null));
 
 }
}


 
