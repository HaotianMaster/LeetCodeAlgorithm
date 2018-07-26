class Solution {
    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int top = i == 0 ? 0 : res[i - 1][j];
                int left = j == 0 ? 0 : res[i][j - 1];
                res[i][j] = top == 0 && left == 0 ? 1 : top + left;
            }
        }
        return res[m-1][n-1];
    }
}

// DFS, Time Limit Exceeded
class Solution {
    public int res = 0;
    public int uniquePaths(int m, int n) {
        uniquePathsHelper(m, n, 1, 1);
        return res;
    }
    public void uniquePathsHelper(int row, int col, int x, int y) {
        if (x > row || y > col) return;
        if (x == row && y == col) {
            res++;
            return;
        }
        uniquePathsHelper(row, col, x + 1, y);
        uniquePathsHelper(row, col, x, y + 1);
    }
}