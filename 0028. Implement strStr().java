class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        
        int result = 0;
        
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            
            if (haystack.charAt(i) == needle.charAt(0)) {
                int k = i;
                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(k) != needle.charAt(j)) {
                        break;
                    }
                    k++;
                    
                    if (j == needle.length() - 1) {
                        return i;
                    }
                }
            }         
        }
        
        return -1;
    }
}
