class Solution {
    // 自顶向下
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0 || triangle.get(0) == null || triangle.get(0).size() == 0) {
            return 0;
        }
        
        int n = triangle.size();
        // 状态定义
        // dp[i][j]:表示从0，0出发走到i, j的最小路径长度
        int[][] dp = new int[n][n];
        
        // 初始化，起点
        dp[0][0] = triangle.get(0).get(0);
        
        // 初始化三角形的左边和右边
        for (int i = 1; i < n; i++) {
            dp[i][0] = triangle.get(i).get(0) + dp[i - 1][0];
            dp[i][i] = triangle.get(i).get(i) + dp[i - 1][i - 1];
        }
        
        // 循环递归求解
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
            }
        }
        
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp[n-1][j]);
        }
        
        return res;
    }
}
