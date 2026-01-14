package leetCodeProblems;

public class AddTwoNumbers {
    // ListNode definition included for local testing
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        
        // Helper constructor for testing
        ListNode(int[] values) {
            this.val = values[0];
            ListNode prev = this;
            for (int i = 1; i < values.length; i++) {
                prev.next = new ListNode(values[i]);
                prev = prev.next;
            }
        }
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode curr = dummyHead;
        int carry = 0;
        
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            carry = sum / 10;
        }
        
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
    
    // local testing - examples
    public static void main(String[] args) {
        AddTwoNumbers sol = new AddTwoNumbers();
        
        // Test Example 1: [2,4,3] + [5,6,4] = [7,0,8]
        ListNode l1 = new ListNode(new int[]{2,4,3});
        ListNode l2 = new ListNode(new int[]{5,6,4});
        ListNode result1 = sol.addTwoNumbers(l1, l2);
        System.out.print("Ex1: ");
        printList(result1);  // Expected: 7 0 8
        
        // Test Example 2: [0] + [0] = [0]
        l1 = new ListNode(new int[]{0});
        l2 = new ListNode(new int[]{0});
        ListNode result2 = sol.addTwoNumbers(l1, l2);
        System.out.print("Ex2: ");
        printList(result2);  // Expected: 0
        
        // Test Example 3: long carry propagation
        l1 = new ListNode(new int[]{9,9,9,9,9,9,9});
        l2 = new ListNode(new int[]{9,9,9,9});
        ListNode result3 = sol.addTwoNumbers(l1, l2);
        System.out.print("Ex3: ");
        printList(result3);  // Expected: 8 9 9 9 0 0 0 1
        
        // Extra test: uneven lengths
        l1 = new ListNode(new int[]{1,8});
        l2 = new ListNode(new int[]{0,9});
        ListNode result4 = sol.addTwoNumbers(l1, l2);
        System.out.print("Extra: ");
        printList(result4);  // Expected: 1 7
    }
    
    // Static helper method for printing (accessible from main)
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
