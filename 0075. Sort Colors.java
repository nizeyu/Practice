class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;   
        }
        
        int i = 0; // pointer
        int l = 0; // red
        int r = nums.length - 1; // blue
        
        while (i <= r) {
            if (nums[i] == 0) {
                swap(i, l, nums);
                i++;
                l++;
            } else if (nums[i] == 2) {
                swap(i, r, nums);
                r--;
            } else {
                i++;
            }
        }
        
        return;
    }
    
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
