class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        int n = nums.length;
        
        int[] sums = new int[n + 1];
        sums[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }
        
        for (int i = 0; i < sums.length; i++) {
            for (int j = i + 2; j < sums.length; j++) {
                int sum = sums[j] - sums[i];
                
                if (sum == k || (k != 0 && sum % k == 0)) {
                    return true;
                }
            }
        }
    
        return false;
    }
}
