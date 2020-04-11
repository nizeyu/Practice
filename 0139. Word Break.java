class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int maxLength = getMaxLength(wordDict);
        
        boolean[] canSegment = new boolean[s.length() + 1];
        canSegment[0] = true;
        
        for (int i = 1; i < canSegment.length; i++) {
            for (int lastWordLength = 1; lastWordLength <= maxLength && lastWordLength <= i; lastWordLength++) {
                if (!canSegment[i - lastWordLength]) {
                    continue;
                }
                
                String word = s.substring(i - lastWordLength, i);
                if (wordDict.contains(word)) {
                    canSegment[i] = true;
                    break;
                } 
            }
        } 
        
        return canSegment[s.length()];
    }
    
    private int getMaxLength(List<String> wordDict) {
        int max = 0;
        for (String word: wordDict) {
            max = Math.max(max, word.length());
        }
        
        return max;
    }
}
