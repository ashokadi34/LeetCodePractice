package leetCodeProblems;


import java.util.*;

public class Main {
    private int[] bit;

    public List<Boolean> palindromePath(
            int n, int[][] edges, String s, String[] queries) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int log = 1;
        while ((1 << log) <= n) {
            log++;
        }

        int[][] up = new int[log][n];
        int[] depth = new int[n];
        int[] tin = new int[n];
        int[] tout = new int[n];

        // Entry event: u; exit event: ~u.
        int[] stack = new int[2 * n];
        int top = 0;
        int timer = 0;

        up[0][0] = 0;
        stack[top++] = 0;

        while (top > 0) {
            int event = stack[--top];

            if (event < 0) {
                int u = ~event;
                tout[u] = ++timer;
                continue;
            }

            int u = event;
            tin[u] = ++timer;

            stack[top++] = ~u;

            for (int v : graph.get(u)) {
                if (v == up[0][u]) {
                    continue;
                }

                up[0][v] = u;
                depth[v] = depth[u] + 1;
                stack[top++] = v;
            }
        }

        for (int k = 1; k < log; k++) {
            for (int u = 0; u < n; u++) {
                up[k][u] = up[k - 1][up[k - 1][u]];
            }
        }

        char[] chars = s.toCharArray();
        bit = new int[2 * n + 1];

        for (int u = 0; u < n; u++) {
            int mask = 1 << (chars[u] - 'a');
            bit[tin[u]] = mask;
            bit[tout[u]] = mask;
        }

        // Linear-time Fenwick tree construction.
        for (int i = 1; i < bit.length; i++) {
            int next = i + (i & -i);

            if (next < bit.length) {
                bit[next] ^= bit[i];
            }
        }

        List<Boolean> answer = new ArrayList<>();

        for (String query : queries) {
            String[] parts = query.split(" ");
            int u = Integer.parseInt(parts[1]);

            if (parts[0].equals("update")) {
                char c = parts[2].charAt(0);

                int delta = (1 << (chars[u] - 'a'))
                          ^ (1 << (c - 'a'));

                if (delta != 0) {
                    update(tin[u], delta);
                    update(tout[u], delta);
                    chars[u] = c;
                }
            } else {
                int v = Integer.parseInt(parts[2]);
                int ancestor = lca(u, v, depth, up);

                int mask = prefixXor(tin[u])
                         ^ prefixXor(tin[v])
                         ^ (1 << (chars[ancestor] - 'a'));

                answer.add((mask & (mask - 1)) == 0);
            }
        }

        return answer;
    }

    private void update(int index, int delta) {
        while (index < bit.length) {
            bit[index] ^= delta;
            index += index & -index;
        }
    }

    private int prefixXor(int index) {
        int result = 0;

        while (index > 0) {
            result ^= bit[index];
            index -= index & -index;
        }

        return result;
    }

    private int lca(int u, int v, int[] depth, int[][] up) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int difference = depth[u] - depth[v];

        for (int k = 0; k < up.length; k++) {
            if ((difference & (1 << k)) != 0) {
                u = up[k][u];
            }
        }

        if (u == v) {
            return u;
        }

        for (int k = up.length - 1; k >= 0; k--) {
            if (up[k][u] != up[k][v]) {
                u = up[k][u];
                v = up[k][v];
            }
        }

        return up[0][u];
    }

    public static void main(String[] args) {
        Main solution = new Main();

        // Example 1
        int n1 = 3;
        int[][] edges1 = {
            {0, 1},
            {1, 2}
        };
        String s1 = "aac";
        String[] queries1 = {
            "query 0 2",
            "update 1 b",
            "query 0 2"
        };

        System.out.println("Example 1:");
        System.out.println(
            solution.palindromePath(n1, edges1, s1, queries1)
        );
        System.out.println("Expected: [true, false]");

        // Example 2
        int n2 = 4;
        int[][] edges2 = {
            {0, 1},
            {0, 2},
            {0, 3}
        };
        String s2 = "abca";
        String[] queries2 = {
            "query 1 2",
            "update 0 b",
            "query 2 3",
            "update 3 a",
            "query 1 3"
        };

        System.out.println("\nExample 2:");
        System.out.println(
            solution.palindromePath(n2, edges2, s2, queries2)
        );
        System.out.println("Expected: [false, false, true]");

        // Previously failing test case
        int n3 = 3;
        int[][] edges3 = {
            {0, 2},
            {0, 1}
        };
        String s3 = "ghh";
        String[] queries3 = {
            "query 1 2"
        };

        System.out.println("\nRegression test:");
        System.out.println(
            solution.palindromePath(n3, edges3, s3, queries3)
        );
        System.out.println("Expected: [true]");
    }
}