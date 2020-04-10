class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> results = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return results;
        }
        
        char[] strs = s.toCharArray();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i] == '+' && strs[i-1] == '+') {
                strs[i] = '-';
                strs[i-1] = '-';
                results.add(String.valueOf(strs));
                strs[i] = '+';
                strs[i-1] = '+';
            }
        }
        
        return results;
    }
}
