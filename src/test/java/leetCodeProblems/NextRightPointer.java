package leetCodeProblems;

import java.util.*;

class Node {
    int val;
    Node left, right, next;
    
    Node() {}
    
    Node(int val) { 
        this.val = val; 
    }
    
    Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}

public class NextRightPointer {
    public Node connect(Node root) {
        if (root == null) return null;
        
        Node leftmost = root;
        while (leftmost.left != null) {
            Node head = leftmost;
            while (head != null) {
                // Connect left child to right child
                head.left.next = head.right;
                
                // Connect right child to next parent's left child
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }
    
    // Helper to print tree structure with next pointers (level order)
    private static void printTree(Node root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        List<String> result = new ArrayList<>();
        
        while (!q.isEmpty()) {
            int size = q.size();
            List<String> level = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                if (node != null) {
                    level.add(String.valueOf(node.val));
                    q.offer(node.left);
                    q.offer(node.right);
                    
                    // Show next pointer connection
                    String nextStr = (node.next != null) ? "->" + node.next.val : "#";
                    level.set(level.size() - 1, node.val + nextStr);
                }
            }
            if (!level.isEmpty()) {
                result.add(String.join(",", level));
            }
        }
        System.out.println("[" + String.join(",", result) + "]");
    }
    
    // Test cases
    public static void main(String[] args) {
        NextRightPointer sol = new NextRightPointer();
        
        System.out.println("=== Example 1: [1,2,3,4,5,6,7] ===");
        Node root1 = new Node(1);
        root1.left = new Node(2); 
        root1.right = new Node(3);
        root1.left.left = new Node(4); 
        root1.left.right = new Node(5);
        root1.right.left = new Node(6); 
        root1.right.right = new Node(7);
        
        System.out.print("Input: ");
        printTree(root1);
        
        sol.connect(root1);
        System.out.print("Output: ");
        printTree(root1);  // Expected: [1#,2->3#,4->5->6->7#]
        
        System.out.println("\n=== Example 2: Empty Tree ===");
        System.out.print("Input: ");
        printTree(null);
        Node result2 = sol.connect(null);
        System.out.print("Output: ");
        printTree(result2);
    }
}