public class ReverseDegreeOfString {

    public static int reverseDegree(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int reversedPos = 26 - (c - 'a'); // 'a'->26, ..., 'z'->1
            int index = i + 1;                // 1-based index
            sum += reversedPos * index;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(reverseDegree("abc"));   // Expected: 148
        System.out.println(reverseDegree("zaza"));  // Expected: 160
    }
}