class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                int top = i == 0 || obstacleGrid[i-1][j] == 1 ? 0 : res[i-1][j];
                int left = j == 0 || obstacleGrid[i][j-1] == 1 ? 0 : res[i][j-1];
                res[i][j] = i == 0 && j == 0 ? 1 : top + left;
            }
        }
        return res[n-1][m-1];        
    }
}

// Better solution, beat 100%.
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    obstacleGrid[i][j] = 1;
                    continue;
                }
                if (obstacleGrid[i][j] == 1) obstacleGrid[i][j] = 0;
                else if (i == 0) obstacleGrid[i][j] = obstacleGrid[i][j-1];
                else if (j == 0) obstacleGrid[i][j] = obstacleGrid[i-1][j];
                else obstacleGrid[i][j] = obstacleGrid[i][j-1] + obstacleGrid[i-1][j];
            }
        }
        return obstacleGrid[m-1][n-1];        
    }
}