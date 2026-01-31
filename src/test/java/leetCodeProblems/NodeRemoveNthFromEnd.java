package leetCodeProblems;

import java.util.*;

public class NodeRemoveNthFromEnd {
    int val;
    NodeRemoveNthFromEnd next;
    
    NodeRemoveNthFromEnd() {}
    NodeRemoveNthFromEnd(int val) { this.val = val; }
    NodeRemoveNthFromEnd(int val, NodeRemoveNthFromEnd next) { this.val = val; this.next = next; }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NodeRemoveNthFromEnd cur = this;
        while (cur != null) {
            sb.append(cur.val);
            if (cur.next != null) sb.append(" -> "); 
            cur = cur.next;
        }
        return sb.toString();
    }

    public static NodeRemoveNthFromEnd removeNthFromEnd(NodeRemoveNthFromEnd head, int n) {
        NodeRemoveNthFromEnd dummy = new NodeRemoveNthFromEnd(0, head);
        NodeRemoveNthFromEnd fast = dummy;
        NodeRemoveNthFromEnd slow = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    // Helper to build list from array
    public static NodeRemoveNthFromEnd buildList(int[] arr) {
        if (arr.length == 0) return null;
        NodeRemoveNthFromEnd head = new NodeRemoveNthFromEnd(arr[0]);
        NodeRemoveNthFromEnd cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new NodeRemoveNthFromEnd(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    //Test cases
    public static void main(String[] args) {
        // Example 1
        int[] arr1 = {1,2,3,4,5};
        NodeRemoveNthFromEnd head1 = buildList(arr1);
        System.out.println("Input: [1,2,3,4,5], n=2");
        System.out.println("Output: " + removeNthFromEnd(head1, 2));

        // Example 2
        int[] arr2 = {1};
        NodeRemoveNthFromEnd head2 = buildList(arr2);
        System.out.println("\nInput: [1], n=1");
        System.out.println("Output: " + removeNthFromEnd(head2, 1));

        // Example 3
        int[] arr3 = {1,2};
        NodeRemoveNthFromEnd head3 = buildList(arr3);
        System.out.println("\nInput: [1,2], n=1");
        System.out.println("Output: " + removeNthFromEnd(head3, 1));
    }
}
 