class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> res = new ArrayList<>();
        
        int m = s.length();
        int n = p.length();
        
        int[] map = new int[256];
        for (int i = 0; i < n; i++) {
            map[p.charAt(i)]++;
        }
        
        int start = 0;
        int cnt = 0;
        for (int end = 0; end < m; end++) {
            if (end - start == n) {
                if (map[s.charAt(start)] >= 0) {
                    cnt--;
                }
                map[s.charAt(start)]++;
                start++;
            }
            
            if (map[s.charAt(end)] > 0) {
                cnt++;
            } 
            
            map[s.charAt(end)]--;
            
            if (cnt == n) {
                res.add(start);
            }
        }
        
        return res;
    }
}
