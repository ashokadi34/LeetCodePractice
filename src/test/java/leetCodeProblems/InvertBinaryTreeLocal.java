package leetCodeProblems;

public class InvertBinaryTreeLocal {

    // TreeNode definition
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftInverted = invertTree(root.left);
        TreeNode rightInverted = invertTree(root.right);

        root.left = rightInverted;
        root.right = leftInverted;

        return root;
    }

    // Utility method to print inorder traversal of the tree
    public void inorderPrint(TreeNode root) {
        if (root != null) {
            inorderPrint(root.left);
            System.out.print(root.val + " ");
            inorderPrint(root.right);
        }
    }

    // Example to build a binary tree and test invertTree
    public static void main(String[] args) {
        InvertBinaryTreeLocal solution = new InvertBinaryTreeLocal();

        // Build tree: [4,2,7,1,3,6,9]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.println("Original tree inorder:");
        solution.inorderPrint(root);
        System.out.println();

        root = solution.invertTree(root);

        System.out.println("Inverted tree inorder:");
        solution.inorderPrint(root);
        System.out.println();

 
    }
}

