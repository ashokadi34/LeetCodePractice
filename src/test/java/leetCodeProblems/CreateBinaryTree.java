package leetCodeProblems;

import java.util.*;

public class CreateBinaryTree {

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        
        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            int childVal = desc[1];
            int isLeft = desc[2];
            
            if (!nodeMap.containsKey(parentVal)) {
                nodeMap.put(parentVal, new TreeNode(parentVal));
            }
            
            if (!nodeMap.containsKey(childVal)) {
                nodeMap.put(childVal, new TreeNode(childVal));
            }
            
            TreeNode parent = nodeMap.get(parentVal);
            TreeNode child = nodeMap.get(childVal);
            
            if (isLeft == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            
            children.add(childVal);
        }
        
        for (int val : nodeMap.keySet()) {
            if (!children.contains(val)) {
                return nodeMap.get(val);
            }
        }
        
        return null;
    }

    //test cases
    public static void main(String[] args) {
        CreateBinaryTree sol = new CreateBinaryTree();

        // Example 1
        int[][] descriptions1 = {
            {20, 15, 1},
            {20, 17, 0},
            {50, 20, 1},
            {50, 80, 0},
            {80, 19, 1}
        };
        TreeNode root1 = sol.createBinaryTree(descriptions1);
        System.out.println("Root value: " + root1.val); // 50

        // Example 2
        int[][] descriptions2 = {
            {1, 2, 1},
            {2, 3, 0},
            {3, 4, 1}
        };
        TreeNode root2 = sol.createBinaryTree(descriptions2);
        System.out.println("Root value: " + root2.val); // 1
    }
}