class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null) {
            return result;
        }
        
        if (s.length() == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        
        dfs(0, new ArrayList<>(), s, result);
        
        return result;
    }
    
    private void dfs(int start, List<String> partition, String s, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(partition));
        }
        
        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i + 1);
            if (!isPalindrome(sub)) {
                continue;
            }
            
            partition.add(sub);
            dfs(i + 1, partition, s, result);
            partition.remove(partition.size() - 1);
        }
    }
    
    private boolean isPalindrome(String sub) {
        int i = 0;
        int j = sub.length() - 1;
        while (i < j) {
            if (sub.charAt(i) != sub.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
