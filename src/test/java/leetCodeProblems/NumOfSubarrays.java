package leetCodeProblems;

public class NumOfSubarrays {

    public static int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;

        long count = 0;
        long evenPrefixes = 1; // Empty prefix has sum 0, which is even
        long oddPrefixes = 0;
        int prefixParity = 0;  // 0 = even, 1 = odd

        for (int num : arr) {
            prefixParity ^= (num & 1);

            if (prefixParity == 1) {
                count = (count + evenPrefixes) % MOD;
                oddPrefixes++;
            } else {
                count = (count + oddPrefixes) % MOD;
                evenPrefixes++;
            }
        }

        return (int) count;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5};
        System.out.println(numOfSubarrays(arr1)); // Output: 4

        int[] arr2 = {2, 4, 6};
        System.out.println(numOfSubarrays(arr2)); // Output: 0

        int[] arr3 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(numOfSubarrays(arr3)); // Output: 16
    }
}