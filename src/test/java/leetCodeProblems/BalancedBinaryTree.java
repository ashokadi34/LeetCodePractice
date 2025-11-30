package leetCodeProblems;

public class BalancedBinaryTree {

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Solution class
    public static class Solution {
        public boolean isBalanced(TreeNode root) {
            return checkHeight(root) != -1;
        }

        private int checkHeight(TreeNode node) {
            if (node == null) return 0;

            int leftHeight = checkHeight(node.left);
            if (leftHeight == -1) return -1;

            int rightHeight = checkHeight(node.right);
            if (rightHeight == -1) return -1;

            if (Math.abs(leftHeight - rightHeight) > 1) return -1;
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    // Sample main for local testing
    public static void main(String[] args) {
        // Example: root = [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution sol = new Solution();
        System.out.println(sol.isBalanced(root)); // Output is : true

        // Example: root = [1,2,2,3,3,null,null,4,4]
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);
        root2.left.left.right = new TreeNode(4);

        System.out.println(sol.isBalanced(root2)); // Output is : false
    }
}

