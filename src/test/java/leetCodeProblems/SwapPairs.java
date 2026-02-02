package leetCodeProblems;

import java.util.*;

public class SwapPairs {
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
                if (cur.next != null) sb.append(" -> ");
                cur = cur.next;
            }
            return sb.toString();
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;
            
            prev.next = second;
            first.next = second.next;
            second.next = first;
            
            prev = first;
            head = first.next;
        }
        return dummy.next;
    }

    public static ListNode buildList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4};
        System.out.println("Input: [1,2,3,4]");
        System.out.println("Output: " + swapPairs(buildList(arr1)));

        System.out.println("\nInput: []");
        System.out.println("Output: " + swapPairs(null));

        int[] arr3 = {1};
        System.out.println("\nInput: [1]");
        System.out.println("Output: " + swapPairs(buildList(arr3)));

        int[] arr4 = {1,2,3};
        System.out.println("\nInput: [1,2,3]");
        System.out.println("Output: " + swapPairs(buildList(arr4)));
    }
}
