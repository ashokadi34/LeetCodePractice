package leetCodeProblems;

import java.util.Arrays;

class SortColorss {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    //Test case
    public static void main(String[] args) {
    	SortColorss sol = new SortColorss();
        int[] nums = {2,0,2,1,1,0};
        sol.sortColors(nums);
        System.out.println(Arrays.toString(nums)); // [0,0,1,1,2,2]
    }

}

