package leetCodeProblems;

import java.util.Arrays;

public class CountServers {

    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int q = queries.length;
        int[][] sortedQueries = new int[q][2];

        for (int i = 0; i < q; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(
            sortedQueries,
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int[] frequency = new int[n + 1];
        int[] answer = new int[q];

        int left = 0;
        int right = 0;
        int activeServers = 0;

        for (int[] query : sortedQueries) {
            int time = query[0];
            int originalIndex = query[1];
            int start = time - x;

            // Add requests at or before the inclusive right endpoint.
            while (right < logs.length && logs[right][1] <= time) {
                int server = logs[right][0];

                if (frequency[server] == 0) {
                    activeServers++;
                }

                frequency[server]++;
                right++;
            }

            // Remove requests before the inclusive left endpoint.
            while (left < right && logs[left][1] < start) {
                int server = logs[left][0];

                frequency[server]--;

                if (frequency[server] == 0) {
                    activeServers--;
                }

                left++;
            }

            answer[originalIndex] = n - activeServers;
        }

        return answer;
    }

    public static void main(String[] args) {
        CountServers solution = new CountServers();

        int[] serverCounts = {3, 3};

        int[][][] logsTests = {
            {
                {1, 3},
                {2, 6},
                {1, 5}
            },
            {
                {2, 4},
                {2, 1},
                {1, 2},
                {3, 1}
            }
        };

        int[] xValues = {5, 2};

        int[][] queriesTests = {
            {10, 11},
            {3, 4}
        };

        int[][] expected = {
            {1, 2},
            {0, 1}
        };

        for (int i = 0; i < serverCounts.length; i++) {
            // Copy logs because countServers sorts them.
            int[][] logs = new int[logsTests[i].length][];

            for (int j = 0; j < logs.length; j++) {
                logs[j] = logsTests[i][j].clone();
            }

            int[] result = solution.countServers(
                serverCounts[i],
                logs,
                xValues[i],
                queriesTests[i]
            );

            System.out.println("Test case " + (i + 1));
            System.out.println("n:        " + serverCounts[i]);
            System.out.println(
                "logs:     " + Arrays.deepToString(logsTests[i])
            );
            System.out.println("x:        " + xValues[i]);
            System.out.println(
                "queries:  " + Arrays.toString(queriesTests[i])
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