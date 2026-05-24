package leetCodeProblems;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                sum += (num >> i) & 1;
            }
            sum %= 3;
            if (sum != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
    // Test cases
    public static void main(String[] args) {
        SingleNumber sol = new SingleNumber();

        int[] nums1 = {2, 2, 3, 2};
        System.out.println(sol.singleNumber(nums1));  // 3

        int[] nums2 = {0, 1, 0, 1, 0, 1, 99};
        System.out.println(sol.singleNumber(nums2));  // 99
    }
}
