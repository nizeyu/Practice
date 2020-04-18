// 方法一：reverse
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
        int y = reverse(x);
        
        if (x == y) {
            return true;
        }
        
        return false;
    }
    
    public int reverse(int x) {
        int m = Math.abs(x);
        
        long result = 0;
        while(m > 0) {
            result = result * 10 + m % 10;
            if(result > Integer.MAX_VALUE) {
                return 0;
            }
            m /= 10;
        }
        
        if(x < 0) {
            return -(int)result;
        }
        
        return (int)result;
    }
}

// 方法二：直接比较原数
