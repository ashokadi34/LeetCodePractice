package leetCodeProblems;

import java.util.Arrays;

public class FindTheDistanceValue {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;

        for (int a : arr1) {
            boolean valid = true;

            for (int b : arr2) {
                if (Math.abs(a - b) <= d) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        FindTheDistanceValue solution = new FindTheDistanceValue();

        int[][] arr1Tests = {
            {4, 5, 8},
            {1, 4, 2, 3},
            {2, 1, 100, 3}
        };

        int[][] arr2Tests = {
            {10, 9, 1, 8},
            {-4, -3, 6, 10, 20, 30},
            {-5, -2, 10, -3, 7}
        };

        int[] dValues = {2, 3, 6};
        int[] expected = {2, 2, 1};

        for (int i = 0; i < arr1Tests.length; i++) {
            int result = solution.findTheDistanceValue(
                arr1Tests[i], arr2Tests[i], dValues[i]
            );

            System.out.println("Test case " + (i + 1));
            System.out.println(
                "arr1:     " + Arrays.toString(arr1Tests[i])
            );
            System.out.println(
                "arr2:     " + Arrays.toString(arr2Tests[i])
            );
            System.out.println("d:        " + dValues[i]);
            System.out.println("Output:   " + result);
            System.out.println("Expected: " + expected[i]);
            System.out.println(
                "Status:   " + (result == expected[i] ? "PASS" : "FAIL")
            );
            System.out.println();
        }
    }
}