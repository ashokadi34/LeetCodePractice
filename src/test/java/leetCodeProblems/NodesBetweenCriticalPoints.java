package leetCodeProblems;

import java.util.Arrays;
import java.util.Scanner;

public class NodesBetweenCriticalPoints {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Example - Input: 7 / 5 3 1 2 5 1 2 || output: [1, 3]");
        int n = scanner.nextInt();

        ListNode head = null;
        ListNode tail = null;

        for (int i = 0; i < n; i++) {
            ListNode newNode = new ListNode(scanner.nextInt());

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        int[] answer = nodesBetweenCriticalPoints(head);
        
        String ans = Arrays.toString(answer);

        System.out.println("Output: "+ans);

        scanner.close();
    }

    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;

        int position = 1;

        int firstCriticalPosition = -1;
        int previousCriticalPosition = -1;

        int minDistance = Integer.MAX_VALUE;

        /*
         * curr needs both a previous node and a next node.
         * Therefore, stop when curr becomes the last node.
         */
        while (curr.next != null) {
            int prevValue = prev.val;
            int currentValue = curr.val;
            int nextValue = curr.next.val;

            boolean isLocalMaximum =
                    currentValue > prevValue &&
                    currentValue > nextValue;

            boolean isLocalMinimum =
                    currentValue < prevValue &&
                    currentValue < nextValue;

            if (isLocalMaximum || isLocalMinimum) {

                if (firstCriticalPosition == -1) {
                    firstCriticalPosition = position;
                } else {
                    minDistance = Math.min(
                            minDistance,
                            position - previousCriticalPosition
                    );
                }

                previousCriticalPosition = position;
            }

            prev = curr;
            curr = curr.next;
            position++;
        }

        /*
         * If there are zero or one critical points,
         * the answer must be [-1, -1].
         */
        if (firstCriticalPosition == -1 ||
                firstCriticalPosition == previousCriticalPosition) {
            return new int[]{-1, -1};
        }

        int maxDistance = previousCriticalPosition - firstCriticalPosition;

        return new int[]{minDistance, maxDistance};
    }
}
