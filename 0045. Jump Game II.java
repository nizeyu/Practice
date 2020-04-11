class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int[] steps = new int[nums.length];
        for (int i = 0; i < steps.length; i++) {
            steps[i] = Integer.MAX_VALUE;
        }
        steps[0] = 0;
        
        for (int i = 1; i < steps.length; i++) {
            for (int j = 0; j < i; j++) {
                if (steps[j] != Integer.MAX_VALUE && j + nums[j] >= i) {
                    steps[i] = Math.min(steps[i], steps[j] + 1);
                }
            }
        }
        
        return steps[steps.length-1]; 
    }
}
