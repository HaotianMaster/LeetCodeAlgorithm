class Solution {
    public int countBattleships(char[][] board) {
        int res = 0;
        int m = board.length;
        int n = board[0].length;
        int[][] memory = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X' && memory[i][j] == 0) {
                    dfs(board, memory, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    public void dfs(char[][] board, int[][] memory, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || memory[i][j] == 1 || board[i][j] == '.') return;
        memory[i][j] = 1;
        dfs(board, memory, i + 1, j);
        dfs(board, memory, i - 1, j);
        dfs(board, memory, i, j + 1);
        dfs(board, memory, i, j - 1);
    }
}

//In order to do this in one-pass without extra space and without modifying 
//the input array, we need to utilizing this fact and keep in mind that 
//a battle ship can only expands harizontally or vertically, battle ships are not adjacent.
class Solution {
    public int countBattleships(char[][] board) {
        int res = 0;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X' && (i == 0 || board[i - 1][j] == '.') && (j == 0 || board[i][j - 1] == '.')) {
                    res++;
                }
            }
        }
        return res;
    }
}