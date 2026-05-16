package leetCodeProblems;

public class CountSegments {
    public static int countSegments(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                count++;
            }
        }
        return count;
    }

    //Test cases
    public static void main(String[] args) {
        System.out.println(countSegments("Hello, my name is John")); // 5
        System.out.println(countSegments("Hello"));                  // 1
        System.out.println(countSegments(""));                       // 0
        System.out.println(countSegments("   a  b   "));             // 2
    }
}