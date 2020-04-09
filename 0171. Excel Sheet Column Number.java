class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = s.length() - 1; i >= 0 ; i--) {
            int num = s.charAt(i) - 'A' + 1;
            int pow = (int)Math.pow(26, s.length() - i - 1);
            
            result += num * pow;
        }
        
        return result;
    }
}
