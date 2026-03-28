package leetCodeProblems;

//ReverseLinkedListII.java
public class ReverseLinkedListII {

 public static class ListNode {
     int val;
     ListNode next;

     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

 static class Solution {
     public ListNode reverseBetween(ListNode head, int left, int right) {
         if (head == null || left == right) {
             return head;
         }

         ListNode dummy = new ListNode(0);
         dummy.next = head;
         ListNode prev = dummy;

         // Move prev to node just before position 'left'
         for (int i = 0; i < left - 1; i++) {
             prev = prev.next;
         }

         ListNode tail = prev.next;
         ListNode curr = prev.next.next;

         // Reverse the sublist of length (right - left + 1)
         for (int i = 0; i < right - left; i++) {
             ListNode next = curr.next;
             curr.next = prev.next;
             prev.next = curr;
             curr = next;
         }

         tail.next = curr;

         return dummy.next;
     }
 }

 //Test cases
 public static void main(String[] args) {
     Solution sol = new Solution();

     // Example 1: head = [1,2,3,4,5], left=2, right=4 → [1,4,3,2,5]
     ListNode head1 = new ListNode(1, new ListNode(2,
             new ListNode(3, new ListNode(4, new ListNode(5)))));

     ListNode res1 = sol.reverseBetween(head1, 2, 4);
     System.out.print("Example 1: ");
     printList(res1); // Expected: 1 4 3 2 5

     // Example 2: head = [5], left=1, right=1 → [5]
     ListNode head2 = new ListNode(5);
     ListNode res2 = sol.reverseBetween(head2, 1, 1);
     System.out.print("Example 2: ");
     printList(res2); // Expected: 5
 }

 static void printList(ListNode head) {
     while (head != null) {
         System.out.print(head.val);
         if (head.next != null) System.out.print(" ");
         head = head.next;
     }
     System.out.println();
 }
}
