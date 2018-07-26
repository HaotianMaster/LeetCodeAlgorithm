class Solution {
    public boolean exist(char[][] board, String word) {
        if (board==null) return false;
        boolean[][] used = new boolean[board.length][board[0].length];
        boolean exist = false;
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                exist = existHelper(board, used, word.toCharArray(), 0, i, j);
                if (exist) return true;
            }
        }
        return false;
    }
    public boolean existHelper(char[][] board, boolean[][] used, char[] word, int index, int row, int col) {
        // Have already find all the char.
        if (index==word.length) return true;
        // Current position is out of range.
        if (row<0 || row>=board.length || col<0 || col>=board[0].length) return false;
        // Current position is not correct.
        if (board[row][col]!=word[index]) return false;
        // Current position has been visited before.
        if (used[row][col]==true) return false;
        
        //Pass all the base cases, continue.
        used[row][col] = true;
        boolean existed = false;
        // Down
        existed = existHelper(board, used, word, index+1, row+1, col);
        if (existed) return true;
        // Up
        existed = existHelper(board, used, word, index+1, row-1, col);
        if (existed) return true;
        // Left
        existed = existHelper(board, used, word, index+1, row, col-1);
        if (existed) return true;
        // Right
        existed = existHelper(board, used, word, index+1, row, col+1);
        if (existed) return true;
        
        //Cannot find the word, prepare for the next start point. 
        used[row][col] = false;        
        return false;
    }
}

class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        int m = board.length, n = board[0].length;
        boolean[][] memory = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (existHelper(board, word, memory, i, j, 0)) return true;
            }
        }
        return false;
    }
    public boolean existHelper(char[][] board, String word, boolean[][] memory, int x, int y, int idx) {
        if (idx == word.length()) return true;
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || memory[x][y] == true) return false;
        if (board[x][y] != word.charAt(idx)) return false;
        
        memory[x][y] = true;
        boolean existed = false;
        existed = existHelper(board, word, memory, x + 1, y, idx + 1);
        if (existed) return true;
        existed = existHelper(board, word, memory, x - 1, y, idx + 1);
        if (existed) return true;
        existed = existHelper(board, word, memory, x, y - 1, idx + 1);
        if (existed) return true;
        existed = existHelper(board, word, memory, x, y + 1, idx + 1);
        if (existed) return true;
        memory[x][y] = false;
        
        return false;
    }
}