class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s.length() < t.length()) {
            String temp = s;
            s = t;
            t = temp;
        }
        
        int m = s.length();
        int n = t.length();
        int diff = m - n;
        
        if (diff >= 2) {
            return false;
        } 
        
        if (diff == 0) {
            int count = 0;
            for(int i = 0; i < m; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    count++;
                }
            }
            return count == 1;
        }
        
        if (diff == 1) {
            for(int i = 0; i < n; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    return s.substring(i+1).equals(t.substring(i));
                }
            }
        }
        
        return true;
    }
}
