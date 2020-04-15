class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        
        if (str == null || str.length() == 0) {
            return 0;
        }
        
        int i = 0;
        boolean sign = true;
        if (str.charAt(i) == '+' || str.charAt(i) == '-' ) {
            if (str.charAt(i) == '-') {
                sign = false;
            }
            i++;
        }
        
        if (i < str.length() && !Character.isDigit(str.charAt(i))) {
            return 0;
        }
        
        // check leading zeros
        while(i < str.length() && str.charAt(i) == '0'){
            i++;
        }
        
        long num = 0;
        int digit = 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            int c = str.charAt(i) - '0';
            
            num = num * 10 + c;
            digit++;
            i++;
        }
        
        // overflow case
        if(digit > 10){
            if(sign) return Integer.MAX_VALUE;
            return Integer.MIN_VALUE;
        }
               
        // overflow with 10 digits
        if(!sign && num + Integer.MIN_VALUE > 0){
            return Integer.MIN_VALUE;
        }
               
        // overflow with 10 digits
        if(sign && num >= Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
               
        // check sign and return value
        return sign ? (int) num : (int) - num;
    }
}
