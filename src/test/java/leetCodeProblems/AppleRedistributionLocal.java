package leetCodeProblems;

import java.util.Arrays;
import java.util.Scanner;

public class AppleRedistributionLocal {

    // method
    public static int minimumBoxes(int[] apple, int[] capacity) {
        // Total apples to store
        int total = 0;
        for (int x : apple) total += x;
        
        // Sort capacities in ascending order
        Arrays.sort(capacity);
        
        int used = 0;
        int n = capacity.length;
        // Take largest boxes first
        for (int i = n - 1; i >= 0; i--) {
            total -= capacity[i];
            used++;
            if (total <= 0) break;
        }
        return used;
    }

    public static void main(String[] args) {
        // Example 1
        int[] apple1 = {1, 3, 2};
        int[] cap1 = {4, 3, 1, 5, 2};
        System.out.println("Example 1:");
        System.out.println("apple: " + Arrays.toString(apple1));
        System.out.println("capacity: " + Arrays.toString(cap1));
        System.out.println("minimumBoxes: " + minimumBoxes(apple1, cap1)); // 2
        
        // Example 2
        int[] apple2 = {5, 5, 5};
        int[] cap2 = {2, 4, 2, 7};
        System.out.println("\nExample 2:");
        System.out.println("apple: " + Arrays.toString(apple2));
        System.out.println("capacity: " + Arrays.toString(cap2));
        System.out.println("minimumBoxes: " + minimumBoxes(apple2, cap2)); // 4

        // Interactive mode of testing
        Scanner sc = new Scanner(System.in);
        System.out.println("\nInteractive mode (type 'q' to quit):");
        while (true) {
            System.out.print("Enter number of apple packs: ");
            if (!sc.hasNextInt()) break;
            
            int n = sc.nextInt();
            int[] apple = new int[n];
            System.out.println("Enter " + n + " apple counts:");
            for (int i = 0; i < n; i++) {
                apple[i] = sc.nextInt();
            }
            
            System.out.print("Enter number of boxes: ");
            int m = sc.nextInt();
            int[] capacity = new int[m];
            System.out.println("Enter " + m + " box capacities:");
            for (int i = 0; i < m; i++) {
                capacity[i] = sc.nextInt();
            }
            
            int totalApples = 0;
            for (int a : apple) totalApples += a;
            System.out.println("Total apples: " + totalApples);
            System.out.println("minimumBoxes needed: " + minimumBoxes(apple, capacity));
        }
        sc.close();
    }
}

