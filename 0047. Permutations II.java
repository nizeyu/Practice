class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        
        if (nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }

        Arrays.sort(nums);
        dfs(new ArrayList<>(), nums, new boolean[nums.length], result);
        
        return result;
    }
    
    private void dfs(List<Integer> list, int[] nums, boolean[] visited, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            
            if (i != 0 && nums[i] == nums[i-1] && !visited[i-1]) {
                continue;
            }
            
            list.add(nums[i]);
            visited[i] = true;
            dfs(list, nums, visited, result);
            visited[i] = false;
            list.remove(list.size() - 1);
            
        }
    }
}
