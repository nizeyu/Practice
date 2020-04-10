class Solution {
    public boolean canPermutePalindrome(String s) {
        
        int[] map = new int[256];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
        }
        
        boolean flag = false;
        for (int i = 0; i < 256; i++) {
            if (flag && map[i] % 2 == 1) {
                return false;
            }
            
            
            if (map[i] % 2 == 1) {
                flag = true;
            }
        }
        
        return true;
    }
}
