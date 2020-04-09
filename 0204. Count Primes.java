class Solution {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        
        boolean[] isNotPrime = new boolean[n];
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (!isNotPrime[i]) {
                for (int j = i; j * i < n; j++) {
                    isNotPrime[j * i] = true;
                }
            }
        }
        
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isNotPrime[i]) {
                count++;
            }
        }
        
        return count;
    }
}
