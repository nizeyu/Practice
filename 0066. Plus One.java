class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[0];
        }
        
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 < 10) {
                carry = 0;
                digits[i] += 1;
                return digits;
            } else {
                carry = 1;
                digits[i] = 0;
            }
        }
        
        if (carry == 1) {
           int[] res = new int[digits.length + 1];
           res[0] = 1;
           return res;
        }
        
        return digits;
    }
}
