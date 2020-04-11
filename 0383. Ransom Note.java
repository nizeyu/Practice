class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[256];
        for (int i = 0; i < magazine.length(); i++) {
            map[magazine.charAt(i)]++;
        }
        
        for (int i = 0; i < ransomNote.length(); i++) {
            if (map[ransomNote.charAt(i)] <= 0) {
                return false;
            }
            
            map[ransomNote.charAt(i)]--;
        }
        
        return true;
    }
}
