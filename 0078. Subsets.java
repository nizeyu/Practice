class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        
        if (nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        
        Arrays.sort(nums);
        
        dfs(0, new ArrayList<>(), nums, result);
        
        return result;
    }
    
    private void dfs(int pos, List<Integer> subset, int[] nums, List<List<Integer>> result) {
        result.add(new ArrayList<>(subset));
        
        for (int i = pos; i < nums.length; i++) {
            subset.add(nums[i]);
            dfs(i + 1, subset, nums, result);
            subset.remove(subset.size() - 1);
        }
    }
}
