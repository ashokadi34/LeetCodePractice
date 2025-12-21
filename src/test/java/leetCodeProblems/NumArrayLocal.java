package leetCodeProblems;

import java.util.Scanner;

class NumArrayLocal {

    private int[] prefix;

    public NumArrayLocal(int[] nums) {
        int n = nums.length;
        prefix = new int[n + 1];
        prefix[0] = 0;
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
    }
    
    public int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }

    // Helper to print prefix array for debugging
    public void printPrefix() {
        System.out.print("Prefix sums: ");
        for (int i = 0; i < prefix.length; i++) {
            System.out.print(prefix[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // LeetCode example
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArrayLocal numArray = new NumArrayLocal(nums);
        
        System.out.println("LeetCode Example:");
        numArray.printPrefix();
        System.out.println("sumRange(0,2)  = " + numArray.sumRange(0, 2));   // 1
        System.out.println("sumRange(2,5)  = " + numArray.sumRange(2, 5));   // -1
        System.out.println("sumRange(0,5)  = " + numArray.sumRange(0, 5));   // -3
        
        // Interactive testing
        Scanner sc = new Scanner(System.in);
        System.out.println("\nInteractive mode (type 'quit' to exit):");
        
        while (true) {
            System.out.print("Enter array size (or 'quit'): ");
            if (!sc.hasNextInt()) break;
            
            int n = sc.nextInt();
            int[] testNums = new int[n];
            System.out.println("Enter " + n + " integers:");
            for (int i = 0; i < n; i++) {
                testNums[i] = sc.nextInt();
            }
            
            NumArrayLocal testArray = new NumArrayLocal(testNums);
            testArray.printPrefix();
            
            System.out.print("Enter left right (or -1 to skip): ");
            if (sc.hasNextInt()) {
                int left = sc.nextInt();
                int right = sc.nextInt();
                System.out.println("sumRange(" + left + "," + right + ") = " + 
                                 testArray.sumRange(left, right));
            }
        }
        sc.close();
    }
}

