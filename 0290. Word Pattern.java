class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        
        if (pattern.length() != strs.length) {
            return false;
        }
        
        Map<Character, String> map1 = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (map1.containsKey(pattern.charAt(i))) {
                if (!map1.get(pattern.charAt(i)).equals(strs[i])) {
                    return false;
                }
            } else {
                map1.put(pattern.charAt(i), strs[i]);
            }
        }
        
        Map<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (map2.containsKey(strs[i])) {
                if (!map2.get(strs[i]).equals(pattern.charAt(i))) {
                    return false;
                }
            } else {
                map2.put(strs[i], pattern.charAt(i));
            }
        }
        
        return true;
    }
}
