package leetCodeProblems;

import java.util.Scanner;

public class NimGameLocal {

    // method logic
    public static boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        // Fixed tests (examples)
        System.out.println("Fixed tests:");
        System.out.println("n = 4  -> " + canWinNim(4));  // false
        System.out.println("n = 1  -> " + canWinNim(1));  // true
        System.out.println("n = 2  -> " + canWinNim(2));  // true
        System.out.println("n = 7  -> " + canWinNim(7));  // true
        System.out.println("n = 8  -> " + canWinNim(8));  // false

        // Interactive mode
        Scanner sc = new Scanner(System.in);
        System.out.println("\nInteractive mode (type a number, or 'q' to quit):");
        while (true) {
            System.out.print("Enter n: ");
            if (!sc.hasNextInt()) break;   // non-int -> exit
            int n = sc.nextInt();
            System.out.println("canWinNim(" + n + ") = " + canWinNim(n));
        }
        sc.close();
        System.out.println("Bye!");
    }
}
