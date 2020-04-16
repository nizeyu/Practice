class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 ) {
            return false;
        }
        
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int l = 0;
        int r = m * n - 1;
        while(l + 1 < r) {
            int mid = l + (r - l) / 2;
            int num = matrix[mid/n][mid%n];
            
            if (target == num) {
                return true;
            } else if (target < num) {
                r = mid;
            } else {
                l = mid;
            }
        }
        
        if (matrix[l/n][l%n] == target) {
            return true;
        }
        
        if (matrix[r/n][r%n] == target) {
            return true;
        }
        
        return false;
    }
}
