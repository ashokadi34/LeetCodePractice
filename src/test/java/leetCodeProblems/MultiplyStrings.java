package leetCodeProblems;

public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int m = num1.length(), n = num2.length();
        int[] res = new int[m + n];
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + res[p2];
                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }
        // Build string, skip leading 0s
        StringBuilder sb = new StringBuilder();
        for (int num : res) {
            if (sb.length() > 0 || num != 0) sb.append(num);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    //Test Cases
    public static void main(String[] args) {
        // Example 1
        String num1_1 = "2", num2_1 = "3";
        System.out.println("2 * 3 = " + multiply(num1_1, num2_1));  // "6"

        // Example 2
        String num1_2 = "123", num2_2 = "456";
        System.out.println("123 * 456 = " + multiply(num1_2, num2_2));  // "56088"

        // Additional tests
        System.out.println("0 * 123 = " + multiply("0", "123"));  // "0"
        System.out.println("100 * 1 = " + multiply("100", "1"));  // "100"
        System.out.println("999 * 999 = " + multiply("999", "999"));  // "998001"
    }
}
