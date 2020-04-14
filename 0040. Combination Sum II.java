class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null) {
            return result;
        }
        
        if (candidates.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        
        Arrays.sort(candidates);
        
        dfs(0, new ArrayList<>(), target, candidates, result);
        
        return result;
    }
    
    private void dfs(int start, List<Integer> candidate, int target, int[] candidates, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(candidate));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            
            if (candidates[i] > target) {
                break;
            }
            
            if (i != start && candidates[i] == candidates[i-1]) {
                continue;
            }
            
            candidate.add(candidates[i]);
            dfs(i + 1, candidate, target - candidates[i], candidates, result);
            candidate.remove(candidate.size() - 1);
        }
    }
}
