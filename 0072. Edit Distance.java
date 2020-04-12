class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        // state: f[i][j] 代表 word1 的前 i 个字符，通过最少多少次编辑，能够变成 word2 的前 j 个字符
        int[][] dp = new int[n+1][m+1];
        
        // initialize
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;// i 次 Delete 
        }
        
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;// j 次 Insert
        }
        
        // function
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i-1) != word2.charAt(j-1)) {
                                                 // replace       // Delete        // Insert
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1] + 1, dp[i-1][j] + 1), dp[i][j-1] + 1);
                } else {
                                                 // replace       // Delete        // Insert
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j] + 1), dp[i][j-1] + 1);                                       
                }
            }
        }
        
        // answer
        return dp[n][m];
    }
}
