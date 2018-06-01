// Using a 2D array to record the count of living neighboars of each cell
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] state = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update(board, state, i, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1 && state[i][j] < 2) board[i][j] = 0;
                else if (board[i][j] == 1 && (state[i][j] == 2 || state[i][j] == 3)) board[i][j] = 1;
                else if (board[i][j] == 1 && state[i][j] > 3) board[i][j] = 0;
                else if (board[i][j] == 0 && state[i][j] == 3) board[i][j] = 1;
            }
        }        
    }
    public void update(int[][] board, int[][] state, int i, int j) {
        for (int dealtaI = -1; dealtaI <= 1; dealtaI++) {
            for (int dealtaJ = -1; dealtaJ <= 1; dealtaJ++) {
                if (dealtaI == 0 && dealtaJ == 0) continue;
                int newI = i + dealtaI;
                int newJ = j + dealtaJ;
                if (newI >= 0 && newI < board.length && newJ >=0 && newJ < board[0].length && board[newI][newJ] == 1) {
                    state[i][j]++;
                }
            }
        }
    }
}


class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update(board, i, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveCount = Math.abs(board[i][j]) - 1;
                if (board[i][j] > 0 && liveCount < 2) board[i][j] = 0;
                else if (board[i][j] > 0 && (liveCount == 2 || liveCount == 3)) board[i][j] = 1;
                else if (board[i][j] > 0 && liveCount > 3) board[i][j] = 0;
                else if (board[i][j] < 0 && liveCount == 3) board[i][j] = 1;
                else {
                    board[i][j] = board[i][j] > 0 ? 1 : 0;
                }
            }
        }        
    }
    public void update(int[][] board, int i, int j) {
        int liveCount = 1;
        for (int dealtaI = -1; dealtaI <= 1; dealtaI++) {
            for (int dealtaJ = -1; dealtaJ <= 1; dealtaJ++) {
                if (dealtaI == 0 && dealtaJ == 0) continue;
                int newI = i + dealtaI;
                int newJ = j + dealtaJ;
                if (newI >= 0 && newI < board.length && newJ >=0 && newJ < board[0].length && board[newI][newJ] > 0) {
                    liveCount++;
                }
            }
        }
        liveCount = board[i][j] == 1 ? liveCount : -1 * liveCount;
        board[i][j] = liveCount;
    }
}