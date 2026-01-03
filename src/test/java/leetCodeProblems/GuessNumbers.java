package leetCodeProblems;

public class GuessNumbers  {
    private int secretPick = 6;  // CHANGE THIS VALUE TO TEST DIFFERENT PICKS
    
    public int guess(int num) {
        if (num > secretPick) return -1;
        if (num < secretPick) return 1;
        return 0;
    }
    
    public int guessNumber(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if (res == 0) return mid;
            else if (res < 0) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
    
    //test cases
    public static void main(String[] args) {
        GuessNumbers sol = new GuessNumbers();
        
        // Example 1
        sol.secretPick = 6;
        System.out.println("n=10 → " + sol.guessNumber(10));
        
        // Example 2
        sol.secretPick = 1;
        System.out.println("n=1 → " + sol.guessNumber(1));
        
        // Example 3  
        sol.secretPick = 1;
        System.out.println("n=2 → " + sol.guessNumber(2));
    }
}

