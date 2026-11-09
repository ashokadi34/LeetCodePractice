package leetCodeProblems;

import java.util.*;

public class BusiestServers {

    public List<Integer> busiestServers(
            int k, int[] arrival, int[] load) {

        TreeSet<Integer> available = new TreeSet<>();

        // Busy server entries: {finishTime, serverId}.
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        for (int server = 0; server < k; server++) {
            available.add(server);
        }

        int[] handled = new int[k];
        int maxHandled = 0;

        for (int i = 0; i < arrival.length; i++) {
            long time = arrival[i];

            // Release every server that has finished by this time.
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                long[] completed = busy.poll();
                available.add((int) completed[1]);
            }

            // Drop the request if all servers are busy.
            if (available.isEmpty()) {
                continue;
            }

            Integer server = available.ceiling(i % k);

            // Wrap around to the smallest available server ID.
            if (server == null) {
                server = available.first();
            }

            available.remove(server);

            handled[server]++;
            maxHandled = Math.max(maxHandled, handled[server]);

            busy.offer(new long[] {
                time + load[i],
                server
            });
        }

        List<Integer> answer = new ArrayList<>();

        for (int server = 0; server < k; server++) {
            if (handled[server] == maxHandled) {
                answer.add(server);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        BusiestServers solution = new BusiestServers();

        int[] kValues = {3, 3, 3};

        int[][] arrivalTests = {
            {1, 2, 3, 4, 5},
            {1, 2, 3, 4},
            {1, 2, 3}
        };

        int[][] loadTests = {
            {5, 2, 3, 3, 3},
            {1, 2, 1, 2},
            {10, 12, 11}
        };

        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(1),
            Arrays.asList(0),
            Arrays.asList(0, 1, 2)
        );

        for (int i = 0; i < kValues.length; i++) {
            List<Integer> result = solution.busiestServers(
                kValues[i],
                arrivalTests[i],
                loadTests[i]
            );

            System.out.println("Test case " + (i + 1));
            System.out.println("k:        " + kValues[i]);
            System.out.println(
                "Arrival:  " + Arrays.toString(arrivalTests[i])
            );
            System.out.println(
                "Load:     " + Arrays.toString(loadTests[i])
            );
            System.out.println("Output:   " + result);
            System.out.println("Expected: " + expected.get(i));
            System.out.println(
                "Status:   "
                + (result.equals(expected.get(i)) ? "PASS" : "FAIL")
            );
            System.out.println();
        }
    }
}