// 递归
class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        
        String strs = countAndSay(n - 1) + "#";
        StringBuilder sb = new StringBuilder();
        
        int count = 1;
        for (int i = 0; i < strs.length() - 1; i++) {
            if (strs.charAt(i) != strs.charAt(i + 1)) {
                sb.append(count);
                sb.append(strs.charAt(i));
                count = 1;
            } else {
                count++;
            } 
        }
        
        return sb.toString();
    }
}
