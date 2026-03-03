package leetCodeProblems;

public class FindKthBitLocal {
    public static char findKthBit(int n, int k) {
        return (char)('0' + dfs(n, k));
    }
    
    private static int dfs(int n, int k) {
        if (k == 1) return 0;
        if ((k & (k - 1)) == 0) return 1;
        
        int len = 1 << n;  // 2^n
        if (k * 2 < len - 1) {
            return dfs(n - 1, k);
        }
        return dfs(n - 1, len - k) ^ 1;
    }
    
    //Test cases
    public static void main(String[] args) {
        // Example 1
        System.out.println("n=3, k=1: " + findKthBit(3, 1));  // "0"
        
        // Example 2
        System.out.println("n=4, k=11: " + findKthBit(4, 11));  // "1"
        
        // Additional tests
        System.out.println("n=1, k=1: " + findKthBit(1, 1));  // "0"
        System.out.println("n=2, k=2: " + findKthBit(2, 2));  // "1"
        System.out.println("n=3, k=4: " + findKthBit(3, 4));  // "1"
        System.out.println("n=4, k=1: " + findKthBit(4, 1));  // "0"
        System.out.println("n=4, k=8: " + findKthBit(4, 8));  // "1"
    }
}
