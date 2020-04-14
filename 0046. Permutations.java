class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        
        if (nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        
        dfs(new ArrayList<>(), nums, result);
        
        return result;
    }
    
    private void dfs(List<Integer> list, int[] nums, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            
            list.add(nums[i]);
            dfs(list, nums, result);
            list.remove(list.size() - 1);
        }    
    }
}
