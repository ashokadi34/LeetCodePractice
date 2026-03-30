package leetCodeProblems;

import java.util.*;

public class UniqueBinarySearchTreesII {

    public static class TreeNode {
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

    static class Solution {
        public List<TreeNode> generateTrees(int n) {
            if (n == 0) return new ArrayList<>();
            return build(1, n);
        }

        private List<TreeNode> build(int start, int end) {
            List<TreeNode> res = new ArrayList<>();

            if (start > end) {
                res.add(null);
                return res;
            }

            for (int rootVal = start; rootVal <= end; rootVal++) {
                List<TreeNode> leftTrees = build(start, rootVal - 1);
                List<TreeNode> rightTrees = build(rootVal + 1, end);

                for (TreeNode left : leftTrees) {
                    for (TreeNode right : rightTrees) {
                        TreeNode root = new TreeNode(rootVal);
                        root.left = left;
                        root.right = right;
                        res.add(root);
                    }
                }
            }

            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int n1 = 3;
        List<TreeNode> trees1 = sol.generateTrees(n1);
        System.out.println("n = " + n1);
        for (TreeNode root : trees1) {
            System.out.println(serialize(root));
        }

        int n2 = 1;
        List<TreeNode> trees2 = sol.generateTrees(n2);
        System.out.println("\nn = " + n2);
        for (TreeNode root : trees2) {
            System.out.println(serialize(root));
        }
    }

    // Serialize tree in level order like LeetCode style
    private static String serialize(TreeNode root) {
        if (root == null) return "[]";

        List<String> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                result.add("null");
            } else {
                result.add(String.valueOf(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        int i = result.size() - 1;
        while (i >= 0 && result.get(i).equals("null")) {
            i--;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int j = 0; j <= i; j++) {
            sb.append(result.get(j));
            if (j < i) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}