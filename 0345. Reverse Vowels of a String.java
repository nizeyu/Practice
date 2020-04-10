class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        
        char[] str = s.toCharArray();
        int l = 0;
        int r = str.length - 1;
        while (l < r) {
            while (l < r && !set.contains(str[l])) {
                l++;
            }
            
            while (l < r && !set.contains(str[r])) {
                r--;
            }
            
            Character t = str[l];
            str[l] = str[r];
            str[r] = t;
            
            l++;
            r--;
        }
        
        return new String(str);
    }
}
