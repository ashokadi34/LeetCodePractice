package leetCodeProblems;

import java.util.*;

public class ReadBinaryWatch {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    ans.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return ans;
    }

    // Local testing in Eclipse
    public static void main(String[] args) {
        ReadBinaryWatch sol = new ReadBinaryWatch();

        // Example 1: turnedOn = 1
        System.out.println(sol.readBinaryWatch(1));

        // Example 2: turnedOn = 9
        System.out.println(sol.readBinaryWatch(9));

        // Additional tests
        System.out.println(sol.readBinaryWatch(0));  // ["0:00"]
    }
}
