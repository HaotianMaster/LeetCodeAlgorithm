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