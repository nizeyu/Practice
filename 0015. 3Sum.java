class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        
        Arrays.sort(nums);
        List<Integer> temp = null;
        
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);
                    
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    
                    while (left < right - 1 && nums[right] == nums[right - 1]) {
                        right--;
                    }
                }
                if (sum <= 0) {
                    left++;
                } else if (sum >= 0) {
                    right--;
                } 
            } 
        }
        
        return result;
    }
}
