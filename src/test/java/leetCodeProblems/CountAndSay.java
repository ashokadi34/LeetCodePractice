package leetCodeProblems;

public class CountAndSay {
    public static String countAndSay(int n) {
        String curr = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder next = new StringBuilder();
            int count = 1;
            for (int j = 1; j <= curr.length(); j++) {
                if (j == curr.length() || curr.charAt(j) != curr.charAt(j - 1)) {
                    next.append(count).append(curr.charAt(j - 1));
                    count = 1;
                } else {
                    count++;
                }
            }
            curr = next.toString();
        }
        return curr;
    }

    //Test cases
    public static void main(String[] args) {
        // Example 1: n = 4
        System.out.println("n=4: " + countAndSay(4));  // "1211"

        // Example 2: n = 1
        System.out.println("n=1: " + countAndSay(1));  // "1"

        // Additional tests
        System.out.println("n=2: " + countAndSay(2));  // "11"
        System.out.println("n=3: " + countAndSay(3));  // "21"
        System.out.println("n=5: " + countAndSay(5));  // "111221"
        System.out.println("n=6: " + countAndSay(6));  // "312211"
    }
}

