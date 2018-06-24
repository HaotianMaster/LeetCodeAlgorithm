class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return false;
        // check each row;
        for (int row = 0; row < 9; row++) {
            boolean[] taken = new boolean[9];
            for (int i = 0; i < 9; i++) {
                if (board[row][i] != '.') {
                    if (taken[board[row][i] - '1'] == true) return false;
                    else taken[board[row][i] - '1'] = true;
                } 
            }
        }
        
        // check each column;
        for (int col = 0; col < 9; col++) {
            boolean[] taken = new boolean[9];
            for (int i = 0; i < 9; i++) {
                if (board[i][col] != '.') {
                    if (taken[board[i][col] - '1'] == true) return false;
                    else taken[board[i][col] - '1'] = true;
                } 
            }
        }
        
        // check each 3*3 box;
        for (int box = 0; box < 9; box++) {
            boolean[] taken = new boolean[9];
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    char ch = board[row + 3 * (box / 3)][col + 3 * (box % 3)];
                    if (ch != '.') {
                        if (taken[ch - '1'] == true) return false;
                        else taken[ch - '1'] = true;
                    } 
                }
            }
        }
        
        return true;
    }
}