class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int l = 0;
        int r = nums.length - 1;
        while(l + 1 < r) {
            int mid = l + (r - l) / 2;
                        
            if (target == nums[mid]) {
                return mid; 
            } else if (target < nums[mid]) {
                r = mid;
            } else {
                l = mid;
            }
        }
        
        if (nums[l] >= target) { 
            return l;
        }
        
        if (nums[r] >= target) {
            return r;
        }
        
        return nums.length;
    }
}

class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        return lowerBound(nums, target);
    }
    
    private int lowerBound(int[] nums, int target) {
        
        int l = 0;
        int r = nums.length;
        
        while (l < r) {
            int mid = l + (r - l) / 2;
            
            if (target <= nums[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        return l;
    }
}
