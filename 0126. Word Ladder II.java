class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(); 
        for (String word : wordList) { //将wordList中的单词加入dict
            dict.add(word);
        }
        
        if (!dict.contains(endWord)) {
            return new ArrayList<>();
        }
        
        List<List<String>> ladders = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> distances = new HashMap<>();
        
        dict.add(beginWord);
        dict.add(endWord);
        
        bfs(map, distances, endWord, beginWord, dict);
        
        List<String> path = new ArrayList<>();
        
        dfs(ladders, path, beginWord, endWord, distances, map);
        
        return ladders;
    }
    
    private void dfs(List<List<String>> ladders, List<String> path, String cur, String endWord, Map<String, Integer> distances, Map<String, List<String>> map) {
        
        path.add(cur);
        if (cur.equals(endWord)) {
            ladders.add(new ArrayList<String>(path));
        } else {
            for (String nextWord : map.get(cur)) {
                if (distances.containsKey(nextWord) && distances.get(cur) == distances.get(nextWord) + 1) {
                    dfs(ladders, path, nextWord, endWord, distances, map);
                }
            }
        }
        path.remove(path.size() - 1);
    }
    
    private void bfs(Map<String, List<String>> map, Map<String, Integer> distances, String start, String end, Set<String> dict) {
        Queue<String> q =  new LinkedList<>();
        q.offer(start);
        distances.put(start, 0);
        for (String s : dict) {
            map.put(s, new ArrayList<>());
        }
        
        while (!q.isEmpty()) {
            String word = q.poll();

            List<String> nextWords = getNextWords(word, dict);
            for (String nextWord : nextWords) {
                map.get(word).add(nextWord);
                if (distances.containsKey(nextWord)) {
                    continue;
                }

                q.offer(nextWord);
                distances.put(nextWord, distances.get(word) + 1);
            }
        }
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
