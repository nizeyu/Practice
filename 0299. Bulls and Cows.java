class Solution {
    public String getHint(String secret, String guess) {
        
        int bulls = 0;
        int cows = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);
            }
        }
        
        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                continue;
            }
            
            if (map.containsKey(guess.charAt(i)) && map.get(guess.charAt(i)) > 0) {
                cows++;
                map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(bulls);
        sb.append('A');
        sb.append(cows);
        sb.append('B');
        
        return sb.toString();
    }
}
