class Solution {
    public boolean isMonotonic(int[] A) {
        if (A == null || A.length == 0 || A.length == 1) {
            return true;
        }
        
        boolean inc = true;
        boolean dec = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i-1]) {
                dec = false;
            }
            
            if (A[i] < A[i-1]) {
                inc = false;
            }
            
            if (!dec && !inc) {
                return false;
            }
        }
        
        return true;
    }
}
