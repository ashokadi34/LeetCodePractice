package leetCodeProblems;

public class RecoverBST {
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

    //Function
    static class Solution {
        private TreeNode prev;
        private TreeNode first;
        private TreeNode second;

        public void recoverTree(TreeNode root) {
            prev = null;
            first = null;
            second = null;

            dfs(root);

            if (first != null && second != null) {
                int temp = first.val;
                first.val = second.val;
                second.val = temp;
            }
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }

            dfs(root.left);

            if (prev != null && prev.val > root.val) {
                if (first == null) {
                    first = prev;
                }
                second = root;
            }

            prev = root;
            dfs(root.right);
        }
    }

    //Test cases
    public static void main(String[] args) {
        // Example 1: [1,3,null,null,2]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.left.right = new TreeNode(2);

        Solution sol1 = new Solution();
        System.out.print("Before recover root1 inorder: ");
        printInOrder(root1);
        System.out.println();

        sol1.recoverTree(root1);

        System.out.print("After recover root1 inorder:  ");
        printInOrder(root1);
        System.out.println();

        // Example 2: [3,1,4,null,null,2]
        TreeNode root2 = new TreeNode(3, new TreeNode(1), new TreeNode(4));
        root2.right.left = new TreeNode(2);

        Solution sol2 = new Solution();
        System.out.print("Before recover root2 inorder: ");
        printInOrder(root2);
        System.out.println();

        sol2.recoverTree(root2);

        System.out.print("After recover root2 inorder:  ");
        printInOrder(root2);
        System.out.println();
    }

    private static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }
}