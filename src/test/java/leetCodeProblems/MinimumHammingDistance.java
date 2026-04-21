package leetCodeProblems;

import java.util.*;

class MinimumHammingDistance {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        DSU dsu = new DSU(n);
        for (int[] swap : allowedSwaps) {
            dsu.union(swap[0], swap[1]);
        }
        
        // Map component root -> list of indices in that component
        Map<Integer, List<Integer>> components = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);
            components.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }
        
        int totalMatches = 0;
        for (List<Integer> indices : components.values()) {
            // Frequency map for source values in this component
            Map<Integer, Integer> srcFreq = new HashMap<>();
            for (int idx : indices) {
                srcFreq.put(source[idx], srcFreq.getOrDefault(source[idx], 0) + 1);
            }
            // Count matches with target values
            for (int idx : indices) {
                int val = target[idx];
                if (srcFreq.getOrDefault(val, 0) > 0) {
                    totalMatches++;
                    srcFreq.put(val, srcFreq.get(val) - 1);
                }
            }
        }
        return n - totalMatches;
    }
    
    // Disjoint Set Union (Union-Find) implementation
    class DSU {
        int[] parent;
        int[] rank;
        
        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        
        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        void union(int x, int y) {
            int rx = find(x);
            int ry = find(y);
            if (rx == ry) return;
            if (rank[rx] < rank[ry]) {
                parent[rx] = ry;
            } else if (rank[rx] > rank[ry]) {
                parent[ry] = rx;
            } else {
                parent[ry] = rx;
                rank[rx]++;
            }
        }
    }

    // Main method for local testing
    public static void main(String[] args) {
    	MinimumHammingDistance sol = new MinimumHammingDistance();

        // Example 1
        int[] source1 = {1,2,3,4};
        int[] target1 = {2,1,4,5};
        int[][] swaps1 = {{0,1},{2,3}};
        System.out.println(sol.minimumHammingDistance(source1, target1, swaps1)); // Output: 1

        // Example 2
        int[] source2 = {1,2,3,4};
        int[] target2 = {1,3,2,4};
        int[][] swaps2 = {};
        System.out.println(sol.minimumHammingDistance(source2, target2, swaps2)); // Output: 2

        // Example 3
        int[] source3 = {5,1,2,4,3};
        int[] target3 = {1,5,4,2,3};
        int[][] swaps3 = {{0,4},{4,2},{1,3},{1,4}};
        System.out.println(sol.minimumHammingDistance(source3, target3, swaps3)); // Output: 0
    }
}