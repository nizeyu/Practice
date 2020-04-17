class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
        }
        
        Arrays.sort(map);
        
        int max = map[map.length - 1];
        int cnt = 1;
        for (int i = map.length - 2; i >= 0; i--) {
            if (map[i] == max) {
                cnt++;
            } else {
                break;
            }
        }
        
        int intervals = (n + 1) * (max - 1) + cnt;
        
        return Math.max(tasks.length, intervals);
    }
}
