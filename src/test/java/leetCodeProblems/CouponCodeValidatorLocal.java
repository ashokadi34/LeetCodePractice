package leetCodeProblems;

import java.util.*;

public class CouponCodeValidatorLocal {

    
    public static List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;

        // business line -> priority
        Map<String, Integer> order = new HashMap<>();
        order.put("electronics", 0);
        order.put("grocery", 1);
        order.put("pharmacy", 2);
        order.put("restaurant", 3);

        List<Integer> idx = new ArrayList<>();

        // filter valid coupons
        for (int i = 0; i < n; i++) {
            if (!isActive[i]) continue;                            // must be active
            if (!order.containsKey(businessLine[i])) continue;     // valid business line
            if (!isValidCode(code[i])) continue;                   // valid code format
            idx.add(i);
        }

        // sort by business line priority, then lexicographically by code
        Collections.sort(idx, (i, j) -> {
            int oi = order.get(businessLine[i]);
            int oj = order.get(businessLine[j]);
            if (oi != oj) return Integer.compare(oi, oj);
            return code[i].compareTo(code[j]);
        });

        // build the result
        List<String> res = new ArrayList<>();
        for (int i : idx) {
            res.add(code[i]);
        }
        return res;
    }
    
//    isValidCode method for validation
    private static boolean isValidCode(String s) {
        if (s == null || s.length() == 0) return false;
        for (int k = 0; k < s.length(); k++) {
            char c = s.charAt(k);
            if (!(Character.isLetterOrDigit(c) || c == '_')) {
                return false;
            }
        }
        return true;
    }

    // Helper to print arrays nicely
    private static String arrToString(String[] arr) {
        return Arrays.toString(arr);
    }

    public static void main(String[] args) {
        // Example 1
        String[] code1 = {"SAVE20", "", "PHARMA5", "SAVE@20"};
        String[] bl1   = {"restaurant", "grocery", "pharmacy", "restaurant"};
        boolean[] ac1  = {true, true, true, true};
        System.out.println("Example 1:");
        System.out.println("code         = " + arrToString(code1));
        System.out.println("businessLine = " + arrToString(bl1));
        System.out.println("isActive     = " + Arrays.toString(ac1));
        System.out.println("Output       = " + validateCoupons(code1, bl1, ac1));
        // Expected: ["PHARMA5","SAVE20"]

        System.out.println();

        // Example 2
        String[] code2 = {"GROCERY15", "ELECTRONICS_50", "DISCOUNT10"};
        String[] bl2   = {"grocery", "electronics", "invalid"};
        boolean[] ac2  = {false, true, true};
        System.out.println("Example 2:");
        System.out.println("code         = " + arrToString(code2));
        System.out.println("businessLine = " + arrToString(bl2));
        System.out.println("isActive     = " + Arrays.toString(ac2));
        System.out.println("Output       = " + validateCoupons(code2, bl2, ac2));
        // Expected: ["ELECTRONICS_50"]

        // Simple interactive demo (optional)
        Scanner sc = new Scanner(System.in);
        System.out.println("\nInteractive demo (small):");
        System.out.println("Enter number of coupons (<= 5) or 0 to quit:");
        int n = sc.nextInt();
        if (n > 0) {
            sc.nextLine(); // consume newline
            String[] code = new String[n];
            String[] bl = new String[n];
            boolean[] active = new boolean[n];

            for (int i = 0; i < n; i++) {
                System.out.println("Coupon " + (i + 1) + " code:");
                code[i] = sc.nextLine().trim();
                System.out.println("Coupon " + (i + 1) + " businessLine:");
                bl[i] = sc.nextLine().trim();
                System.out.println("Coupon " + (i + 1) + " active? (true/false):");
                active[i] = Boolean.parseBoolean(sc.nextLine().trim());
            }

            List<String> res = validateCoupons(code, bl, active);
            System.out.println("Valid coupons (sorted): " + res);
        }
        sc.close();
    }
}

