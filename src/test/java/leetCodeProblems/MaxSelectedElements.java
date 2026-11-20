package leetCodeProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);

        // dp[v] = maximum length of a consecutive sequence ending at value v
        Map<Integer, Integer> dp = new HashMap<>();
        int answer = 0;

        for (int num : nums) {
            // Increase current element to num + 1
            dp.put(num + 1, dp.getOrDefault(num, 0) + 1);

            // Keep current element as num
            dp.put(num, dp.getOrDefault(num - 1, 0) + 1);

            answer = Math.max(answer, dp.get(num));
            answer = Math.max(answer, dp.get(num + 1));
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 1, 5, 1, 1};
        System.out.println(maxSelectedElements(nums1)); // Output: 3

        int[] nums2 = {1, 4, 7, 10};
        System.out.println(maxSelectedElements(nums2)); // Output: 1
    }
}