package leetCodeProblems;

import java.util.HashSet;
import java.util.Set;

public class RepeatedNTimes {
	//functionality
    public int repeatedNTimes(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        
        for (int x : nums) {
            if (seen.contains(x)) {
                return x;          // first duplicate is the answer
            }
            seen.add(x);
        }
        
        // Problem guarantees a solution, but return -1 as a fallback
        return -1;
    }

    // Local test
    public static void main(String[] args) {
        RepeatedNTimes sol = new RepeatedNTimes();
        System.out.println(sol.repeatedNTimes(new int[]{1,2,3,3}));          // 3
        System.out.println(sol.repeatedNTimes(new int[]{2,1,2,5,3,2}));      // 2
        System.out.println(sol.repeatedNTimes(new int[]{5,1,5,2,5,3,5,4}));  // 5
    }
}

