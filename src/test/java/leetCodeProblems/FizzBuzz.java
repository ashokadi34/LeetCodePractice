package leetCodeProblems;

import java.util.*;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                ans.add("FizzBuzz");
            } else if (i % 3 == 0) {
                ans.add("Fizz");
            } else if (i % 5 == 0) {
                ans.add("Buzz");
            } else {
                ans.add(String.valueOf(i));
            }
        }
        return ans;
    }

    // testing
    public static void main(String[] args) {
    	FizzBuzz sol = new FizzBuzz();
        
        // Example 1: n = 3
        System.out.println(sol.fizzBuzz(3));
        
        // Example 2: n = 5
        System.out.println(sol.fizzBuzz(5));
        
        // Example 3: n = 15 (first few)
        System.out.println(sol.fizzBuzz(15));
    }
}
