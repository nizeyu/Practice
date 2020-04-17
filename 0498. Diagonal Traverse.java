class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return new int[0];
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] res = new int[m * n];
        int r = 0, c = 0, k = 0;
        
        int[][] dirs = {{-1, 1}, {1, -1}}; // 右上 和 左下
        
        for(int i = 0; i < m * n; ++i) {
            res[i] = matrix[r][c];
            
            r += dirs[k][0];
            c += dirs[k][1];
            
            if (r >= m) { // 左下角
                r = m - 1;
                c += 2;
                k = 1 - k;
            }
            
            if (c >= n) { // 右上角
                c = n - 1;
                r += 2;
                k = 1 - k;
            }
            
            if (r < 0) {
                r = 0;
                k = 1 - k;
            }
            
            if (c < 0) {
                c = 0;
                k = 1 - k;
            }
        }
        
        return res;
    }
}
