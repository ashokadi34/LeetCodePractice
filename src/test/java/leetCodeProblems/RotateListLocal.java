package leetCodeProblems;

public class RotateListLocal {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode cur = this;
            while (cur != null) {
                sb.append(cur.val).append(" -> ");
                cur = cur.next;
            }
            sb.append("null");
            return sb.toString();
        }
    }
    
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        
        // Find length and tail
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        
        // k %= len handles large k
        k %= len;
        if (k == 0) return head;
        
        // Connect tail to head (circle)
        tail.next = head;
        
        // Find new tail: len - k steps from head
        ListNode newTail = head;
        for (int i = 0; i < len - k - 1; i++) {
            newTail = newTail.next;
        }
        
        // New head is after newTail
        ListNode newHead = newTail.next;
        newTail.next = null;
        
        return newHead;
    }
    
    // Helper to create list from array
    public static ListNode createList(int[] vals) {
        if (vals.length == 0) return null;
        ListNode head = new ListNode(vals[0]);
        ListNode cur = head;
        for (int i = 1; i < vals.length; i++) {
            cur.next = new ListNode(vals[i]);
            cur = cur.next;
        }
        return head;
    }
    
    public static void main(String[] args) {
        // Example 1
        ListNode head1 = createList(new int[]{1,2,3,4,5});
        System.out.println("Input: [1,2,3,4,5], k=2");
        System.out.println("Output: " + rotateRight(head1, 2));  // 4 -> 5 -> 1 -> 2 -> 3 -> null
        
        // Example 2
        ListNode head2 = createList(new int[]{0,1,2});
        System.out.println("\nInput: [0,1,2], k=4");
        System.out.println("Output: " + rotateRight(head2, 4));  // 2 -> 0 -> 1 -> null
        
        // Additional tests
        System.out.println("\nEdge: single node [1], k=5 → " + rotateRight(createList(new int[]{1}), 5));
        System.out.println("Edge: empty, k=0 → " + rotateRight(null, 0));
        System.out.println("Edge: k=0 [1,2] → " + rotateRight(createList(new int[]{1,2}), 0));
        System.out.println("Edge: large k [1], 2e9 → " + rotateRight(createList(new int[]{1}), 2000000000));
    }
}
