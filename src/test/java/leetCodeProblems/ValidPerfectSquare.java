package leetCodeProblems;

public class ValidPerfectSquare {
	//method to validate square
    public boolean isPerfectSquare(int num) {
        int left = 1, right = num;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sq = (long) mid * mid; // avoid overflow

            if (sq == num) {
                return true;
            } else if (sq < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ValidPerfectSquare sol = new ValidPerfectSquare();

        int[] tests = {1, 4, 14, 16, 808201, 2147395600};

        for (int num : tests) {
            System.out.println(num + " -> " + sol.isPerfectSquare(num));
        }
    }
}

