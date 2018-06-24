class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = row * col - 1;
        int curr_row, curr_col;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            curr_row = mid / col;
            curr_col = mid % col;
            if (matrix[curr_row][curr_col] < target) {
                left = mid + 1;
            }
            else if (matrix[curr_row][curr_col] > target) {
                right = mid - 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
}