// 方法一
// 核心思路：一个指针指向答案数组的位置，另一个指针去找和val 值不同的位置
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int id = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[id] = nums[i];
                id++;
            }
        }
        
        return id;
    }
}
