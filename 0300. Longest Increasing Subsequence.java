class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // state
        int[] lis = new int[nums.length];
        
        // initialize
        for (int i = 0; i < lis.length; i++) {
            lis[i] = 1;
        }
        
        // function
        for (int i = 0; i < lis.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }
        
        // answer
        int max = 0;
        for (int i = 0; i < lis.length; i++) {
            max = Math.max(max, lis[i]);
        }
        
        return max;
    }
}
