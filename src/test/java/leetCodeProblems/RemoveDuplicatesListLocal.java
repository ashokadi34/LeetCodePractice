package leetCodeProblems;

public class RemoveDuplicatesListLocal {
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
                sb.append(cur.val);
                if (cur.next != null) sb.append("→");
                cur = cur.next;
            }
            return sb.toString();
        }
    }
    
    //deleteDuplicates
    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(0, head);
            ListNode prev = dummy;
            
            while (head != null) {
                if (head.next != null && head.val == head.next.val) {
                    // Skip all duplicates
                    int dupVal = head.val;
                    while (head != null && head.val == dupVal) {
                        head = head.next;
                    }
                } else {
                    // Unique, connect prev
                    prev.next = head;
                    prev = head;
                    head = head.next;
                }
            }
            prev.next = null;  // Terminate
            return dummy.next;
        }
    }

    //Test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test 1: [1,2,3,3,4,4,5] → [1,2,5]
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, 
                           new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        System.out.println("Test1: " + head1 + " → " + sol.deleteDuplicates(head1));

        // Test 2: [1,1,1,2,3] → [2,3]
        ListNode head2 = new ListNode(1, new ListNode(1, new ListNode(1, 
                           new ListNode(2, new ListNode(3)))));
        System.out.println("Test2: " + head2 + " → " + sol.deleteDuplicates(head2));

        // Test 3: all duplicates [1,1] → []
        ListNode head3 = new ListNode(1, new ListNode(1));
        System.out.println("Test3: " + head3 + " → " + sol.deleteDuplicates(head3));

        // Test 4: no duplicates [1,2,3] → [1,2,3]
        ListNode head4 = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println("Test4: " + head4 + " → " + sol.deleteDuplicates(head4));

        // Test 5: empty → empty
        System.out.println("Test5: null → " + (sol.deleteDuplicates(null) == null ? "null" : "error"));
    }
}
