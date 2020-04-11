class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        boolean[] can = new boolean[nums.length];
        can[0] = true;
        
        for (int i = 1; i < can.length; i++) {
            for (int j = 0; j < i; j++) {
                if (can[j] && j + nums[j] >= i) {
                    can[i] = true;
                    break;
                }
            }
        }
        
        return can[can.length-1]; 
    }
}
