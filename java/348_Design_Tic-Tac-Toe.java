class TicTacToe {
    //Use a n*n array to represent the playground. Put 1 and 2 on the corresponding position when player1 and player make move.
    int[][] playground;
    int[] count;
    int n;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        this.count = new int[2];
        this.playground = new int[n][n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        playground[row][col] = player;
        count[player - 1]++;
        // If count[player - 1] < n, we don't even need to check.
        if (count[player - 1] >= n) {
            //check horizontally
            int num = 0;
            for (int i = 0; i < n; i++) {
                if (playground[row][i] == player) {
                    num++;
                }
                else{
                    break;
                }
            }
            if (num == n) return player;
            //check vertically
            num = 0;
            for (int i = 0; i < n; i++) {
                if (playground[i][col] == player) {
                    num++;
                }
                else{
                    break;
                }
            }  
            if (num == n) return player;
            //check diagonally if necessary
            num = 0;
            if (row == col) {
                for (int i = 0; i < n; i++) {
                    if (playground[i][i] == player) {
                        num++;
                    }
                    else{
                        break;
                    }                    
                }
            }
            if (num == n) return player;
            
            num = 0;
            if (row + col == n - 1) {
                for (int i = 0; i < n; i++) {
                    if (playground[i][n-1-i] == player) {
                        num++;
                    }
                    else{
                        break;
                    }                    
                }
            }
            if (num == n) return player;
        }
        return 0;
    }
}

//Actually if we want to know if a player win or not, we don't need to check every single position on the playground. 
//All we need is to know the number of moves this player had on the corresponding row, column and diagonal.
class TicTacToe {
    int[][] rows;
    int[][] cols;
    int[][] diag;
    int n;
    int playerNum = 2;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        this.rows = new int[n][playerNum];
        this.cols = new int[n][playerNum];
        this.diag = new int[2][playerNum];        
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        rows[row][player - 1]++;
        cols[col][player - 1]++;
        if (row == col) diag[0][player - 1]++;
        if (row + col == n - 1) diag[1][player - 1]++;
        if (rows[row][player - 1] == n || cols[col][player - 1] == n || diag[0][player - 1] == n || diag[1][player - 1] == n) {
            return player;
        }
        return 0;
    }
}


