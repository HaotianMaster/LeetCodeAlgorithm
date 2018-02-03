// Recursive brute force. O(n^2) time.
class Solution {
    public int longestLine(int[][] M) {
        if (M == null) return 0;       
        int max = 0;
        for (int i=0; i<M.length; i++) {
            for (int j=0; j<M[0].length; j++) {    
                for (int k=0; k<8; k++) {
                    int count = 0;
                    count = countHelper(M, count, i, j, k);                
                    max = Math.max(max, count);                    
                }
            }
        }
        return max;
    }
    public int countHelper(int[][] M, int count, int row, int col, int direction) {
        // Current position is out of range.
        if (row < 0 || row >= M.length || col < 0 || col >= M[0].length) return count;
        // Current position is not correct.
        if (M[row][col] != 1) return count;
        
        //Pass all the base cases, continue.
        count++;
        
        if (direction == 0) count = countHelper(M, count, row+1, col, direction); // Down     
        else if (direction == 1) count = countHelper(M, count, row-1, col, direction); // Up       
        else if (direction == 2) count = countHelper(M, count, row, col-1, direction); // Left       
        else if (direction == 3) count = countHelper(M, count, row, col+1, direction); // Right        
        else if (direction == 4) count = countHelper(M, count, row-1, col-1, direction); // LeftUp        
        else if (direction == 5) count = countHelper(M, count, row+1, col-1, direction); // LeftDown        
        else if (direction == 6) count = countHelper(M, count, row-1, col+1, direction); // RightUp        
        else if (direction == 7) count = countHelper(M, count, row+1, col+1, direction); // RightDown
              
        return count;
    }
}