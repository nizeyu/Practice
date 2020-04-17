class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        
        int pre = nums[0];
        int[] output = new int[nums.length];
        output[0] = 1;
        for (int i = 1; i < output.length; i++) {
            output[i] = pre;
            pre *= nums[i];
        }
        
        int post = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            output[i] *= post;
            post *= nums[i];
        }
        
        return output;
    }
}
