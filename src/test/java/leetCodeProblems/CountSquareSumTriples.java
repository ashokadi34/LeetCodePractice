package leetCodeProblems;

public class CountSquareSumTriples {

    public static int countTriples(int n) {
        int count = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                int c2 = a * a + b * b;
                int c = (int) Math.sqrt(c2);
                if (c <= n && c * c == c2) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Sample tests from the problem
        System.out.println(countTriples(5));   // 2  -> (3,4,5), (4,3,5)
        System.out.println(countTriples(10));  // 4  -> (3,4,5), (4,3,5), (6,8,10), (8,6,10)

        // Interactive testing
        java.util.Scanner sc = new java.util.Scanner(System.in);
        while (true) {
            System.out.print("Enter n (or -1 to quit): ");
            int n = sc.nextInt();
            if (n == -1) break;
            System.out.println("Count: " + countTriples(n));
        }
        sc.close();
    }
}
