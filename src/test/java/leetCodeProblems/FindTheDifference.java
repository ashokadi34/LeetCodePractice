package leetCodeProblems;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        char res = 0;
        
        for (int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i);
        }
        
        for (int i = 0; i < t.length(); i++) {
            res ^= t.charAt(i);
        }
        
        return res;
    }
    
    // Local testing
    public static void main(String[] args) {
        FindTheDifference sol = new FindTheDifference(); 
        
        System.out.println(sol.findTheDifference("abcd", "abcde")); // e
        System.out.println(sol.findTheDifference("", "y"));         // y
        System.out.println(sol.findTheDifference("a", "aa"));       // a
        System.out.println(sol.findTheDifference("ae", "aea"));     // a or e depending on extra
    }
}
