package leetCodeProblems;

class MinDistance {
    public int minDistances(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) dp[i][0] = i;
        for (int j = 1; j <= n; j++) dp[0][j] = j;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }
        
        return dp[m][n];
    }
    
    //test cases
    public static void main(String[] args) {
    	MinDistance sol = new MinDistance();
        String[][] tests = {
            {"horse", "ros"},
            {"intention", "execution"},
            {"", "a"},
            {"a", ""},
            {"sea", "eat"},
            {"intention", "execution"}
        };
        
        for (String[] test : tests) {
            int result = sol.minDistances(test[0], test[1]);
            System.out.printf("\"%s\" → \"%s\" = %d%n", test[0], test[1], result);
        }
    }
}
