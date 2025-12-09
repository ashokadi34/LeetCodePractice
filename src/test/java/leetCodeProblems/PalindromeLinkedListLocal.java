package leetCodeProblems;

public class PalindromeLinkedListLocal {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // LeetCode-style solution
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // 1. Find middle (end of first half)
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse second half
        ListNode secondHalfHead = reverseList(slow.next);

        // 3. Compare first and second halves
        ListNode p1 = head;
        ListNode p2 = secondHalfHead;
        boolean isPalin = true;
        while (p2 != null) {
            if (p1.val != p2.val) {
                isPalin = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // Optional: restore list
        // slow.next = reverseList(secondHalfHead);

        return isPalin;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }

    // Helper: build list from array
    private static ListNode build(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int x : arr) {
            curr.next = new ListNode(x);
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // Example 1: [1,2,2,1] -> true
        ListNode h1 = build(new int[]{1,2,2,1});
        System.out.println(isPalindrome(h1)); // true

        // Example 2: [1,2] -> false
        ListNode h2 = build(new int[]{1,2});
        System.out.println(isPalindrome(h2)); // false

        // Extra tests
        ListNode h3 = build(new int[]{1});
        System.out.println(isPalindrome(h3)); // true

        ListNode h4 = build(new int[]{1,2,3,2,1});
        System.out.println(isPalindrome(h4)); // true
    }
}

