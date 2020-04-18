class Solution {
    public int numFriendRequests(int[] ages) {
        if (ages == null || ages.length < 2) {
            return 0;
        }
        
        int[] count = new int[121];
        for (int age : ages) {
            count[age]++;
        }
        
        int ans = 0;
        // i -> ageA  j -> ageB
        for (int i = 120; i >= 0; i--) {
            int countA = count[i];
            for (int j = 120; j >= 0; j--) {
                int countB = count[j];
                
                if (j <= 0.5 * i + 7) {
                    continue;
                }
                
                if (i < j) {
                    continue;
                }
                
                if (i < 100 && 100 < j) {
                    continue;
                }
                
                ans += countA * countB;
                
                if (i == j) {
                    ans -= countA;
                }
            }
        }
        
        return ans;
    }
}
