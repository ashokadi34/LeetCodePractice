package leetCodeProblems;

import java.util.ArrayList;
import java.util.List;

public class Flatten {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { 
            this.val = val; 
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public static void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode rightMost = curr.left;
                while (rightMost.right != null) {
                    rightMost = rightMost.right;
                }
                rightMost.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
    
    // Helper to print tree preorder (shows input structure)
    private static void printTree(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        preorderTraversal(root, preorder);
        System.out.println("Input tree (preorder): " + preorder);
    }
    
    private static void preorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            result.add(null);
            return;
        }
        result.add(root.val);
        preorderTraversal(root.left, result);
        preorderTraversal(root.right, result);
    }
    
    // Helper to print flattened list
    private static void printFlattened(TreeNode root) {
        List<Integer> flattened = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            flattened.add(curr.val);
            curr = curr.right;
        }
        System.out.println("Output flattened: " + flattened);
    }
    
    //Test cases
    public static void main(String[] args) {
        
        System.out.println("=== Example 1 ===");
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2); 
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(3); 
        root1.left.right = new TreeNode(4);
        root1.right.right = new TreeNode(6);
        
        printTree(root1);
        flatten(root1);
        printFlattened(root1);
        
        System.out.println("\n=== Example 2 (Empty) ===");
        printTree(null);
       flatten(null);
        printFlattened(null);
        
        System.out.println("\n=== Example 3 (Single Node) ===");
        TreeNode root3 = new TreeNode(0);
        printTree(root3);
       flatten(root3);
        printFlattened(root3);
    }
}