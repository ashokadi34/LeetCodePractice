package leetCodeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreePathsLocal {

    // Definition for a binary tree node.
    static class TreeNode {
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

    // LeetCode-style solution
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, "", res);
        return res;
    }

    private static void dfs(TreeNode node, String path, List<String> res) {
        if (node == null) return;

        // build current path
        if (path.length() == 0) {
            path = Integer.toString(node.val);
        } else {
            path = path + "->" + node.val;
        }

        // if leaf, add path
        if (node.left == null && node.right == null) {
            res.add(path);
            return;
        }

        // continue DFS
        dfs(node.left, path, res);
        dfs(node.right, path, res);
    }

    // Helper: build tree from level-order array like [1,2,3,null,5]
    // Use Integer[] where null means no node.
    public static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode curr = q.poll();
            // left child
            if (i < arr.length && arr[i] != null) {
                curr.left = new TreeNode(arr[i]);
                q.offer(curr.left);
            }
            i++;
            // right child
            if (i < arr.length && arr[i] != null) {
                curr.right = new TreeNode(arr[i]);
                q.offer(curr.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        // Example 1: root = [1,2,3,null,5]
        Integer[] arr1 = {1, 2, 3, null, 5};
        TreeNode root1 = buildTree(arr1);
        System.out.println("Example 1 output: " + binaryTreePaths(root1));
        // Expected: ["1->2->5", "1->3"]

        // Example 2: root = [1]
        Integer[] arr2 = {1};
        TreeNode root2 = buildTree(arr2);
        System.out.println("Example 2 output: " + binaryTreePaths(root2));
        // Expected: ["1"]

        // Extra test
        Integer[] arr3 = {1, 2, 3, 4, null, null, 5};
        TreeNode root3 = buildTree(arr3);
        System.out.println("Extra test output: " + binaryTreePaths(root3));

        // You can also quickly change arrays above for more tests
        System.out.println("Done.");
    }
}

