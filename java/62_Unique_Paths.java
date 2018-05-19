class Solution {
    public int uniquePaths(int m, int n) {
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int top = i == 0 ? 0 : res[i-1][j];
                int left = j == 0 ? 0 : res[i][j-1];
                res[i][j] = top == 0 && left == 0 ? 1 : top + left;
            }
        }
        return res[n-1][m-1];
    }
}