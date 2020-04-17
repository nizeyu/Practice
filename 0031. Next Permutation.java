class Solution {
    // Time: O(n)
    // Space: O(1)
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int firstSmall = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                firstSmall = i;
                break;
            }
        }
        
        if (firstSmall == -1) {
            reverseArray(0, nums.length - 1, nums);
            return;
        }
        
        int firstLarge = -1;
        for (int i = nums.length - 1; i > firstSmall; i--) {
            if (nums[i] > nums[firstSmall]) {
                firstLarge = i;
            }
            break;
        }
        
        swap(firstSmall, firstLarge, nums);
        
        reverseArray(firstSmall + 1, nums.length - 1, nums);
    }
    
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverseArray(int l, int r, int[] nums) {
        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            
            l++;
            r--;
        }
    }
}
