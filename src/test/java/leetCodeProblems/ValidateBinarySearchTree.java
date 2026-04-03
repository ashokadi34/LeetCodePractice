package leetCodeProblems;

public class ValidateBinarySearchTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //isValidBST
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return validate(node.left, min, node.val) &&
               validate(node.right, node.val, max);
    }

    //Test cases
    public static void main(String[] args) {
    	ValidateBinarySearchTree sol = new ValidateBinarySearchTree();

        // Example 1: [2,1,3] -> true
        TreeNode root1 = new TreeNode(2,
                new TreeNode(1),
                new TreeNode(3)
        );
        System.out.println(sol.isValidBST(root1)); // true

        // Example 2: [5,1,4,null,null,3,6] -> false
        TreeNode root2 = new TreeNode(5,
                new TreeNode(1),
                new TreeNode(4, new TreeNode(3), new TreeNode(6))
        );
        System.out.println(sol.isValidBST(root2)); // false

        // Extra test: valid BST
        TreeNode root3 = new TreeNode(10,
                new TreeNode(5, new TreeNode(2), new TreeNode(7)),
                new TreeNode(15, new TreeNode(12), new TreeNode(20))
        );
        System.out.println(sol.isValidBST(root3)); // true
    }
}
