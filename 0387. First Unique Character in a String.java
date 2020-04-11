class Solution {
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0)
            return -1;
        
        int[] x = new int[256];
        int min = Integer.MAX_VALUE;
        
        for (int i  = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            if(x[index] > 0) {
                x[index] = Integer.MAX_VALUE;
            } else {
                x[index] = i+1;
            }
        }
        
        for(int i  = 0; i < 256; i++) {
            if(x[i] > 0) {
                min = Math.min(min, x[i]);
            }
        }
            
        if(min == Integer.MAX_VALUE) {
            return -1;
        }
            
        return min - 1;
    }
}
