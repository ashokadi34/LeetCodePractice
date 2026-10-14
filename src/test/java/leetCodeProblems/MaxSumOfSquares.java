package leetCodeProblems;

import java.util.Scanner;

public class MaxSumOfSquares {

    public static String maxSumOfSquares(int num, int sum) {
        // Impossible if even all 9s cannot reach the required digit sum
        if (sum > 9 * num) {
            return "";
        }

        StringBuilder result = new StringBuilder(num);

        for (int i = 0; i < num; i++) {
            int digit = Math.min(9, sum);
            result.append(digit);
            sum -= digit;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter num (number of digits): ");
        int num = scanner.nextInt();

        System.out.print("Enter sum (sum of digits): ");
        int sum = scanner.nextInt();

        String answer = maxSumOfSquares(num, sum);

        if (answer.isEmpty()) {
            System.out.println("Output: \"\"");
        } else {
            System.out.println("Output: " + answer);
        }

        scanner.close();
    }
}