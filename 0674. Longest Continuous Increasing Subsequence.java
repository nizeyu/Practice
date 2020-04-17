class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        int count = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 1;
            }
        }
        
        if (max == Integer.MIN_VALUE) {
            return 1;
        }
        
        return max;    
    }
}
