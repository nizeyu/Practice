class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int i = 0;//pointer for 0
        int j = 0;//pointer for not 0
        while (i < nums.length && j < nums.length) {
            while (j < nums.length - 1 && nums[j] == 0) {
                j++;
            }
            
            swap(i, j, nums);
            
            i++;
            j++;
        }
    }
    
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
