class Solution {
    int res = 0;  
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] memory = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && memory[i][j] == false) {
                    dfs(grid, i, j, memory);
                    res++;
                }
            }
        }
        return res;      
    }
    
    public void dfs(char[][] grid, int x, int y, boolean[][] memory) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return;
        if (grid[x][y] == '0' || memory[x][y] == true) return;
        memory[x][y] = true;
        dfs(grid, x+1, y, memory);
        dfs(grid, x-1, y, memory);
        dfs(grid, x, y+1, memory);
        dfs(grid, x, y-1, memory);
    }
}