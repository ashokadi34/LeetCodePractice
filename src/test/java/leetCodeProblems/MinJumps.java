package leetCodeProblems;

import java.util.*;

public class MinJumps {
    public int minJumps(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        
        int maxVal = 0;
        for (int v : nums) maxVal = Math.max(maxVal, v);
        
        // Sieve for primes and smallest prime factor
        boolean[] isPrime = new boolean[maxVal + 1];
        int[] spf = new int[maxVal + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= maxVal; i++) {
            if (isPrime[i]) {
                spf[i] = i;
                for (int j = i * 2; j <= maxVal; j += i) {
                    isPrime[j] = false;
                    if (spf[j] == 0) spf[j] = i;
                }
            }
        }
        
        // For each prime p, list of indices where nums[idx] is divisible by p
        List<Integer>[] primeToIndices = new List[maxVal + 1];
        for (int idx = 0; idx < n; idx++) {
            int val = nums[idx];
            Set<Integer> factors = new HashSet<>();
            while (val > 1) {
                int p = spf[val];
                factors.add(p);
                while (val % p == 0) val /= p;
            }
            for (int p : factors) {
                if (primeToIndices[p] == null) primeToIndices[p] = new ArrayList<>();
                primeToIndices[p].add(idx);
            }
        }
        
        // BFS
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[0] = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        boolean[] primeProcessed = new boolean[maxVal + 1];
        
        while (!q.isEmpty()) {
            int u = q.poll();
            if (u == n - 1) return dist[u];
            
            // Adjacent steps
            if (u + 1 < n && dist[u + 1] == -1) {
                dist[u + 1] = dist[u] + 1;
                q.offer(u + 1);
            }
            if (u - 1 >= 0 && dist[u - 1] == -1) {
                dist[u - 1] = dist[u] + 1;
                q.offer(u - 1);
            }
            
            // Teleportation if nums[u] is prime
            int p = nums[u];
            if (p <= maxVal && isPrime[p] && !primeProcessed[p]) {
                primeProcessed[p] = true;
                if (primeToIndices[p] != null) {
                    for (int v : primeToIndices[p]) {
                        if (dist[v] == -1 && v != u) {
                            dist[v] = dist[u] + 1;
                            q.offer(v);
                        }
                    }
                    // free memory
                    primeToIndices[p] = null;
                }
            }
        }
        // Should never happen because we can always walk step by step
        return dist[n - 1];
    }

    // Test cases
    public static void main(String[] args) {
        MinJumps sol = new MinJumps();
        System.out.println(sol.minJumps(new int[]{1,2,4,6}));       // 2
        System.out.println(sol.minJumps(new int[]{2,3,4,7,9}));    // 2
        System.out.println(sol.minJumps(new int[]{4,6,5,8}));       // 3
    }
}
