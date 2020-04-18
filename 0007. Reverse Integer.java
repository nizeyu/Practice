// res = res * 10 + x % 10; x % 10 如果有值，原来获得的那些高位就应该 *10， 再去加这个低位。
class Solution {
    public int reverse(int x) {
        boolean flag = false;
        if(x < 0)
            flag = true;
        x = Math.abs(x);
        
        long res = 0;
        while(x > 0) {
            res = res * 10 + x % 10;
            if(res > Integer.MAX_VALUE) {
                return 0;
            }
            x /= 10;
        }
        if(flag)
            return -(int)res;
        else
            return (int)res;
    }
}
