package leetCodeProblems;

import java.util.Scanner;

public class FirstBadVersionOneFile {

    // Simulated LeetCode VersionControl
    static class VersionControl {
        protected int bad; // first bad version

        public VersionControl(int bad) {
            this.bad = bad;
        }

        protected boolean isBadVersion(int version) {
            return version >= bad;
        }
    }

    // LeetCode-style Solution extending VersionControl
    static class Solution extends VersionControl {

        public Solution(int bad) {
            super(bad);
        }

        public int firstBadVersion(int n) {
            int left = 1;
            int right = n;

            while (left < right) {
                int mid = left + (right - left) / 2; // avoid overflow
                if (isBadVersion(mid)) {
                    // mid is bad, so first bad is in [left, mid]
                    right = mid;
                } else {
                    // mid is good, so first bad is in [mid+1, right]
                    left = mid + 1;
                }
            }
            return left; // first bad version
        }
    }

    public static void main(String[] args) {
        // Example 1: n = 5, bad = 4
        Solution sol1 = new Solution(4);
        System.out.println("Example 1: n = 5, bad = 4 -> " + sol1.firstBadVersion(5)); // 4

        // Example 2: n = 1, bad = 1
        Solution sol2 = new Solution(1);
        System.out.println("Example 2: n = 1, bad = 1 -> " + sol2.firstBadVersion(1)); // 1

        // Extra test: n = 10, bad = 7
        Solution sol3 = new Solution(7);
        System.out.println("Extra: n = 10, bad = 7 -> " + sol3.firstBadVersion(10)); // 7

        // Interactive mode
        Scanner sc = new Scanner(System.in);
        System.out.println("\nInteractive test (type 'quit' to exit):");
        while (true) {
            System.out.print("Enter n and bad (e.g. '5 4'): ");
            String line = sc.nextLine().trim();
            if (line.equalsIgnoreCase("quit")) break;
            try {
                String[] parts = line.split("\\s+");
                int n = Integer.parseInt(parts[0]);
                int bad = Integer.parseInt(parts[1]);
                Solution sol = new Solution(bad);
                System.out.println("firstBadVersion(" + n + ") = " + sol.firstBadVersion(n));
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter two integers like '5 4' or 'quit'.");
            }
        }
        sc.close();
    }
}

