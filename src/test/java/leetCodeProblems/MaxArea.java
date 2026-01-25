package leetCodeProblems;

import java.util.Arrays;

public class MaxArea {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        
        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int area = width * minHeight;
            maxArea = Math.max(maxArea, area);
            
            // Move pointer with smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
    
    public static void main(String[] args) {
        MaxArea sol = new MaxArea();
        
        // Example 1: [1,8,6,2,5,4,8,3,7] → 49
        int[] height1 = {1,8,6,2,5,4,8,3,7};
        System.out.println(sol.maxArea(height1));  // 49
        
        // Example 2: [1,1] → 1
        int[] height2 = {1,1};
        System.out.println(sol.maxArea(height2));  // 1
        
        // Additional test: [4,3,2,1,4] → 16 (0+4)
        int[] height3 = {4,3,2,1,4};
        System.out.println(sol.maxArea(height3));  // 16
    }
}
