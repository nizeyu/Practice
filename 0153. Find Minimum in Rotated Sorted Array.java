class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0 ) {
            return -1;
        }
               
        int l = 0;
        int r = nums.length - 1;
        int target = nums[nums.length - 1];
        while(l + 1 < r) {
            int mid = l + (r - l) / 2;
                        
            if (target <= nums[mid]) {
                l = mid; 
            } else {
                r = mid;
            }
        }
        
        if (nums[l] <= target) { 
            return nums[l];
        }
        
        return nums[r];
    }
}
