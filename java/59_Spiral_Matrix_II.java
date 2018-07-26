class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0, left = 0, bot = n - 1, right = n - 1;
        int num = 1;
        while (top < bot && left < right) {
            for (int i = left; i < right; i++) matrix[top][i] = num++;
            for (int i = top; i < bot; i++) matrix[i][right] = num++;
            for (int i = right; i > left; i--) matrix[bot][i] = num++;
            for (int i = bot; i > top; i--) matrix[i][left] = num++;
            top++;
            left++;
            right--;
            bot--;
        }
        if (n % 2 != 0) matrix[n / 2][n / 2] = num;
        return matrix;
    }
}