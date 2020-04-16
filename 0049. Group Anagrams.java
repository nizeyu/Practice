class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);
            
            if (map.containsKey(s)) {
                List<String> list = result.get(map.get(s));
                list.add(strs[i]);
            } else {
                map.put(s, result.size());
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                result.add(list);
            }
        }
        
        return result;
    }
}
