class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0];
        int r = matrix[n - 1][n - 1];
        
        while (l < r) {
            int mid = l + (r - l) / 2;
            int temp = search_lower_than_mid(matrix, mid);
            if (k <= temp) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        return l;
    }
    
    private int search_lower_than_mid(int[][] matrix, int x) {
        int n = matrix.length;
		int i = n - 1;
        int j = 0;
        int cnt = 0;
		while (i >= 0 && j < n) {
			if (x < matrix[i][j]) {
				i--;
			} else {
                j++;
				cnt += i + 1;
            }
		}
		return cnt;
	}
}
