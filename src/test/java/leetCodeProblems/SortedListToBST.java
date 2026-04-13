package leetCodeProblems;

public class SortedListToBST {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    private static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }
    
    private static ListNode curr;
    
    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        
        // Count the number of nodes
        int count = 0;
        curr = head;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        
        // Reset curr to head and build the tree
        curr = head;
        return treeify(0, count - 1);
    }
    
    private static TreeNode treeify(int start, int end) {
        if (start > end) return null;
        
        int mid = start + (end - start) / 2;
        TreeNode left = treeify(start, mid - 1);
        
        TreeNode node = new TreeNode(curr.val);
        node.left = left;
        curr = curr.next;
        
        node.right = treeify(mid + 1, end);
        return node;
    }
    
    // For local testing
    public static void main(String[] args) {
       
        
        // Example 1: head = [-10,-3,0,5,9]
        ListNode head1 = new ListNode(-10);
        head1.next = new ListNode(-3);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(5);
        head1.next.next.next.next = new ListNode(9);
        
        TreeNode root1 = sortedListToBST(head1);
        System.out.println("Example 1 built successfully.");
        
        // Example 2: empty list
        TreeNode root2 = sortedListToBST(null);
        System.out.println("Example 2 (empty): " + (root2 == null ? "null" : "tree"));
    }
}
