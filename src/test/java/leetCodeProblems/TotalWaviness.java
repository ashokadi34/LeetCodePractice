package leetCodeProblems;

public class TotalWaviness {

    public int totalWaviness(int num1, int num2) {
        int total = 0;
        
        for (int num = num1; num <= num2; num++) {
            total += calculateWaviness(num);
        }
        
        return total;
    }
    
    private int calculateWaviness(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        
        if (n < 3) return 0;
        
        int waviness = 0;
        
        for (int i = 1; i < n - 1; i++) {
            int prev = s.charAt(i - 1) - '0';
            int curr = s.charAt(i) - '0';
            int next = s.charAt(i + 1) - '0';
            
            if (curr > prev && curr > next) {
                waviness++;
            } else if (curr < prev && curr < next) {
                waviness++;
            }
        }
        
        return waviness;
    }

    public static void main(String[] args) {
        TotalWaviness sol = new TotalWaviness();

        // Example 1
        System.out.println(sol.totalWaviness(120, 130)); // 3

        // Example 2
        System.out.println(sol.totalWaviness(198, 202)); // 3

        // Example 3
        System.out.println(sol.totalWaviness(4848, 4848)); // 2
    }
}