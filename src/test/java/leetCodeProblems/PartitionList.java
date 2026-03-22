package leetCodeProblems;

public class PartitionList {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode beforeHead = new ListNode(0);
            ListNode afterHead  = new ListNode(0);
            ListNode before = beforeHead;
            ListNode after  = afterHead;

            ListNode node = head;
            while (node != null) {
                if (node.val < x) {
                    before.next = node;
                    before = node;
                } else {
                    after.next = node;
                    after = node;
                }
                node = node.next;
            }

            // Terminate after list and link the two partitions
            after.next = null;
            before.next = afterHead.next;

            return beforeHead.next;
        }
    }

    // Utility to build list from array
    public static ListNode buildList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int v : arr) {
            cur.next = new ListNode(v);
            cur = cur.next;
        }
        return dummy.next;
    }

    // Utility to print list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // Test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1: [1,4,3,2,5,2], x = 3
        int[] arr1 = {1, 4, 3, 2, 5, 2};
        ListNode head1 = buildList(arr1);
        ListNode result1 = sol.partition(head1, 3);
        System.out.print("Example 1: ");
        printList(result1);  // expected: 1 -> 2 -> 2 -> 4 -> 3 -> 5

        // Example 2: [2,1], x = 2
        int[] arr2 = {2, 1};
        ListNode head2 = buildList(arr2);
        ListNode result2 = sol.partition(head2, 2);
        System.out.print("Example 2: ");
        printList(result2);  // expected: 1 -> 2
    }
}
