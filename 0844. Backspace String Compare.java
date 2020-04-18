// Two Pointers: 逆向思维
class Solution {
    public boolean backspaceCompare(String S, String T) {
        if (S == null || T == null) {
            return false;
        }
        
        int i = S.length() - 1, j = T.length() - 1;
        int s = 0, t = 0;
        
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    s++;
                    i--;
                } else {
                    if (s > 0) {
                        s--;
                        i--;
                    } else {
                        break;
                    }
                }
            }
            
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    t++;
                    j--;
                } else {
                    if (t > 0) {
                        t--;
                        j--;
                    } else {
                        break;
                    }
                }
            }
            
            if (i < 0 || j < 0) {
                return i < 0 && j < 0;
            }
            
            if (S.charAt(i) != T.charAt(j)) {
                return false;
            }
            
            i--;
            j--;
        }
        
        return true;
    }
}
