class Solution {
    int res = 0;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        // Using memory to record the longest increasing path starting from current position. 
        int[][] memory = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res = Math.max(res, helper(matrix, memory, i, j, 0, 0));
            }
        }
        return res;
    }
    public int helper(int[][] matrix, int[][] memory, int i, int j, int deltaI, int deltaJ) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return 0;
        if (deltaI != 0 && matrix[i - deltaI][j] <= matrix[i][j]) return 0;
        if (deltaJ != 0 && matrix[i][j - deltaJ] <= matrix[i][j]) return 0;
        if (memory[i][j] > 0) return memory[i][j];
        int up = 1 + helper(matrix, memory, i - 1, j, -1, 0);
        int down = 1 + helper(matrix, memory, i + 1, j, 1, 0);
        int left = 1 + helper(matrix, memory, i, j - 1, 0, -1);
        int right = 1 + helper(matrix, memory, i, j + 1, 0, 1);
        memory[i][j] = Math.max(up, Math.max(down, Math.max(left, Math.max(right, 1))));
        return memory[i][j];
    }
}