class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        int l = 0;
        int r = nums.length - 1;
        while(l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            
            if (nums[l] < nums[mid]) {
                if (target <= nums[mid] && target >= nums[l]) {
                    r = mid;
                } else {
                    l = mid;
                }
            } else {
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
        }
        
        if (nums[l] == target) {
            return l;
        }
        
        if (nums[r] == target) {
            return r;
        }

        
        return -1;
    }
}
