class Solution {
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '*') {
                left++;
            } else {
                left--;
            }
            
            if (left < 0) {
                return false;
            }
        }
        
        if (left == 0) {
            return true;
        }
        
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')' || c == '*') {
                right++;
            } else {
                right--;
            }
            
            if (right < 0) {
                return false;
            }
        }
        
        return true;
    }
}
