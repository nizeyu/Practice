class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minLength = Math.min(minLength, strs[i].length());
        }
        
        if (minLength == 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
    
        for (int i = 0; i < minLength; i++) {
            char first = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (first != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(first);
        }
        
        return sb.toString();
    }
}
