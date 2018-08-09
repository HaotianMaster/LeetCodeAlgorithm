class Solution {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        //Edge cases
        if (hits == null || hits.length == 0 || hits[0].length == 0) return null;
        int[] res = new int[hits.length];
        if (grid == null || grid.length == 0 || grid[0].length == 0) return res;

        //Remove all bricks in hits. If the cell is originly 1, we set it to -1 so that we can add the brick back;
        for (int[] hit : hits) {
            if (grid[hit[0]][hit[1]] == 1) grid[hit[0]][hit[1]] = -1;
        }
        //DFS from the first row (roof), set all cells of bricks to 2 so that we know these cells have been visited.
        //Set all cells attached to the roof to 2
        for (int j = 0; j < grid[0].length; j++) {
            dfs(grid, 0, j);
        }
        //Iterate from the last hit to the first one, i.e., put the erasured bricks back.
        //If the cell is 0, continue;
        //Else, check if the cell is connected to the roof. 
        //If not connected, reuse the dfs function to count all the connected bricks (cells with value 1).
        //These are bricks that fell down when we erase the hit!
        //Remember to minus 1, which is the brick we erased.
        for (int k = hits.length - 1; k >= 0; k--) {
            if (grid[hits[k][0]][hits[k][1]] == 0) res[k] = 0;
            else {
                grid[hits[k][0]][hits[k][1]] = 1;
                if (!connectedToRoof(grid, hits[k][0], hits[k][1])) continue;
                int count = dfs(grid, hits[k][0], hits[k][1]);
                res[k] = count - 1;
            }
        }
        return res;
    }
    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) return 0;
        grid[i][j] = 2;
        int count = 1;
        count += dfs(grid, i + 1, j);
        count += dfs(grid, i - 1, j);
        count += dfs(grid, i, j + 1);
        count += dfs(grid, i, j - 1);
        return count;
    }
    public boolean connectedToRoof(int[][] grid, int i, int j) {
        if (i == 0) return true;
        if (i + 1 >= 0 && i + 1 < grid.length && j >= 0 && j < grid[0].length && grid[i + 1][j] == 2) return true;
        if (i - 1 >= 0 && i - 1 < grid.length && j >= 0 && j < grid[0].length && grid[i - 1][j] == 2) return true;
        if (i >= 0 && i < grid.length && j + 1 >= 0 && j + 1 < grid[0].length && grid[i][j + 1] == 2) return true;
        if (i >= 0 && i < grid.length && j - 1 >= 0 && j - 1 < grid[0].length && grid[i][j - 1] == 2) return true;
        return false;
    }
}