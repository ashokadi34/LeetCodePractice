package leetCodeProblems;

public class PlusOne {
	
	//function
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        PlusOne sol = new PlusOne();
        
        int[][] tests = {
            {1,2,3},     // -> [1,2,4]
            {4,3,2,1},   // -> [4,3,2,2]
            {9},         // -> [1,0]
            {9,9},       // -> [1,0,0]
            {9,9,9}      // -> [1,0,0,0]
        };

        for (int[] test : tests) {
            System.out.print("Input: [");
            for (int d : test) System.out.print(d + ",");
            System.out.print("] -> ");
            printArray(sol.plusOne(test));
        }
    }
    
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(",");
        }
        System.out.println("]");
    }
}

