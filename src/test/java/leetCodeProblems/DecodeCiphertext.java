package leetCodeProblems;

public class DecodeCiphertext {

    static class Solution {
        public String decodeCiphertext(String encodedText, int rows) {
            if (rows == 1) return encodedText.trim();
            
            int n = encodedText.length();
            int cols = n / rows;
            StringBuilder sb = new StringBuilder();
            
            for (int startCol = 0; startCol < cols; startCol++) {
                for (int r = 0, c = startCol; r < rows && c < cols; r++, c++) {
                    int idx = r * cols + c;
                    sb.append(encodedText.charAt(idx));
                }
            }
            
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length() - 1);
            }
            
            return sb.toString();
        }
    }

    //Test cases
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1: "ch   ie   pr" -> "cipher"
        System.out.println(sol.decodeCiphertext("ch   ie   pr", 3));
        
        // Example 2: "iveo    eed   l te   olc" -> "i love leetcode"
        System.out.println(sol.decodeCiphertext("iveo    eed   l te   olc", 4));
        
        // Example 3: "coding" -> "coding"
        System.out.println(sol.decodeCiphertext("coding", 1));
    }
}