class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(); 
        for (String word : wordList) { //将wordList中的单词加入dict
            dict.add(word);
        }
        
        if (beginWord.equals(endWord)) {
            return 1;
        }
        
        Set<String> visited = new HashSet<>();
        Queue<String> q =  new LinkedList<>();
        q.offer(beginWord);
        visited.add(beginWord);
        int length = 1;
        
        while (!q.isEmpty()) {
            int size = q.size();
            length++;
            
            for (int i = 0; i < size; i++) {
                String word = q.poll();
                
                List<String> nextWords = getNextWords(word, dict);
                for (String nextWord : nextWords) {
                    if (visited.contains(nextWord)) {
                        continue;
                    }
                    
                    if (nextWord.equals(endWord)) {
                        return length;
                    }
                    
                    q.offer(nextWord);
                    visited.add(nextWord);
                }
            }
        }
                 
        return 0;
    }
    
    // get connections with given word.
    // for example, given word = 'hot', dict = {'hot', 'hit', 'hog'}
    // it will return ['hit', 'hog']
    private List<String> getNextWords(String word, Set<String> dict) {
        List<String> nextWords = new ArrayList<>();
        
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                
                String nextWord = replace(c, i, word);
                
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        
        return nextWords;
    }  
    
    // replace character of a string at given index to a given character
    // return a new string
    private String replace(char c, int index, String word) {
        char[] chars = word.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
}
