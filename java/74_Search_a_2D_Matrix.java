class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int row = matrix.length, col = matrix[0].length;
        int left = 0, right = row * col - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int curr_row = mid / col;
            int curr_col = mid % col;
            if (matrix[curr_row][curr_col] < target) {
                left = mid;
            }
            else if (matrix[curr_row][curr_col] > target) {
                right = mid;
            }
            else {
                return true;
            }
        }
        if (matrix[left / col][left % col] == target) return true;
        if (matrix[right / col][right % col] == target) return true;
        return false;        
    }
}