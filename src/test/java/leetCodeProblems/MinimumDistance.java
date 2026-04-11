package leetCodeProblems;

public class MinimumDistance {
    public static int minimumDistance(int[] nums) {
        int n = nums.length;
        int[] next = new int[n];
        int[] last = new int[n + 1];
        
        // Initialize
        for (int i = 0; i < n; i++) {
            next[i] = -1;
        }
        for (int v = 0; v <= n; v++) {
            last[v] = -1;
        }
        
        // Build next[] array from right to left
        for (int i = n - 1; i >= 0; i--) {
            int value = nums[i];
            next[i] = last[value];
            last[value] = i;
        }
        
        int answer = Integer.MAX_VALUE;
        // Scan for consecutive triples
        for (int i = 0; i < n; i++) {
            int second = next[i];
            if (second == -1) continue;
            
            int third = next[second];
            if (third == -1) continue;
            
            answer = Math.min(answer, (third - i) * 2);
        }
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    public static void main(String[] args) {
       
        // Example 1 → 6
        int[] nums1 = {1,2,1,1,3};
        System.out.println(minimumDistance(nums1));
        
        // Example 2 → 8
        int[] nums2 = {1,1,2,3,2,1,2};
        System.out.println(minimumDistance(nums2));
        
        // Example 3 → -1
        int[] nums3 = {1};
        System.out.println(minimumDistance(nums3));
    }
}