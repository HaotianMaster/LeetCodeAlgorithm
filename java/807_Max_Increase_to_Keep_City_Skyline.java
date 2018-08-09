class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int len = grid.length;
        int[] vertical = new int[len];
        int[] horizontal = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                vertical[j] = Math.max(vertical[j], grid[i][j]);
                horizontal[i] = Math.max(horizontal[i], grid[i][j]);
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++)
            for (int j = 0; j < len; j++)
                res += Math.min(horizontal[i], vertical[j]) - grid[i][j];
        return res;        
    }
}