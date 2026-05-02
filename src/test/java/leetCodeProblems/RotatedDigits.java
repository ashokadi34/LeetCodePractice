package leetCodeProblems;

public class RotatedDigits {
    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isGood(i)) count++;
        }
        return count;
    }
    
    private boolean isGood(int x) {
        boolean changed = false;
        while (x > 0) {
            int d = x % 10;
            if (d == 2 || d == 5 || d == 6 || d == 9) {
                changed = true; // these digits change to something else
            } else if (d == 3 || d == 4 || d == 7) {
                return false; // invalid digit
            }
            // digits 0,1,8 are fine but don't mark changed
            x /= 10;
        }
        return changed;
    }

    // Test cases
    public static void main(String[] args) {
    	RotatedDigits sol = new RotatedDigits();
        System.out.println(sol.rotatedDigits(10)); // 4
        System.out.println(sol.rotatedDigits(1));  // 0
        System.out.println(sol.rotatedDigits(2));  // 1
    }
}