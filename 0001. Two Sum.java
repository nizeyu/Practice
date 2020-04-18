// 方法：HashMap
// time: O(n)
// space: O(n)
// 暴力解法需要找到 nums 中两两元素的组合，复杂度为O(n^2)。hashmap的应用，把这个过程变成了one pass。
// hashmap 既能记录下遍历过元素的value-index pair, 又能在O(1) 时间判断 target - nums[i] 的值是否存在。
// 本题不能用 sort后双指针的方法，因为要求返回index，而排序后index 就乱了。
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            } 
            
            map.put(nums[i], i);
        }
        
        return result;
    }
}
