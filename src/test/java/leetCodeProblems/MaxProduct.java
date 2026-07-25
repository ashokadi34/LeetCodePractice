package leetCodeProblems;

import java.util.*;

public class MaxProduct {
    static class Solution {
        public int maxProduct(int n) {
            int first = 0, second = 0;

            while (n > 0) {
                int d = n % 10;
                if (d >= first) {
                    second = first;
                    first = d;
                } else if (d > second) {
                    second = d;
                }
                n /= 10;
            }

            return first * second;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(new Solution().maxProduct(n));
    }
}