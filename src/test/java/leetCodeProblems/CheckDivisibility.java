package leetCodeProblems;

import java.util.Scanner;

public class CheckDivisibility {

    public static boolean checkDivisibility(int n) {
        int original = n;
        int digitSum = 0;
        int digitProduct = 1;

        while (n > 0) {
            int digit = n % 10;

            digitSum += digit;
            digitProduct *= digit;

            n /= 10;
        }

        return original % (digitSum + digitProduct) == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();

        System.out.println(checkDivisibility(n));

        scanner.close();
    }
}