// 方法一
// 核心思路：一个指针指向不重复数组的位置，另一个指针去找发生值改变的位置
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        
        if (nums.length < 2) {
            return nums.length;
        }
        
        int id = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[id] = nums[i];
                id++;
            }
        }
        
        return id;
    }
}

// 方法二
// 核心思路：使用快慢指针来记录遍历的坐标，
// 最开始时两个指针都指向第一个数字，如果两个指针指的数字相同，则快指针向前走一步，
// 如果不同，则两个指针都向前走一步，
// 这样当快指针走完整个数组后，慢指针当前的坐标加1就是数组中不同数字的个数
