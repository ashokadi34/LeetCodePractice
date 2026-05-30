package leetCodeProblems;

import java.util.*;

public class CopyRandomList {

    static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();

        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }

    static Node buildList(int[][] data) {
        if (data == null || data.length == 0) return null;

        Node[] nodes = new Node[data.length];

        for (int i = 0; i < data.length; i++) {
            nodes[i] = new Node(data[i][0]);
        }

        for (int i = 0; i < data.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        for (int i = 0; i < data.length; i++) {
            int randomIndex = data[i][1];
            nodes[i].random = (randomIndex == -1) ? null : nodes[randomIndex];
        }

        return nodes[0];
    }

    static void printList(Node head) {
        Map<Node, Integer> indexMap = new HashMap<>();
        Node curr = head;
        int index = 0;

        while (curr != null) {
            indexMap.put(curr, index++);
            curr = curr.next;
        }

        curr = head;
        List<String> result = new ArrayList<>();

        while (curr != null) {
            String randomIndex = (curr.random == null) ? "null" : String.valueOf(indexMap.get(curr.random));
            result.add("[" + curr.val + "," + randomIndex + "]");
            curr = curr.next;
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        CopyRandomList sol = new CopyRandomList();

        int[][] input1 = {
            {7, -1},
            {13, 0},
            {11, 4},
            {10, 2},
            {1, 0}
        };

        int[][] input2 = {
            {1, 1},
            {2, 1}
        };

        int[][] input3 = {
            {3, -1},
            {3, 0},
            {3, -1}
        };

        Node head1 = buildList(input1);
        Node head2 = buildList(input2);
        Node head3 = buildList(input3);

        Node copy1 = sol.copyRandomList(head1);
        Node copy2 = sol.copyRandomList(head2);
        Node copy3 = sol.copyRandomList(head3);

        printList(copy1); // [[7,null], [13,0], [11,4], [10,2], [1,0]]
        printList(copy2); // [[1,1], [2,1]]
        printList(copy3); // [[3,null], [3,0], [3,null]]
    }
}