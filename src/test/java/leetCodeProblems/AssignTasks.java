package leetCodeProblems;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public int[] assignTasks(int[] servers, int[] tasks) {
        // Free servers: smaller weight first, then smaller index.
        PriorityQueue<Integer> free = new PriorityQueue<>((a, b) -> {
            int comparison = Integer.compare(servers[a], servers[b]);

            if (comparison != 0) {
                return comparison;
            }

            return Integer.compare(a, b);
        });

        // Busy server entries: {finishTime, serverIndex}.
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        for (int i = 0; i < servers.length; i++) {
            free.offer(i);
        }

        int[] answer = new int[tasks.length];
        long time = 0;

        for (int j = 0; j < tasks.length; j++) {
            time = Math.max(time, (long) j);

            // Wait for the earliest available server if necessary.
            if (free.isEmpty()) {
                time = Math.max(time, busy.peek()[0]);
            }

            // Release all servers finishing at or before this time.
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                long[] completed = busy.poll();
                free.offer((int) completed[1]);
            }

            int server = free.poll();
            answer[j] = server;

            busy.offer(new long[] {
                time + tasks[j],
                server
            });
        }

        return answer;
    }

    public static void main(String[] args) {
        Main solution = new Main();

        int[][] serverTests = {
            {3, 3, 2},
            {5, 1, 4, 3, 2}
        };

        int[][] taskTests = {
            {1, 2, 3, 2, 1, 2},
            {2, 1, 2, 4, 5, 2, 1}
        };

        int[][] expected = {
            {2, 2, 0, 2, 1, 2},
            {1, 4, 1, 4, 1, 3, 2}
        };

        for (int i = 0; i < serverTests.length; i++) {
            int[] result = solution.assignTasks(
                serverTests[i],
                taskTests[i]
            );

            System.out.println("Test case " + (i + 1));
            System.out.println(
                "Servers:  " + Arrays.toString(serverTests[i])
            );
            System.out.println(
                "Tasks:    " + Arrays.toString(taskTests[i])
            );
            System.out.println(
                "Output:   " + Arrays.toString(result)
            );
            System.out.println(
                "Expected: " + Arrays.toString(expected[i])
            );
            System.out.println(
                "Status:   "
                + (Arrays.equals(result, expected[i]) ? "PASS" : "FAIL")
            );
            System.out.println();
        }
    }
}