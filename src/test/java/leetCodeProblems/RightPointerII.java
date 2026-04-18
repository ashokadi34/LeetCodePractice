package leetCodeProblems;

import java.util.*;

class Node {
    int val;
    Node left, right, next;
    
    Node() {}
    
    Node(int val) { this.val = val; }
    
    Node(int val, Node left, Node right, Node next) {
        this.val = val; this.left = left; this.right = right; this.next = next;
    }
}

public class RightPointerII {
    public Node connect(Node root) {
        Node head = root;
        while (head != null) {
            Node dummy = new Node();
            Node tail = dummy;
            
            for (Node curr = head; curr != null; curr = curr.next) {
                if (curr.left != null) {
                    tail.next = curr.left;
                    tail = tail.next;
                }
                if (curr.right != null) {
                    tail.next = curr.right;
                    tail = tail.next;
                }
            }
            
            head = dummy.next;
        }
        return root;
    }
    
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
    
    public static void main(String[] args) {
    	RightPointerII sol = new RightPointerII();
        
        System.out.println("=== Example 1: [1,2,3,4,5,null,7] ===");
        Node root1 = new Node(1);
        root1.left = new Node(2); 
        root1.right = new Node(3);
        root1.left.left = new Node(4); 
        root1.left.right = new Node(5);
        root1.right.right = new Node(7);
        
        System.out.print("Input: ");
        printTree(root1);
        
        sol.connect(root1);
        System.out.print("Output: ");
        printTree(root1);  // Expected: [1#,2->3#,4->5->7#]
        
        System.out.println("\n=== Example 2: Empty ===");
        printTree(null);
        sol.connect(null);
        printTree(null);
    }
}
