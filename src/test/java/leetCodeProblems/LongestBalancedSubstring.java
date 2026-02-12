package leetCodeProblems;

public class LongestBalancedSubstring {
    public static int longestBalanced(String s) { //function
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int[] freq = new int[26];
            for (int j = i; j < n; ++j) {
                ++freq[s.charAt(j) - 'a'];
                int exp = -1;
                boolean bal = true;
                for (int f : freq) {
                    if (f > 0) {
                        if (exp == -1) exp = f;
                        else if (f != exp) {
                            bal = false;
                            break;
                        }
                    }
                }
                if (bal) ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }

    
    //Test Cases
    public static void main(String[] args) {
        // Example 1
        String s1 = "abbac";
        System.out.println("s=\"" + s1 + "\": " + longestBalanced(s1));  // 4

        // Example 2
        String s2 = "zzabccy";
        System.out.println("s=\"" + s2 + "\": " + longestBalanced(s2));  // 4

        // Example 3
        String s3 = "aba";
        System.out.println("s=\"" + s3 + "\": " + longestBalanced(s3));  // 2

        // Edge cases
        System.out.println("s=\"a\": " + longestBalanced("a"));  // 1
        System.out.println("s=\"aa\": " + longestBalanced("aa"));  // 2
        System.out.println("s=\"abc\": " + longestBalanced("abc"));  // 3
    }
}
