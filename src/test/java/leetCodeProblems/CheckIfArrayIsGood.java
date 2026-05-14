package leetCodeProblems;

public class CheckIfArrayIsGood {
    
    public static boolean isGood(int[] nums) {
        int n = nums.length - 1;
        int max = 0;
        int[] count = new int[201];
        
        for (int num : nums) {
            max = Math.max(max, num);
            count[num]++;
        }
        
        if (max != n) return false;
        if (count[n] != 2) return false;
        
        for (int i = 1; i < n; i++) {
            if (count[i] != 1) return false;
        }
        
        return true;
    }

    //Test cases
    public static void main(String[] args) {
        // Example 1
        System.out.println(isGood(new int[]{2, 1, 3}));     // false
        
        // Example 2  
        System.out.println(isGood(new int[]{1, 3, 3, 2})); // true
        
        // Example 3
        System.out.println(isGood(new int[]{1, 1}));       // true
        
        // Example 4
        System.out.println(isGood(new int[]{3, 4, 4, 1, 2, 1})); // false
    }
}
